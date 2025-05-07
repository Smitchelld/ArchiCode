import java.util.HashMap;
import java.util.Map;

public class ArchiCodeInterpreter extends ArchiCodeBaseVisitor<Void> {
    private final Map<String, Object> memory = new HashMap<>();

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
        Object value = visitExpr(ctx.expr());
        System.out.println(value != null ? value : "<undefined>");
        return null;
    }

    @Override
    public Void visitDefineStatement(ArchiCodeParser.DefineStatementContext ctx) {
        String var = ctx.VarName().getText();
        if(memory.containsKey(var)) {
            int line = ctx.expr().getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Zmienna \""+ var +"\" juz istnieje");
            System.exit(1);
        }
        Object value = visitExpr(ctx.expr());
        memory.put(var, value);
        return null;
    }

    @Override
    public Void visitAssignStatement(ArchiCodeParser.AssignStatementContext ctx) {
        String var = ctx.VarName().getText();
        if(!memory.containsKey(var)) {
            int line = ctx.expr().getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Próba przypisania do nieistniejącej zmiennej");
            System.exit(1);
        }
        Object value = visitExpr(ctx.expr());
        memory.put(var, value);
        return null;
    }

    private Object visitExpr(ArchiCodeParser.ExprContext ctx) {
        if (ctx instanceof ArchiCodeParser.StringExprContext) {
            String text = ctx.getText();
            return text.substring(1, text.length() - 1); // usuń cudzysłowy
        } else if (ctx instanceof ArchiCodeParser.IntExprContext) {
            return Integer.parseInt(ctx.getText());
        } else if (ctx instanceof ArchiCodeParser.VarExprContext) {
            return memory.getOrDefault(ctx.getText(), "<undefined>");
        }
        return null;
    }
}