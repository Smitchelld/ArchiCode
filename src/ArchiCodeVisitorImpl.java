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
        if(ctx.INT() != null) {
            return memory.resolveVariable(varName, Integer.parseInt(ctx.INT().getText()));
        }
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

    @Override
    public Value visitRelationalExpr(ArchiCodeParser.RelationalExprContext ctx) {
        Value left = visit(ctx.addSubExpr(0));
        for(int i = 1; i < ctx.addSubExpr().size(); i++){
            Value right = visit(ctx.addSubExpr(i));
            String operator = ctx.getChild(2*i-1).getText();

            left = switch(operator){
                case "<" -> left.lt(right);
                case "<=" -> left.lte(right);
                case ">" -> left.gt(right);
                case ">=" -> left.gte(right);
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            };
        }
        return left;
    }

    @Override
    public Value visitUnaryExpr(ArchiCodeParser.UnaryExprContext ctx) {
        if(ctx.getChildCount() == 2){
            String operator = ctx.getChild(0).getText();
            Value value = visit(ctx.unaryExpr());

            return switch (operator){
                case "-" -> value.neg();
                case "+" -> value;
                case "not" -> value.neg();
                default -> throw new IllegalStateException("Unexpected value: " + operator);
            };
        }
        else{
            return visit(ctx.atom());
        }
    }

    @Override
    public Value visitParenExpr(ArchiCodeParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Value visitRepeatFixed(ArchiCodeParser.RepeatFixedContext ctx) {
        if(ctx.expr() == null){
            throw new RuntimeException("repeat fixed without expr");
        }
        Value expr = new IntValue(0);
        Value limit = visit(ctx.expr(0));

        if(ctx.expr().size() == 2){
            expr = visit(ctx.expr(0));
            limit = visit(ctx.expr(1));
        }

        if(expr.type != Type.INT || limit.type != Type.INT){
            throw new RuntimeException("repeat fixed with non int expr");
        }
        memory.createVariable("step",Type.INT, new IntValue(expr.getInt()));
        while(memory.resolveVariable("step").getInt() < limit.getInt()){
            visit(ctx.block());
            memory.assignValue("step", memory.resolveVariable("step").add(new IntValue(1)));
        }
        return null;

    }

    @Override
    public Value visitCheckStatement(ArchiCodeParser.CheckStatementContext ctx) {
        Value conditionValue = visit(ctx.expr());
        boolean condiction;
        try{
            condiction = conditionValue.getBoolean();
        }catch(Exception e){
            throw new RuntimeException("condition is not boolean");
        }
        if(condiction){
            return visit(ctx.block(0));
        }else if (ctx.getChildCount() >4){
            if(ctx.checkStatement() != null){
                return visit(ctx.checkStatement());
            }else if (ctx.block(1) != null){
                return visit(ctx.block(1));
            }
        }
        return null;
    }

    @Override
    public Value visitRepeatUntil(ArchiCodeParser.RepeatUntilContext ctx) {

        boolean condition;
        try{
            condition = visit(ctx.expr()).getBoolean();
        } catch (Exception e) {
            throw new RuntimeException("condition is not boolean");
        }
        memory.createVariable("step", Type.INT, new IntValue(0));
        while(!condition){
            visit(ctx.block());
            memory.assignValue("step", memory.resolveVariable("step").add(new IntValue(1)));
            try{
                condition = visit(ctx.expr()).getBoolean();
            }catch(Exception e){
                throw new RuntimeException("condition is not boolean");
            }
        }
        return null;
    }

    @Override
    public Value visitStepExpr(ArchiCodeParser.StepExprContext ctx) {
        if(ctx.INT() == null){
            return memory.resolveVariable("step", 1);
        }
        return memory.resolveVariable("step", Integer.parseInt(ctx.INT().getText()) + 1);
    }
}
