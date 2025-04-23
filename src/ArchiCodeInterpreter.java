import java.util.HashMap;
import java.util.Map;

public class ArchiCodeInterpreter extends ArchiCodeBaseVisitor<Void> {
    private final Map<String, Object> memory = new HashMap<>();
    private boolean returned = false;

    @Override
    public Void visitProgram(ArchiCodeParser.ProgramContext ctx) {
        for (ArchiCodeParser.StatementContext stmt : ctx.statement()) {
            if (returned) break;
            visit(stmt);
        }
        return null;
    }

    @Override
    public Void visitShowStatement(ArchiCodeParser.ShowStatementContext ctx) {
        if (returned) return null;
        String text = ctx.expr().getText();
        if (text.startsWith("\"") && text.endsWith("\"")) {
            System.out.println(text.substring(1, text.length() - 1));
        } else {
            Object value = memory.get(text);
            System.out.println(value != null ? value : "<undefined " + text + ">");
        }
        return null;
    }

    @Override
    public Void visitAssignStatement(ArchiCodeParser.AssignStatementContext ctx) {
        if (returned) return null;
        String var = ctx.VarName().getText();
        String value = ctx.expr().getText();
        if (value.startsWith("\"") && value.endsWith("\"")) {
            memory.put(var, value.substring(1, value.length() - 1));
        } else if (value.matches("\\d+")) {
            memory.put(var, Integer.parseInt(value));
        } else {
            memory.put(var, memory.getOrDefault(value, 0));
        }
        return null;
    }

    @Override
    public Void visitDefineStatement(ArchiCodeParser.DefineStatementContext ctx) {
        return visitAssignStatement(ctx);
    }

    @Override
    public Void visitCoreStatement(ArchiCodeParser.CoreStatementContext ctx) {
        for (var child : ctx.block().statement()) {
            if (returned) break;
            visit(child);
        }
        return null;
    }

    @Override
    public Void visitReturnStatement(ArchiCodeParser.ReturnStatementContext ctx) {
        returned = true;
        String value = ctx.expr().getText();
        if (value.matches("\\d+")) {
            System.out.println("(Program zakończył się kodem: " + value + ")");
        } else {
            Object val = memory.getOrDefault(value, 0);
            System.out.println("(Program zakończył się kodem: " + val + ")");
        }
        return null;
    }
}
