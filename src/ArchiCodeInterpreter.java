import java.util.HashMap;
import java.util.Map;

public class ArchiCodeInterpreter extends ArchiCodeBaseVisitor<Object> {
    private final Map<String, String> symbolTable;
    private final Map<String, Variable> variables = new HashMap<>();
    private final Map<String, Map <String, Blueprint>> blueprints;


    public ArchiCodeInterpreter(Map<String, String> symbolTable, Map<String, Map<String, Blueprint>> sharedBlueprints) {
        this.symbolTable = symbolTable;
        this.blueprints =sharedBlueprints;
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
                if( coreExecuted ) {
                    int line = stmt.getStart().getLine();
                    System.err.println("Błąd (linia " + line + "): deklaracja blueprint jest dozwolona tylko nad blokiem Core.");
                    System.exit(1);
                }
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
        for (int i = 1; i < ctx.relationalExpr().size(); i++) {
            Object right = visit(ctx.relationalExpr(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (left instanceof Number && right instanceof Number) {
                float l = ((Number) left).floatValue();
                float r = ((Number) right).floatValue();
                left = switch (op) {
                    case "==" -> l == r;
                    case "!=" -> l != r;
                    default -> left;
                };
            } else {
                left = switch (op) {
                    case "==" -> left.equals(right);
                    case "!=" -> !left.equals(right);
                    default -> left;
                };
            }
        }
        return left;
    }

    @Override
    public Object visitRelationalExpr(ArchiCodeParser.RelationalExprContext ctx) {
        Object left = visit(ctx.addSubExpr(0));
        for (int i = 1; i < ctx.addSubExpr().size(); i++) {
            Object right = visit(ctx.addSubExpr(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (!(left instanceof Number) || !(right instanceof Number)) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Nie można porównać: " + left.getClass().getSimpleName() + " i " + right.getClass().getSimpleName());
                System.exit(1);
            }

            float l = ((Number) left).floatValue();
            float r = ((Number) right).floatValue();

            switch (op) {
                case "<" -> left = l < r;
                case ">" -> left = l > r;
                case "<=" -> left = l <= r;
                case ">=" -> left = l >= r;
            }
        }
        return left;
    }

    @Override
    public Object visitAddSubExpr(ArchiCodeParser.AddSubExprContext ctx) {
        Object left = visit(ctx.mulDivExpr(0));

        for (int i = 1; i < ctx.mulDivExpr().size(); i++) {
            Object right = visit(ctx.mulDivExpr(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (!(left instanceof Number) || !(right instanceof Number)) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Operacja arytmetyczna tylko na liczbach.");
                System.exit(1);
            }

            // Sprawdź typy oryginalne
            boolean leftIsFloat = left instanceof Float;
            boolean rightIsFloat = right instanceof Float;

            if (!leftIsFloat && !rightIsFloat) {
                // int + int = int
                int l = ((Integer) left);
                int r = ((Integer) right);
                left = switch (op) {
                    case "+" -> l + r;
                    case "-" -> l - r;
                    default -> throw new RuntimeException("Nieznany operator: " + op);
                };
            } else {
                // float + coś = float
                float l = ((Number) left).floatValue();
                float r = ((Number) right).floatValue();
                left = switch (op) {
                    case "+" -> l + r;
                    case "-" -> l - r;
                    default -> throw new RuntimeException("Nieznany operator: " + op);
                };
            }
        }

        return left;
    }

    @Override
    public Object visitMulDivExpr(ArchiCodeParser.MulDivExprContext ctx) {
        Object left = visit(ctx.unaryExpr(0));

        for (int i = 1; i < ctx.unaryExpr().size(); i++) {
            Object right = visit(ctx.unaryExpr(i));
            String op = ctx.getChild(2 * i - 1).getText();

            if (!(left instanceof Number) || !(right instanceof Number)) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Operacja arytmetyczna tylko na liczbach.");
                System.exit(1);
            }

            boolean leftIsFloat = left instanceof Float;
            boolean rightIsFloat = right instanceof Float;

            switch (op) {
                case "*":
                    if (!leftIsFloat && !rightIsFloat) {
                        left = ((Integer) left) * ((Integer) right);
                    } else {
                        float l = ((Number) left).floatValue();
                        float r = ((Number) right).floatValue();
                        left = l * r;
                    }
                    break;

                case "/":
                    if (!leftIsFloat && !rightIsFloat) {
                        int divisor = (Integer) right;
                        if (divisor == 0) {
                            int line = ctx.getStart().getLine();
                            System.err.println("Błąd (linia " + line + "): Dzielenie przez 0");
                            System.exit(1);
                        }
                        left = ((Integer) left) / divisor;
                    } else {
                        float l = ((Number) left).floatValue();
                        float r = ((Number) right).floatValue();
                        if (r == 0.0f) {
                            int line = ctx.getStart().getLine();
                            System.err.println("Błąd (linia " + line + "): Dzielenie przez 0");
                            System.exit(1);
                        }
                        left = l / r;
                    }
                    break;

                default:
                    throw new RuntimeException("Nieznany operator: " + op);
            }
        }

        return left;
    }

    @Override
    public Object visitUnaryExpr(ArchiCodeParser.UnaryExprContext ctx) {
        if (ctx.getChildCount() == 2) {
            String op = ctx.getChild(0).getText();
            Object value = visit(ctx.unaryExpr());

            return switch (op) {
                case "-" -> (value instanceof Float) ? -((Float) value) : -((Integer) value);
                case "+" -> value;
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
        Map<String, String> params = new HashMap<>();

        if (ctx.paramList() != null) {
            for (ArchiCodeParser.ParamContext param : ctx.paramList().param()) {
                params.put(param.VarName().getText(), param.type().getText());
            }
        }

        Blueprint blueprint;
        if (ctx.type() != null && ctx.VarName() != null) {
            // Funkcja z wartością zwracaną
            Object returnValue = visit(ctx.expr());
            String returnName = ctx.VarName().getText();
            Variable returnVariable = new Variable(VarType.fromString(ctx.type().getText()), returnValue);
            blueprint = new Blueprint(blueprintName, signature, params, ctx.block(), returnName, returnVariable);
        } else {
            // Funkcja void
            blueprint = new Blueprint(blueprintName, signature, params, ctx.block());
        }

        blueprints.computeIfAbsent(blueprintName, k -> new HashMap<>());
        if (blueprints.get(blueprintName).containsKey(signature)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Blueprint " + blueprintName + "(" + signature + ") już istnieje.");
            System.exit(1);
        }

        blueprints.get(blueprintName).put(signature, blueprint);
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
        Map<String, Variable> localVariables = new HashMap<>();
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

        ArchiCodeInterpreter localInterpreter = new ArchiCodeInterpreter(symbolTable, blueprints);
        localInterpreter.variables.putAll(localVariables);

        return localInterpreter.visit(blueprint.getBlock());
    }

    @Override
    public Object visitFuncCallExpr(ArchiCodeParser.FuncCallExprContext ctx) {
        String blueprintName = ctx.CapitalVarName().getText();
        String signature = generateCallSignature(ctx);

        if (!blueprints.containsKey(blueprintName) || !blueprints.get(blueprintName).containsKey(signature)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Blueprint " + blueprintName + "(" + signature + ") nie został zdefiniowany.");
            System.exit(1);
        }

        Blueprint blueprint = blueprints.get(blueprintName).get(signature);
        Map<String, Variable> localVariables = new HashMap<>();

        int i = 0;
        for (String paramName : blueprint.getParams().keySet()) {
            Object paramValue = visit(ctx.expr(i));
            String paramType = inferType(paramValue);
            if (!paramType.equals(blueprint.getParams().get(paramName))) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Argument " + paramName + " wymaga typu " +
                        blueprint.getParams().get(paramName) + ", otrzymano: " + paramType);
                System.exit(1);
            }
            localVariables.put(paramName, new Variable(VarType.fromString(paramType), paramValue));
            i++;
        }

        ArchiCodeInterpreter localInterpreter = new ArchiCodeInterpreter(symbolTable, blueprints);
        localInterpreter.variables.putAll(localVariables);

        if (!blueprint.isVoid()) {
            localInterpreter.variables.put(blueprint.getReturnName(), blueprint.getReturnVariable());
            localInterpreter.visit(blueprint.getBlock());
            Object ret = localInterpreter.variables.get(blueprint.getReturnName()).getValue();
            if (VarType.fromString(inferType(ret)) != blueprint.getReturnVariable().getType()) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): Blueprint powinien zwracać " +
                        blueprint.getReturnVariable().getType() + ", ale zwrócono " + inferType(ret));
                System.exit(1);
            }
            return ret;
        } else {
            // blueprint typu void
            localInterpreter.visit(blueprint.getBlock());
            return null;
        }
    }

    @Override
    public Object visitRepeatFixed(ArchiCodeParser.RepeatFixedContext ctx) {
        if(ctx.expr() == null) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): repeat wymaga parametru liczbowego");
            System.exit(1);
        }
        var cntObj = visit(ctx.expr());
        if(!(cntObj instanceof Integer)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): repeat wymaga parametru liczbowego");
            System.exit(1);
        }
        int cnt = (int)cntObj;
        if(cnt < 0) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): repeat wymaga dodatniego parametru liczbowego");
            System.exit(1);
        }
        for(int i = 0; i < cnt; i++) {
            variables.put("__step__", new Variable(VarType.INT, i));
            visit(ctx.block());
        }
        return null;
    }

    @Override
    public Object visitRepeatUntil(ArchiCodeParser.RepeatUntilContext ctx) {
        int i = 0;
        while (true) {
            variables.put("__step__", new Variable(VarType.INT, i));
            visit(ctx.block());
            Object condition = visit(ctx.expr());
            if (!(condition instanceof Boolean)) {
                int line = ctx.getStart().getLine();
                System.err.println("Błąd (linia " + line + "): warunek w repeat until musi być typu bool.");
                System.exit(1);
            }
            if ((Boolean) condition) break;
            i++;
        }
        return null;
    }

    @Override
    public Object visitCheckStatement(ArchiCodeParser.CheckStatementContext ctx) {
        Object conditionValue = visit(ctx.expr());

        if (!(conditionValue instanceof Boolean)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): Warunek w 'check' nie zwraca wartości typu Boolean.");
            System.exit(1);
        }

        boolean condition = (Boolean) conditionValue;

        if (condition) {
            return visit(ctx.block(0));
        } else {
            if (ctx.getChildCount() > 4) {
                if (ctx.checkStatement() != null) {
                    return visit(ctx.checkStatement());
                } else if (ctx.block(1) != null) {
                    return visit(ctx.block(1));
                }
            }
        }

        return null;
    }

    @Override
    public Object visitFloatExpr(ArchiCodeParser.FloatExprContext ctx) {
        return Float.parseFloat(ctx.getText());
    }

    @Override
    public Object visitStepExpr(ArchiCodeParser.StepExprContext ctx) {
        if (!variables.containsKey("__step__")) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): 'step' może być używane tylko wewnątrz pętli.");
            System.exit(1);
        }

        return variables.get("__step__").getValue();
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
        if (!signature.isEmpty()) {
            signature.setLength(signature.length() - 1);
        }

        return signature.toString();
    }
}