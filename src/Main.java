import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        CharStream input = CharStreams.fromFileName("program2.ArchC");
        ArchiCodeLexer lexer = new ArchiCodeLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArchiCodeParser parser = new ArchiCodeParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new ArchiCodeErrorListener());

        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Błąd składniowy! Program nie został wykonany.");
            return;
        }

        ParseTreeWalker walker = new ParseTreeWalker();
        VariableCollector symbolListener = new VariableCollector();
        walker.walk(symbolListener, tree);

        ArchiCodeInterpreter interpreter = new ArchiCodeInterpreter(symbolListener.getSymbolTable());
        interpreter.visit(tree);
    }
}