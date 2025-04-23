import java.util.HashMap;
import java.util.Map;

public class ArchiCodeInterpreter extends ArchiCodeBaseVisitor<Object> {
    public Map<String, Object> globalVariables = new HashMap<>();
    public boolean isDeclarationPass = true;

    @Override
    public Object visitAssignment(ArchiCodeParser.AssignmentContext ctx) {
        String varName = ctx.ID().getText();
        if (isDeclarationPass) {
            if (globalVariables.containsKey(varName)) {
                throw new RuntimeException("Redeclaration of variable: " + varName);
            }
            globalVariables.put(varName, null);
            return null;
        } else {
            if (!globalVariables.containsKey(varName)) {
                throw new RuntimeException("Undeclared variable: " + varName);
            }
            Object value = visit(ctx.expression());
            globalVariables.put(varName, value);
            return null;
        }
    }

    @Override
    public Object visitExprStatement(ArchiCodeParser.ExprStatementContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitExpression(ArchiCodeParser.ExpressionContext ctx) {
        if (ctx.op != null) {
            Object left = visit(ctx.expression(0));
            Object right = ctx.expression().size() > 1 ? visit(ctx.expression(1)) : null;
            switch (ctx.op.getText()) {
                case "+": return (Double) left + (Double) right;
                case "-": return (Double) left - (Double) right;
                case "*": return (Double) left * (Double) right;
                case "/": return (Double) left / (Double) right;
                case "==": return left.equals(right);
                case "!=": return !left.equals(right);
                case "<": return (Double) left < (Double) right;
                case ">": return (Double) left > (Double) right;
                case "and": return (Boolean) left && (Boolean) right;
                case "or": return (Boolean) left || (Boolean) right;
            }
        }

        if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("not")) {
            return !(Boolean) visit(ctx.expression(0));
        }

        if (ctx.NUMBER() != null) return Double.parseDouble(ctx.NUMBER().getText());
        if (ctx.TRUE() != null) return true;
        if (ctx.FALSE() != null) return false;
        if (ctx.ID() != null) {
            String varName = ctx.ID().getText();
            if (!globalVariables.containsKey(varName)) {
                throw new RuntimeException("Undeclared variable: " + varName);
            }
            return globalVariables.get(varName);
        }

        return visit(ctx.expression(0));
    }
}
