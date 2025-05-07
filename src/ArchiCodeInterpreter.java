import java.util.HashMap;
import java.util.Map;

public class ArchiCodeInterpreter extends ArchiCodeBaseVisitor<Object> {
    private final Map<String, String> symbolTable;
    private final Map<String, Variable> variables = new HashMap<>();

    public ArchiCodeInterpreter(Map<String, String> symbolTable) {
        this.symbolTable = symbolTable;
    }

    @Override
    public Void visitProgram(ArchiCodeParser.ProgramContext ctx) {

        boolean coreExecuted = false;

        for (ArchiCodeParser.StatementContext stmt : ctx.statement()) {
            if (stmt.coreStatement() != null) {
                if (coreExecuted) {
                    int line = stmt.getStart().getLine();
                    System.err.println("Błąd (linia " + line + "): tylko jeden blok Core jest dozwolony.");
                    System.exit(1);
                }
                coreExecuted = true;
                visit(stmt);
            } else if (stmt.blueprintStatement() != null) {

            } else {
                int line = stmt.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): instrukcja '" + stmt.getText() + "' znajduje się poza blokiem Core lub blueprint.");
                System.exit(1);
            }
        }

        if (!coreExecuted) {
            System.err.println("Błąd: program musi zawierać blok Core.");
            System.exit(1);
        }

        return null;
    }

    @Override
    public Void visitShowStatement(ArchiCodeParser.ShowStatementContext ctx) {
        Object value = visit(ctx.expr());
        System.out.println(value != null ? value : "<undefined>");
        return null;
    }

    @Override
    public Void visitDefineStatement(ArchiCodeParser.DefineStatementContext ctx) {
        String varName = ctx.VarName().getText();
        if (variables.containsKey(varName)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): zmienna \"" + varName + "\" już istnieje.");
            System.exit(1);
        }

        String declaredType = ctx.type() != null ? ctx.type().getText() : "auto";
        Object value = visit(ctx.expr());

        String actualType = inferType(value);
        if (!declaredType.equals("auto") && !declaredType.equals(actualType)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd(linia "+ line +"): niezgodność typów przy deklaracji zmiennej \"" + varName + "\". Oczekiwano: " + declaredType + ", otrzymano: " + actualType);
            System.exit(1);
        }

        variables.put(varName, new Variable(VarType.fromString(actualType), value));
        return null;
    }

    @Override
    public Void visitAssignStatement(ArchiCodeParser.AssignStatementContext ctx) {
        String varName = ctx.VarName().getText();
        if (!variables.containsKey(varName)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): zmienna \"" + varName + "\" nie została zadeklarowana.");
            System.exit(1);
        }

        Object value = visit(ctx.expr());
        Variable var = variables.get(varName);
        VarType newType = VarType.fromString(inferType(value));

        if (newType != var.getType()) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): niezgodność typów przy przypisaniu do \"" + varName + "\". Oczekiwano: " + var.getType() + ", otrzymano: " + newType);
            System.exit(1);
        }

        var.setValue(value);
        return null;
    }

    @Override
    public Object visitVarExpr(ArchiCodeParser.VarExprContext ctx) {
        String varName = ctx.VarName().getText();
        Variable var = variables.get(varName);
        if (var == null) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): zmienna \"" + varName + "\" nie została zadeklarowana.");
            System.exit(1);
        }
        return var.getValue();
    }

    @Override
    public Object visitAddSubExpr(ArchiCodeParser.AddSubExprContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        String op = ctx.op.getText();

        if (left instanceof Integer && right instanceof Integer) {
            int a = (Integer) left;
            int b = (Integer) right;
            return op.equals("+") ? a + b : a - b;
        }
        int line = ctx.getStart().getLine();
        System.err.println("Błąd (linia " + line + "): Nieobsługiwane typy dla " + op);
        System.exit(1);
        return null;
    }

    @Override
    public Object visitMulDivExpr(ArchiCodeParser.MulDivExprContext ctx) {
        Object left = visit(ctx.expr(0));
        Object right = visit(ctx.expr(1));
        String op = ctx.op.getText();

        if (left instanceof Integer && right instanceof Integer) {
            int a = (Integer) left;
            int b = (Integer) right;
            return op.equals("*") ? a * b : a / b;
        }

        int line = ctx.getStart().getLine();
        System.err.println("Błąd (linia " + line + "): Nieobsługiwane typy dla " + op);
        System.exit(1);
        return null;
    }

    @Override
    public Object visitEqExpr(ArchiCodeParser.EqExprContext ctx) {
        Object a = visit(ctx.expr(0));
        Object b = visit(ctx.expr(1));
        return a.equals(b);
    }

    @Override
    public Object visitLtExpr(ArchiCodeParser.LtExprContext ctx) {
        Object a = visit(ctx.expr(0));
        Object b = visit(ctx.expr(1));
        return ((Integer) a) < ((Integer) b);
    }

    @Override
    public Object visitGtExpr(ArchiCodeParser.GtExprContext ctx) {
        Object a = visit(ctx.expr(0));
        Object b = visit(ctx.expr(1));
        return ((Integer) a) > ((Integer) b);
    }

    @Override
    public Object visitLogicExpr(ArchiCodeParser.LogicExprContext ctx) {
        boolean left = (Boolean) visit(ctx.expr(0));
        boolean right = (Boolean) visit(ctx.expr(1));
        return ctx.op.getText().equals("and") ? left && right : left || right;
    }

    @Override
    public Object visitNotExpr(ArchiCodeParser.NotExprContext ctx) {
        return !(Boolean) visit(ctx.expr());
    }

    @Override
    public Object visitBoolTrueExpr(ArchiCodeParser.BoolTrueExprContext ctx) {
        return true;
    }

    @Override
    public Object visitBoolFalseExpr(ArchiCodeParser.BoolFalseExprContext ctx) {
        return false;
    }

    @Override
    public Object visitIntExpr(ArchiCodeParser.IntExprContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Object visitStringExpr(ArchiCodeParser.StringExprContext ctx) {
        String text = ctx.getText();
        return text.substring(1, text.length() - 1); // usuń cudzysłowy
    }

    private String inferType(Object value) {
        if (value instanceof Integer) return "int";
        if (value instanceof Boolean) return "bool";
        if (value instanceof String) return "string";
        if (value instanceof Float) return "float";
        return "unknown";
    }
}