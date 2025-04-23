import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("input.txt"); // lub z konsoli
        ArchiCodeLexer lexer = new ArchiCodeLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArchiCodeParser parser = new ArchiCodeParser(tokens);
        ParseTree tree = parser.program();

        ArchiCodeInterpreter interpreter = new ArchiCodeInterpreter();
        interpreter.isDeclarationPass = true;
        interpreter.visit(tree); // Pass 1 - declarations

        interpreter.isDeclarationPass = false;
        interpreter.visit(tree); // Pass 2 - execution
    }
}
