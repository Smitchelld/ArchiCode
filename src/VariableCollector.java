import java.util.HashMap;
import java.util.Map;

public class VariableCollector extends ArchiCodeBaseListener {
    public final Map<String, String> symbolTable = new HashMap<>();

    @Override
    public void enterDefineStatement(ArchiCodeParser.DefineStatementContext ctx) {
        String varName = ctx.VarName().getText();
        String type = ctx.type() != null ? ctx.type().getText() : "auto";

        if (symbolTable.containsKey(varName)) {
            int line = ctx.getStart().getLine();
            System.err.println("Błąd (linia " + line + "): zmienna \"" + varName + "\" została już zadeklarowana.");
            System.exit(1);
        }

        symbolTable.put(varName, type);
    }

    public Map<String, String> getSymbolTable() {
        return symbolTable;
    }
}

