import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Użycie: java Main <plik_z_programem.ArchC>");
            return;
        }

        CharStream input = CharStreams.fromFileName(args[0]);
        ArchiCodeLexer lexer = new ArchiCodeLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArchiCodeParser parser = new ArchiCodeParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new DiagnosticErrorListener());

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.out.println("Błąd składniowy! Program nie został wykonany.");
            return;
        }

        ParseTree tree = parser.program();
        ArchiCodeInterpreter interpreter = new ArchiCodeInterpreter();
        interpreter.visit(tree);
    }
}
