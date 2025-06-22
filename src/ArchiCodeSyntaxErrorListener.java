import org.antlr.v4.runtime.*;

import java.util.List;

public class ArchiCodeSyntaxErrorListener extends BaseErrorListener {
    private final List<String> sourceLines;

    public ArchiCodeSyntaxErrorListener(List<String> sourceLines) {
        this.sourceLines = sourceLines;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {

        String offending = ((Token) offendingSymbol).getText();
        String friendly = generateFriendlyMessage(offending, msg);

        System.err.println("Błąd składni (linia " + line + ", kolumna " + charPositionInLine + "):");
        System.err.println(friendly);

        if (line <= sourceLines.size()) {
            String codeLine = sourceLines.get(line - 1);
            System.err.println(codeLine);
            System.err.println(" ".repeat(charPositionInLine) + "^".repeat(Math.max(1, offending.length())));
        }

        System.exit(1);
    }

    private String generateFriendlyMessage(String offending, String msg) {
        if (msg.contains("extraneous input")) {
            return "Nieoczekiwany token `" + offending + "`. Może jest zbędny lub w złym miejscu.";
        }
        if (msg.contains("mismatched input")) {
            return "Token `" + offending + "` nie pasuje tu składniowo. Sprawdź składnię lub literówkę.";
        }
        if (msg.contains("missing")) {
            return "Brakuje składnika — czy zapomniałeś o nawiasie, przecinku albo słowie kluczowym?";
        }
        if (msg.contains("no viable alternative")) {
            return "Nie rozumiem tego fragmentu. Sprawdź, czy poprawnie zapisano wyrażenie.";
        }

        return "Nieznany błąd składni: " + msg;
    }
}
