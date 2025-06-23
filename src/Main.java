

import gen.ArchiCodeLexer;
import gen.ArchiCodeParser;
import gen.ArchiCodeVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String filePath = "./program.ArchC";
        if(args.length == 1){
            if(args[0].equals("__test")){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Podaj nazwe testu");
                String numer = scanner.nextLine();
                filePath = "./tests/" + numer + ".ArchC";
            }else {
                filePath = args[0];
            }
        }
        
        try{
            CharStream input = CharStreams.fromFileName(filePath);

            ArchiCodeLexer lexer = new ArchiCodeLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ArchiCodeParser parser = new ArchiCodeParser(tokens);

            String code = Files.readString(Path.of(filePath));
            List<String> sourceLines = Arrays.asList(code.split("\\R"));

            parser.removeErrorListeners();
            parser.addErrorListener(new ArchiCodeSyntaxErrorListener(sourceLines));
            ParseTree tree = null;
            try {
                tree = parser.program();
            }catch (ArchiCodeException e){
                System.err.println(e.getMessage());
                System.exit(1);

            }
            if(parser.getNumberOfSyntaxErrors() > 0){
                System.out.println("Parse errors: " + parser.getNumberOfSyntaxErrors());
                return;
            }

            ParseTreeWalker walker = new ParseTreeWalker();
            ArchiCodeListenerImpl listener = new ArchiCodeListenerImpl();

            walker.walk(listener, tree);


            ArchiCodeVisitorImpl visitor = new ArchiCodeVisitorImpl(Path.of(filePath));
            visitor.visit(tree);

        }catch (ArchiCodeException e){
            System.err.println(e.getMessage());
        }catch (NoSuchFileException e){
            System.err.println("No such File " + e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}