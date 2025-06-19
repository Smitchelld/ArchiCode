import gen.ArchiCodeBaseVisitor;
import gen.ArchiCodeParser;
import memory.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Path;

public class ArchiCodeVisitorImpl extends ArchiCodeBaseVisitor<Value> {

    public Memory memory;
    private Path filePath;
    PrintStream printStream;
    InputStream inputStream;


    public ArchiCodeVisitorImpl(Path filePath) {
        this.filePath = filePath;
        printStream = System.out;
        inputStream = System.in;
        this.memory = new Memory(filePath);
    }

    @Override
    public Value visitProgram(ArchiCodeParser.ProgramContext ctx) {
        boolean coreExecuted = false;

        for (ArchiCodeParser.StatementContext stmt : ctx.statement()) {
            if(stmt.coreStatement() != null) {
                if(coreExecuted) {
                    throw new RuntimeException("Drugi core");
                }
                coreExecuted = true;
                visit(stmt);
            } else if (stmt.blueprintStatement() != null) {
                if(coreExecuted) {
                    throw new RuntimeException("blueprint Pod Core");
                }
                visit(stmt);
            } else if (stmt.defineStatement() != null) {
                if(coreExecuted) {
                    throw new RuntimeException("define statement pod core");
                }
                visit(stmt);
            }else{
                throw new RuntimeException("nieprawidlowa instrukcja "+ stmt.getText());
            }
        }

        if(!coreExecuted) {
            throw new RuntimeException("Bark Core");
        }

        return null;
    }

    @Override
    public Value visitDefineStatement(ArchiCodeParser.DefineStatementContext ctx) {
        String name = ctx.VarName().getText();
        Value value = visit(ctx.expr());
        Type type;
        if(ctx.type() != null) {
            type = Type.fromString(ctx.type().getText());
        }
        else{
            type = Type.inferType(value);
        }
        memory.createVariable(name, type, value);
        return null;
    }

    @Override
    public Value visitShowStatement(ArchiCodeParser.ShowStatementContext ctx) {
        Value value = visit(ctx.expr());
        System.out.println(value != null ? value.getString() : "null");
        return null;
    }

    @Override
    public Value visitAssignStatement(ArchiCodeParser.AssignStatementContext ctx) {
        var VarName = ctx.VarName().getText();
        Value value = visit(ctx.expr());
        memory.assignValue(VarName, value);
        return memory.resolveVariable(VarName);
    }

    @Override
    public Value visitIntExpr(ArchiCodeParser.IntExprContext ctx) {
        return new IntValue(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public Value visitFloatExpr(ArchiCodeParser.FloatExprContext ctx) {
        return new FloatValue(Float.parseFloat(ctx.FLOAT().getText()));
    }

    @Override
    public Value visitStringExpr(ArchiCodeParser.StringExprContext ctx) {
        return new StringValue(ctx.STRING().getText());
    }

    @Override
    public Value visitCharExpr(ArchiCodeParser.CharExprContext ctx) {
        return new CharValue(ctx.CHAR().getText().charAt(1));
    }

    @Override
    public Value visitBoolTrueExpr(ArchiCodeParser.BoolTrueExprContext ctx) {
        return new BoolValue(true);
    }

    @Override
    public Value visitBoolFalseExpr(ArchiCodeParser.BoolFalseExprContext ctx) {
        return new BoolValue(false);
    }



    @Override
    public Value visitVarExpr(ArchiCodeParser.VarExprContext ctx) {
        String varName = ctx.VarName().getText();
        return memory.resolveVariable(varName);
    }

    @Override
    public Value visitBlock(ArchiCodeParser.BlockContext ctx) {
        memory.newScope();
        visitChildren(ctx);
        memory.endScope();
        return null;
    }

    @Override
    public Value visitAddSubExpr(ArchiCodeParser.AddSubExprContext ctx) {
        Value left = visit(ctx.mulDivExpr(0));
        for(int i = 1; i < ctx.mulDivExpr().size(); i++) {
            Value right = visit(ctx.mulDivExpr(i));
            String operator = ctx.getChild(2*i-1).getText();

            left = switch(operator) {
                case "+" -> left.add(right);
                case "-" -> left.sub(right);
                default -> throw new RuntimeException("unsupported operator " + operator);
            };
        }
        return left;
    }

    @Override
    public Value visitMulDivExpr(ArchiCodeParser.MulDivExprContext ctx) {
        Value left = visit(ctx.unaryExpr(0));

        for(int i = 1; i < ctx.unaryExpr().size(); i++) {
            Value right = visit(ctx.unaryExpr(i));
            String operator = ctx.getChild(2*i-1).getText();

            left = switch (operator){
                case "*" -> left.mul(right);
                case "/" -> left.div(right);
                default -> throw new RuntimeException("unsupported operator " + operator);
            };
        }
        return left;
    }

    @Override
    public Value visitAndExpr(ArchiCodeParser.AndExprContext ctx) {
        Value left = visit(ctx.equalityExpr(0));
        for(int i = 1; i < ctx.equalityExpr().size(); i++) {
            Value right = visit(ctx.equalityExpr(i));
            left = left.and(right);
        }
        return left;
    }

    @Override
    public Value visitOrExpr(ArchiCodeParser.OrExprContext ctx) {
        Value left = visit(ctx.andExpr(0));
        for(int i = 1; i < ctx.andExpr().size(); i++) {
            Value right = visit(ctx.andExpr(i));
            left = left.or(right);
        }
        return left;
    }

    @Override
    public Value visitEqualityExpr(ArchiCodeParser.EqualityExprContext ctx) {
        Value left = visit(ctx.relationalExpr(0));
        for(int i = 1; i < ctx.relationalExpr().size(); i++){
            Value right = visit(ctx.relationalExpr(i));
            String operator = ctx.getChild(2*i-1).getText();
            
            left = switch (operator){
                case "==" -> left.eq(right);
                case "!=" -> left.neq(right);
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            };
        }
        return left;
    }
}
