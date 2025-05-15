import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        String inputCons = scanner.nextLine();
        CharStream input;
        if(inputCons.isEmpty()) {
             input = CharStreams.fromFileName("program.ArchC");
        }
        else {
           input = CharStreams.fromFileName(inputCons);
        }
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

        Map<String, Map<String, Blueprint>> sharedBlueprints = new HashMap<>();
        ArchiCodeInterpreter interpreter = new ArchiCodeInterpreter(symbolListener.getSymbolTable(), sharedBlueprints);
        interpreter.visit(tree);
    }
}