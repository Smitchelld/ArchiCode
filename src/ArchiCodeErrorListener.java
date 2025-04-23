import org.antlr.v4.runtime.*;

public class ArchiCodeErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e
    ) {
        System.err.println("Błąd składniowy (linia " + line + ", kolumna " + (charPositionInLine + 1) + "): " + msg);
        System.exit(1);
    }
}
