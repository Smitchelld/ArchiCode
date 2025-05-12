import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArchiCodeInterpreter extends ArchiCodeBaseVisitor<Object> {
    private final Map<String, String> symbolTable;
    private final Map<String, Variable> variables = new HashMap<>();
    private final Map<String, Map <String, Blueprint>> blueprints = new HashMap<>();


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
                visit(stmt);
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

    @Override
    public Object visitOrExpr(ArchiCodeParser.OrExprContext ctx) {
        Object left = visit(ctx.andExpr(0));
        for(int i = 1; i < ctx.andExpr().size(); i++) {
            Object right = visit(ctx.andExpr(i));
            left = (boolean)left || (boolean)right;
        }
        return left;
    }

    @Override
    public Object visitAndExpr(ArchiCodeParser.AndExprContext ctx) {
        Object left = visit(ctx.equalityExpr(0));
        for(int i = 1; i < ctx.equalityExpr().size(); i++) {
            Object right = visit(ctx.equalityExpr(i));
            left = (boolean)left && (boolean)right;
        }
        return left;
    }

    @Override
    public Object visitEqualityExpr(ArchiCodeParser.EqualityExprContext ctx) {
        Object left = visit(ctx.relationalExpr(0));
        for(int i = 1; i < ctx.relationalExpr().size(); i++) {
            Object right = visit(ctx.relationalExpr(i));
            String op = ctx.getChild(2*i - 1).getText();
            left = switch (op) {
                case "==" -> left.equals(right);
                case "!=" -> !left.equals(right);
                default -> left;
            };
        }
        return left;
    }

    @Override
    public Object visitRelationalExpr(ArchiCodeParser.RelationalExprContext ctx) {
        Object left = visit(ctx.addSubExpr(0));
        for(int i = 1; i < ctx.addSubExpr().size(); i++) {
            Object right = visit(ctx.addSubExpr(i));
            String op = ctx.getChild(2*i - 1).getText();
            if(!(left instanceof Integer) || !(right instanceof Integer)) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Nie można porównać:" + left.getClass().getSimpleName() + " i " + right.getClass().getSimpleName());
                System.exit(1);
            }
            int l = (int)left;
            int r = (int)right;
            left = switch(op){
                case "<" -> l < r;
                case ">" -> l > r;
                case "<=" -> l <= r;
                case ">=" -> l >= r;
                default -> left;
            };
        }
        return left;
    }

    @Override
    public Object visitAddSubExpr(ArchiCodeParser.AddSubExprContext ctx) {
        Object left = visit(ctx.mulDivExpr(0));
        for(int i = 1; i < ctx.mulDivExpr().size(); i++) {
            Object right = visit(ctx.mulDivExpr(i));
            String op = ctx.getChild(2 * i - 1).getText();
            if (!(left instanceof Integer) || !(right instanceof Integer)) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Nie można dodawać/odejmować:" + left.getClass().getSimpleName() + " i " + right.getClass().getSimpleName());
                System.exit(1);
            }
            int l = (int) left;
            int r = (int) right;
            left = switch (op) {
                case "+" -> l + r;
                case "-" -> l - r;
                default -> left;
            };
        }
        return left;
    }

    @Override
    public Object visitMulDivExpr(ArchiCodeParser.MulDivExprContext ctx) {
        Object left = visit(ctx.unaryExpr(0));
        for(int i = 1; i < ctx.unaryExpr().size(); i++) {
            Object right = visit(ctx.unaryExpr(i));
            String op = ctx.getChild(2 * i - 1).getText();
            if (!(left instanceof Integer) || !(right instanceof Integer)) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Nie można mnożyć/dzielić:" + left.getClass().getSimpleName() + " i " + right.getClass().getSimpleName());
                System.exit(1);
            }
            int l = (int) left;
            int r = (int) right;
            if (op.equals("/") && r == 0) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Nie można dzielić przez 0");
                System.exit(1);
            }
            left = switch (op) {
                case "*" -> l * r;
                case "/" -> l / r;
                default -> left;
            };
        }
        return left;
    }

    @Override
    public Object visitUnaryExpr(ArchiCodeParser.UnaryExprContext ctx) {
        if(ctx.getChildCount() == 2) {
            String op = ctx.getChild(0).getText();
            Object value = visit(ctx.unaryExpr());
            return switch (op) {
                case "-" -> -(int) value;
                case "+" -> +(int) value;
                case "not" -> !(boolean) value;
                default -> value;
            };
        }
        return visit(ctx.atom());
    }

    @Override
    public Object visitParenExpr(ArchiCodeParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Object visitBlueprintStatement(ArchiCodeParser.BlueprintStatementContext ctx) {
        String blueprintName = ctx.CapitalVarName().getText();
        String signature = Blueprint.generateSignature(ctx.paramList());
        Object returnValue = visit(ctx.expr());
        String returnName = ctx.VarName().getText();
        Variable returnVariable = new Variable(VarType.fromString(ctx.type().getText()), returnValue);
        Map<String, String> params = new HashMap<>();
        if(ctx.paramList() != null) {
            for(ArchiCodeParser.ParamContext param : ctx.paramList().param()) {
                params.put(param.VarName().getText(), param.type().getText());
            }
        }

        Blueprint blueprint = new Blueprint(blueprintName, signature, params, ctx.block(),returnName, returnVariable);
        blueprints.computeIfAbsent(blueprintName, k -> new HashMap<>());
        Map<String, Blueprint> overloads = blueprints.get(blueprintName);
        if(overloads.containsKey(signature)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Blueprint: " +blueprintName+"("+ signature + ") został już zdefiniowany.");
            System.exit(1);
        }
        overloads.put(signature, blueprint);
        return null;
    }

    @Override
    public Object visitBlueprintCallStatement(ArchiCodeParser.BlueprintCallStatementContext ctx) {
        //System.out.println("visitBlueprintCallStatement");
        String blueprintName = ctx.CapitalVarName().getText();
        String signature = generateCallSignature(ctx);
        if(!blueprints.containsKey(blueprintName)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Blueprint: " +blueprintName+"("+ signature + ") nie został zdefiniowany.");
            System.exit(1);
        }
        Map<String, Blueprint> overloads = blueprints.get(blueprintName);
        if(!overloads.containsKey(signature)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Blueprint: " +blueprintName+"("+ signature + ") nie został zdefiniowany.");
            System.exit(1);
        }
        Blueprint blueprint = overloads.get(signature);
        Map<String, Variable> localVariables = new HashMap<>(variables);
        for(int i = 0; i < blueprint.getParams().size(); i++) {
            String paramName = blueprint.getParams().keySet().toArray(new String[0])[i];
            Object paramValue = visit(ctx.expr(i));
            String paramType = inferType(paramValue);
            if(!paramType.equals(blueprint.getParams().get(paramName))) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Argument: " +paramName+" wymaga typu" + blueprint.getParams().get(paramName) + ", ale otrzymano: " + paramType);
                System.exit(1);
            }
            localVariables.put(paramName, new Variable(VarType.fromString(paramType), paramValue));
        }

        ArchiCodeInterpreter localInterpreter = new ArchiCodeInterpreter(symbolTable);
        localInterpreter.variables.putAll(localVariables);

        return localInterpreter.visit(blueprint.getBlock());
    }

    @Override
    public Object visitFuncCallExpr(ArchiCodeParser.FuncCallExprContext ctx) {
        //System.out.println("visitBlueprintCallStatement");
        String blueprintName = ctx.CapitalVarName().getText();
        String signature = generateCallSignature(ctx);
        if(!blueprints.containsKey(blueprintName)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Blueprint: " +blueprintName+"("+ signature + ") nie został zdefiniowany.");
            System.exit(1);
        }
        Map<String, Blueprint> overloads = blueprints.get(blueprintName);
        if(!overloads.containsKey(signature)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Blueprint: " +blueprintName+"("+ signature + ") nie został zdefiniowany.");
            System.exit(1);
        }
        Blueprint blueprint = overloads.get(signature);
        Map<String, Variable> localVariables = new HashMap<>(variables);
        for(int i = 0; i < blueprint.getParams().size(); i++) {
            String paramName = blueprint.getParams().keySet().toArray(new String[0])[i];
            Object paramValue = visit(ctx.expr(i));
            String paramType = inferType(paramValue);
            if(!paramType.equals(blueprint.getParams().get(paramName))) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Argument: " +paramName+" wymaga typu" + blueprint.getParams().get(paramName) + ", ale otrzymano: " + paramType);
                System.exit(1);
            }
            localVariables.put(paramName, new Variable(VarType.fromString(paramType), paramValue));
        }

        ArchiCodeInterpreter localInterpreter = new ArchiCodeInterpreter(symbolTable);
        localInterpreter.variables.put(blueprint.getReturnName(), blueprint.getReturnVariable());
        localInterpreter.variables.putAll(localVariables);

        localInterpreter.visit(blueprint.getBlock());
        var ret = localInterpreter.variables.get(blueprint.getReturnName()).getValue();
        if(VarType.fromString(inferType(ret)) != blueprint.getReturnVariable().getType()){
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Funkcja powinna zwracać" + blueprint.getReturnVariable().getType() + ", ale zwraca: " + inferType(ret));
            System.exit(1);
        }
        return ret;
    }

    private String inferType(Object value) {
        if (value instanceof Integer) return "int";
        if (value instanceof Boolean) return "bool";
        if (value instanceof String) return "string";
        if (value instanceof Float) return "float";
        return "unknown";
    }

    private String generateCallSignature(ArchiCodeParser.BlueprintCallStatementContext ctx) {
        StringBuilder signature = new StringBuilder();
        for (ArchiCodeParser.ExprContext expr : ctx.expr()) {
            Object value = visit(expr);
            String type = inferType(value);
            if(!signature.isEmpty()) signature.append(",");
            signature.append(type);
        }
        return signature.toString();
    }

    private String generateCallSignature(ArchiCodeParser.FuncCallExprContext ctx) {
        StringBuilder signature = new StringBuilder();


        for (ArchiCodeParser.ExprContext exprCtx : ctx.expr()) {
            Object value = visit(exprCtx);
            String type = inferType(value);
            signature.append(type).append(",");
        }
        if (signature.length() > 0) {
            signature.setLength(signature.length() - 1);
        }

        return signature.toString();
    }
}