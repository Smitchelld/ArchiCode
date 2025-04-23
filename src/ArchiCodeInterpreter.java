import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class ArchiCodeInterpreter {
    private static final Map<String, Integer> variables = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String input = new String(Files.readAllBytes(Paths.get("program.ArchC")));

        CharStream charStream = CharStreams.fromString(input);
        ArchiCodeLexer lexer = new ArchiCodeLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArchiCodeParser parser = new ArchiCodeParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer,
                                    Object offendingSymbol,
                                    int line, int charPositionInLine,
                                    String msg, RecognitionException e) {
                System.err.printf("Błąd składni: linia %d:%d - %s%n", line, charPositionInLine, msg);
                System.exit(1);
            }
        });
        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        ArchiCodeExecutor executor = new ArchiCodeExecutor();
        walker.walk(executor, tree);
    }
}

class ArchiCodeExecutor extends ArchiCodeBaseListener {

    @Override
    public void enterShowStatement(ArchiCodeParser.ShowStatementContext ctx) {
        String text = ctx.expr().getText().replace("\"", "");
        System.out.println(text);
    }

    @Override
    public void enterBlueprintStatement(ArchiCodeParser.BlueprintStatementContext ctx) {

    }
}