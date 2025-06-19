

import gen.ArchiCodeLexer;
import gen.ArchiCodeParser;
import gen.ArchiCodeVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) {
        String filePath = "./program.ArchC";
        if(args.length == 1){
            filePath = args[0];
        }
        
        try{
            CharStream input = CharStreams.fromFileName(filePath);

            ArchiCodeLexer lexer = new ArchiCodeLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ArchiCodeParser parser = new ArchiCodeParser(tokens);

            ParseTree tree = parser.program();
            if(parser.getNumberOfSyntaxErrors() > 0){
                System.out.println("Parse errors: " + parser.getNumberOfSyntaxErrors());
                return;
            }

            ParseTreeWalker walker = new ParseTreeWalker();
            ArchiCodeListenerImpl listener = new ArchiCodeListenerImpl();
            walker.walk(listener, tree);

            ArchiCodeVisitorImpl visitor = new ArchiCodeVisitorImpl(Path.of(filePath));
            visitor.visit(tree);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}