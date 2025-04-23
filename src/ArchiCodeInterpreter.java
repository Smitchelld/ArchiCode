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

        CharStream inputStream = CharStreams.fromString(input);
        ArchiCodeLexer lexer = new ArchiCodeLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArchiCodeParser parser = new ArchiCodeParser(tokens);
        ParseTree tree = parser.program();

        ArchiCodeListener listener = new ArchiCodeListener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
    }

    static class ArchiCodeListener extends ArchiCodeBaseListener {
        private static final Scanner scanner = new Scanner(System.in);
        private static final Map<String, Integer> variables = new HashMap<>();

        @Override
        public void exitRequestStatement(ArchiCodeParser.RequestStatementContext ctx) {
            String varName = ctx.VarName().getText();
            System.out.print("Podaj wartość dla " + varName + ": ");

            try {
                int value = scanner.nextInt();
                variables.put(varName, value);
            } catch (Exception e) {
                System.err.println("Błąd: Oczekiwano liczby całkowitej!");
                scanner.next(); // Czyszczenie błędnego wejścia
            }
        }

        @Override
        public void exitShowStatement(ArchiCodeParser.ShowStatementContext ctx) {
            String nameOrValue = ctx.expr().getText();

            if (variables.containsKey(nameOrValue)) {
                System.out.println(variables.get(nameOrValue));
            } else {
                if (nameOrValue.startsWith("\"") && nameOrValue.endsWith("\"")) {
                    nameOrValue = nameOrValue.substring(1, nameOrValue.length() - 1);
                }
                System.out.println(nameOrValue);
            }
        }

        @Override
        public void exitDefineStatement(ArchiCodeParser.DefineStatementContext ctx) {
            String varName = ctx.VarName().getText();
            int value = evaluateExpr(ctx.expr());
            variables.put(varName, value);
        }

        @Override
        public void exitAssignStatement(ArchiCodeParser.AssignStatementContext ctx) {
            String varName = ctx.VarName().getText();
            if (!variables.containsKey(varName)) {
                System.err.println("Błąd: Próba przypisania do niezdefiniowanej zmiennej " + varName);
                return;
            }
            int value = evaluateExpr(ctx.expr());
            variables.put(varName, value);
        }

        private int evaluateExpr(ArchiCodeParser.ExprContext ctx) {
            if (ctx instanceof ArchiCodeParser.AddExprContext) {
                return evaluateExpr(((ArchiCodeParser.AddExprContext) ctx).expr(0)) +
                        evaluateExpr(((ArchiCodeParser.AddExprContext) ctx).expr(1));
            } else if (ctx instanceof ArchiCodeParser.SubExprContext) {
                return evaluateExpr(((ArchiCodeParser.SubExprContext) ctx).expr(0)) -
                        evaluateExpr(((ArchiCodeParser.SubExprContext) ctx).expr(1));
            } else if (ctx instanceof ArchiCodeParser.MulExprContext) {
                return evaluateExpr(((ArchiCodeParser.MulExprContext) ctx).expr(0)) *
                        evaluateExpr(((ArchiCodeParser.MulExprContext) ctx).expr(1));
            } else if (ctx instanceof ArchiCodeParser.DivExprContext) {
                return evaluateExpr(((ArchiCodeParser.DivExprContext) ctx).expr(0)) /
                        evaluateExpr(((ArchiCodeParser.DivExprContext) ctx).expr(1));
            } else if (ctx instanceof ArchiCodeParser.IntExprContext) {
                return Integer.parseInt(ctx.getText());
            } else if (ctx instanceof ArchiCodeParser.VarExprContext) {
                String varName = ctx.getText();
                if (variables.containsKey(varName)) {
                    return variables.get(varName);
                } else {
                    System.err.println("Błąd: Nieznana zmienna " + varName);
                    return 0;
                }
            }
            return 0;
        }
    }
}