import gen.ArchiCodeBaseVisitor;
import gen.ArchiCodeParser;
import memory.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ArchiCodeVisitorImpl extends ArchiCodeBaseVisitor<Value> {

    public Memory memory;
    private Path filePath;
    PrintStream printStream;
    InputStream inputStream;

    private boolean suppressBlockScope = false;

    public ArchiCodeVisitorImpl(Path filePath) {
        this.filePath = filePath;
        printStream = System.out;
        inputStream = System.in;
        this.memory = new Memory(filePath);
    }

    @Override
    public Value visitProgram(ArchiCodeParser.ProgramContext ctx){
        try {
            boolean coreExecuted = false;
            for (ArchiCodeParser.StatementContext stmt : ctx.statement()) {
                if (stmt.coreStatement() != null) {
                    if (coreExecuted) {
                        throw new RuntimeException("Drugi core");
                    }
                    coreExecuted = true;
                    visit(stmt);
                } else if (stmt.blueprintStatement() != null) {
                    if (coreExecuted) {
                        throw new RuntimeException("blueprint Pod Core");
                    }
                    visit(stmt);
                } else if (stmt.defineStatement() != null) {
                    if (coreExecuted) {
                        throw new RuntimeException("define statement pod core");
                    }
                    visit(stmt);
                } else {
                    throw new RuntimeException("nieprawidlowa instrukcja " + stmt.getText());
                }
            }

            if (!coreExecuted) {
                throw new RuntimeException("Bark Core");
            }

            return null;
        }catch(Exception e){
            var line = ctx.getStart().getLine();
            var column = ctx.getStart().getCharPositionInLine();
            var message = e.getMessage();
            var functionStack = Memory.FunctionCallStack;
            System.err.println("Error at");
            int i;
            for(i = 0; i < functionStack.size(); i++){
                for(int j = 0; j < i; j++){
                    System.err.print(" ");
                }
                System.err.println(">"+functionStack.get(i));
            }
            for(;i > 0 ; i--){
                System.err.print(" ");
            }
            System.err.println(message);
            System.exit(1);
        }
        return null;
    }

    @Override
    public Value visitDefineStatement(ArchiCodeParser.DefineStatementContext ctx) {
        try {
            String name = ctx.VarName().getText();
            Value value = visit(ctx.expr());
            Type type;
            if (ctx.type() != null) {
                type = Type.fromString(ctx.type().getText());
                value = value.castTo(type);
            } else {
                type = Type.inferType(value);
            }

            if(value.type != type){
                value = value.castTo(type);
            }

            memory.createVariable(name, type, value);
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitShowStatement(ArchiCodeParser.ShowStatementContext ctx) {
        try {
            StringBuilder message = new StringBuilder();
            if (ctx.expr() == null) {
                return null;
            }
            for(var expt : ctx.expr()){
                Value value = visit(expt);
                message.append(value.getString());
                message.append(", ");
            }
            message.deleteCharAt(message.length()-1);
            message.deleteCharAt(message.length()-1);
            String strMessage = message.toString().replace("\\n", "\n")
                    .replace("\\t", "\t")
                    .replace("\\\"", "\"")
                    .replace("\\\\", "\\");
            System.out.println(strMessage);
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitAssignStatement(ArchiCodeParser.AssignStatementContext ctx) {
        try {
            String varName = ctx.VarName().getText();
            Value exprValue = visit(ctx.expr());

            Value varValue = memory.resolveVariable(varName);
            Type varType = varValue.type;

            if (exprValue.type != varType) {
                exprValue = exprValue.castTo(varType);
            }

            memory.assignValue(varName, exprValue);
            return memory.resolveVariable(varName);
        } catch (ArchiCodeException e) {
            throwArchiCodeException(e);
        } catch (Exception e) {
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
            return null;
        }
        return null;
    }

    @Override
    public Value visitRequestStatement(ArchiCodeParser.RequestStatementContext ctx) {
        try {
            String varName = ctx.VarName().getText();
            Value value = memory.resolveVariable(varName);
            System.out.print("Podaj wartość dla " + varName + ": ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Type varType = value.type;
            Value parsed = null;
            try {
                parsed = switch (varType) {
                    case INT -> new IntValue(Integer.parseInt(input));
                    case FLOAT -> new FloatValue(Float.parseFloat(input));
                    case BOOL -> new BoolValue(Boolean.parseBoolean(input));
                    case CHAR -> {
                        yield new CharValue(input.charAt(0));
                    }
                    case STRING -> new StringValue(input);
                    default ->
                            throw new IllegalArgumentException("Nierozpoznany typ zmiennej " + varName + " typu " + varType);
                };
            } catch (Exception e) {
                var line = ctx.getStart().getLine();
                var column = ctx.getStart().getCharPositionInLine();
                var message = e.getMessage();
                System.err.println("Error at line " + line + " column " + column + ": " + message);
                System.exit(1);
            }

            memory.assignValue(varName, parsed);
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitIntExpr(ArchiCodeParser.IntExprContext ctx) {
        try {
            return new IntValue(Integer.parseInt(ctx.INT().getText()));
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitFloatExpr(ArchiCodeParser.FloatExprContext ctx) {
        try {
            return new FloatValue(Float.parseFloat(ctx.FLOAT().getText()));
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitStringExpr(ArchiCodeParser.StringExprContext ctx) {
        try {
            StringBuilder text = new StringBuilder(ctx.STRING().getText());
            text.deleteCharAt(text.length()-1);
            text.deleteCharAt(0);
            return new StringValue(text.toString());
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitCharExpr(ArchiCodeParser.CharExprContext ctx) {
        try {
            return new CharValue(ctx.CHAR().getText().charAt(1));
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitBoolTrueExpr(ArchiCodeParser.BoolTrueExprContext ctx) {
        try {
            return new BoolValue(true);
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitBoolFalseExpr(ArchiCodeParser.BoolFalseExprContext ctx) {
        try {
            return new BoolValue(false);
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitVarExpr(ArchiCodeParser.VarExprContext ctx) {
        try {
            String varName = ctx.VarName().getText();
            if (ctx.INT() != null) {
                return memory.resolveVariable(varName, Integer.parseInt(ctx.INT().getText()));
            }
            return memory.resolveVariable(varName);
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitBlock(ArchiCodeParser.BlockContext ctx) {
        try {
            if (suppressBlockScope) return null;
            memory.newScope();
            visitChildren(ctx);
            memory.endScope();
            return null;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitAddSubExpr(ArchiCodeParser.AddSubExprContext ctx) {
        try {
            Value left = visit(ctx.mulDivExpr(0));
            for (int i = 1; i < ctx.mulDivExpr().size(); i++) {
                Value right = visit(ctx.mulDivExpr(i));
                String operator = ctx.getChild(2 * i - 1).getText();

                left = switch (operator) {
                    case "+" -> left.add(right);
                    case "-" -> left.sub(right);
                    default -> throw new RuntimeException("unsupported operator " + operator);
                };
            }
            return left;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitMulDivExpr(ArchiCodeParser.MulDivExprContext ctx) {
        try {
            Value left = visit(ctx.unaryExpr(0));

            for (int i = 1; i < ctx.unaryExpr().size(); i++) {
                Value right = visit(ctx.unaryExpr(i));
                String operator = ctx.getChild(2 * i - 1).getText();

                left = switch (operator) {
                    case "*" -> left.mul(right);
                    case "/" -> left.div(right);
                    default -> throw new RuntimeException("unsupported operator " + operator);
                };
            }
            return left;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitAndExpr(ArchiCodeParser.AndExprContext ctx) {
        try {
            Value left = visit(ctx.equalityExpr(0));
            for (int i = 1; i < ctx.equalityExpr().size(); i++) {
                Value right = visit(ctx.equalityExpr(i));
                left = left.and(right);
            }
            return left;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitOrExpr(ArchiCodeParser.OrExprContext ctx) {
        try {
            Value left = visit(ctx.andExpr(0));
            for (int i = 1; i < ctx.andExpr().size(); i++) {
                Value right = visit(ctx.andExpr(i));
                left = left.or(right);
            }
            return left;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitEqualityExpr(ArchiCodeParser.EqualityExprContext ctx) {
        try {
            Value left = visit(ctx.relationalExpr(0));
            for (int i = 1; i < ctx.relationalExpr().size(); i++) {
                Value right = visit(ctx.relationalExpr(i));
                String operator = ctx.getChild(2 * i - 1).getText();

                left = switch (operator) {
                    case "==" -> left.eq(right);
                    case "!=" -> left.neq(right);
                    default -> throw new IllegalStateException("Unexpected value: " + operator);
                };
            }
            return left;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitRelationalExpr(ArchiCodeParser.RelationalExprContext ctx) {
        try {
            Value left = visit(ctx.addSubExpr(0));
            for (int i = 1; i < ctx.addSubExpr().size(); i++) {
                Value right = visit(ctx.addSubExpr(i));
                String operator = ctx.getChild(2 * i - 1).getText();

                left = switch (operator) {
                    case "<" -> left.lt(right);
                    case "<=" -> left.lte(right);
                    case ">" -> left.gt(right);
                    case ">=" -> left.gte(right);
                    default -> throw new IllegalStateException("Unexpected value: " + operator);
                };
            }
            return left;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }


    @Override
    public Value visitTypeCastExpr(ArchiCodeParser.TypeCastExprContext ctx) {
        try {
            Type type = Type.fromString(ctx.type().getText());
            Value val = visit(ctx.unaryExpr());
            return switch (type) {
                case INT -> new IntValue(val.getInt());
                case FLOAT -> new FloatValue(val.getFloat());
                case STRING -> new StringValue(val.getString());
                case CHAR -> new CharValue(val.getChar());
                case BOOL -> new BoolValue(val.getBoolean());
                default -> null;
            };
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitNegExpr(ArchiCodeParser.NegExprContext ctx) {
        try {
            Value val = visit(ctx.unaryExpr());
            return val.neg();
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitNotExpr(ArchiCodeParser.NotExprContext ctx) {
        try {
            Value val = visit(ctx.unaryExpr());
            return val.not();
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitPlusExpr(ArchiCodeParser.PlusExprContext ctx) {
        try {
            return visit(ctx.unaryExpr());
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitParenExpr(ArchiCodeParser.ParenExprContext ctx) {
        try {
            return visit(ctx.expr());
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitRepeatFixed(ArchiCodeParser.RepeatFixedContext ctx) {
        try {
            if (ctx.expr() == null) {
                throw new RuntimeException("repeat fixed without expr");
            }
            Value expr = new IntValue(0);
            Value limit = visit(ctx.expr(0));

            if (ctx.expr().size() == 2) {
                expr = visit(ctx.expr(0));
                limit = visit(ctx.expr(1));
            }

            if (expr.type != Type.INT || limit.type != Type.INT) {
                throw new RuntimeException("repeat fixed with non int expr");
            }
            memory.createVariable("step", Type.INT, new IntValue(expr.getInt()));
            while (memory.resolveVariable("step").getInt() < limit.getInt()) {
                visit(ctx.block());
                memory.assignValue("step", memory.resolveVariable("step").add(new IntValue(1)));
            }
            return null;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;

    }

    @Override
    public Value visitCheckStatement(ArchiCodeParser.CheckStatementContext ctx) {
        try {
            Value conditionValue = visit(ctx.expr());
            boolean condiction = false;
            try {
                condiction = conditionValue.getBoolean();
            } catch (Exception e) {
                var line = ctx.getStart().getLine();
                var column = ctx.getStart().getCharPositionInLine();
                var message = e.getMessage();
                System.err.println("Error at line " + line + " column " + column + ": " + message);
                System.exit(1);
            }
            if (condiction) {
                return visit(ctx.block(0));
            } else if (ctx.getChildCount() > 4) {
                if (ctx.checkStatement() != null) {
                    return visit(ctx.checkStatement());
                } else if (ctx.block(1) != null) {
                    return visit(ctx.block(1));
                }
            }
            return null;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitRepeatUntil(ArchiCodeParser.RepeatUntilContext ctx) {
        try {
            boolean condition = false;
            try {
                condition = visit(ctx.expr()).getBoolean();
            } catch (Exception e) {
                var line = ctx.getStart().getLine();
                var column = ctx.getStart().getCharPositionInLine();
                var message = e.getMessage();
                System.err.println("Error at line " + line + " column " + column + ": " + message);
                System.exit(1);
            }
            memory.createVariable("step", Type.INT, new IntValue(0));
            while (!condition) {
                visit(ctx.block());
                memory.assignValue("step", memory.resolveVariable("step").add(new IntValue(1)));
                try {
                    condition = visit(ctx.expr()).getBoolean();
                } catch (Exception e) {
                    throw new RuntimeException("condition is not boolean");
                }
            }
            return null;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitBlueprintStatement(ArchiCodeParser.BlueprintStatementContext ctx) {
        try {
            String blueprintName = ctx.CapitalVarName().getText();
            String signature = Blueprint.generateSignature(ctx.paramList());
            Map<String, String> params = new LinkedHashMap<>();
            if (ctx.paramList() != null) {
                for (var param : ctx.paramList().param()) {
                    params.put(param.VarName().getText(), param.type().getText());
                }
            }
            if (ctx.type() != null && ctx.VarName() != null) {
                var returnName = ctx.VarName().getText();
                var returnType = Type.fromString(ctx.type().getText());
                var returnValue = visit(ctx.expr()).castTo(returnType);
                Blueprint blueprint = new Blueprint(blueprintName, signature, params, ctx.block(), returnName, returnValue, returnType);
                memory.createBlueprint(blueprintName, signature, blueprint);
            } else {
                Blueprint blueprint = new Blueprint(blueprintName, signature, params, ctx.block());
                memory.createBlueprint(blueprintName, signature, blueprint);
            }
            return null;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitBlueprintCallStatement(ArchiCodeParser.BlueprintCallStatementContext ctx) {
        try {
            Memory.countRecursion();
            var BlueprintName = ctx.getChild(0).getText();
            Memory.addCallStack("line " + ctx.getStart().getLine() + " column " + ctx.getStart().getCharPositionInLine() + " " + BlueprintName + ":");
            String signature = generateSignature(ctx);
            Memory localMemory = new Memory(memory);
            localMemory.newScope();
            Blueprint blueprint = memory.resolveBlueprint(BlueprintName, signature);
            var params = blueprint.getParams();
            if (!blueprint.isVoid()) {
                var returnName = blueprint.getReturnName();
                var returnValue = blueprint.getReturnValue();
                var returnType = blueprint.getReturnType();
                localMemory.createVariable(returnName, returnType, returnValue);
            }
            for (int i = 0; i < blueprint.getParams().size(); i++) {
                String paramName = params.keySet().toArray(new String[0])[i];

                Value paramValue = visit(ctx.expr(i));
                Type actParamType = paramValue.type;
                Type expectedParamType = Type.fromString(params.get(paramName));
                if (actParamType != expectedParamType) {
                    throw new RuntimeException("Wrong parameter type: " + BlueprintName + " " + paramName + " got " + actParamType + " expected " + expectedParamType);
                }
                localMemory.createVariable(paramName, actParamType, paramValue);
            }
            ArchiCodeVisitorImpl localVisitor = new ArchiCodeVisitorImpl(filePath);
            localVisitor.memory = localMemory;
            localVisitor.visit(blueprint.getBlock());
            Memory.decrementRecursion();
            if (!blueprint.isVoid()) {
                return localMemory.resolveVariable(blueprint.getReturnName());
            }
            return null;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitFuncCallExpr(ArchiCodeParser.FuncCallExprContext ctx) {
        try {
            Memory.countRecursion();
            var BlueprintName = ctx.getChild(0).getText();
            Memory.addCallStack("line " + ctx.getStart().getLine() + " column " + ctx.getStart().getCharPositionInLine() + " " + BlueprintName + ":");
            String signature = generateSignature(ctx);
            Memory localMemory = new Memory(memory);
            localMemory.newScope();
            Blueprint blueprint = memory.resolveBlueprint(BlueprintName, signature);
            var params = blueprint.getParams();
            if (!blueprint.isVoid()) {
                var returnName = blueprint.getReturnName();
                var returnValue = blueprint.getReturnValue();
                var returnType = blueprint.getReturnType();
                localMemory.createVariable(returnName, returnType, returnValue);
            }
            for (int i = 0; i < blueprint.getParams().size(); i++) {
                String paramName = params.keySet().toArray(new String[0])[i];
                Value paramValue = visit(ctx.expr(i));
                Type actParamType = paramValue.type;
                Type expectedParamType = Type.fromString(params.get(paramName));
                if (actParamType != expectedParamType) {
                    throw new RuntimeException("Wrong parameter type: " + BlueprintName + " " + paramName + " " + actParamType + " " + expectedParamType);
                }
                localMemory.createVariable(paramName, actParamType, paramValue);
            }
            ArchiCodeVisitorImpl localVisitor = new ArchiCodeVisitorImpl(filePath);
            localVisitor.memory = localMemory;
            localVisitor.visit(blueprint.getBlock());
            Memory.decrementRecursion();
            if (!blueprint.isVoid()) {
                return localMemory.resolveVariable(blueprint.getReturnName());
            }
            return null;
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Value visitStepExpr(ArchiCodeParser.StepExprContext ctx) {
        try {
            if (ctx.INT() == null) {
                return memory.resolveVariable("step", 1);
            }
            return memory.resolveVariable("step", Integer.parseInt(ctx.INT().getText()) + 1);
        }catch(ArchiCodeException e){
            throwArchiCodeException(e);
        }catch(Exception e){
            throwError(e.getMessage(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }


    private String generateSignature(ArchiCodeParser.BlueprintCallStatementContext ctx) {
        StringBuilder signature = new StringBuilder();
        for(var expr : ctx.expr()){
            Value value = visit(expr);
            String type = value.type.toString();
            if(!signature.isEmpty()) signature.append(",");
            signature.append(type);
        }
        return signature.toString();
    }

    private String generateSignature(ArchiCodeParser.FuncCallExprContext ctx) {
        StringBuilder signature = new StringBuilder();
        for(var expr : ctx.expr()){
            Value value = visit(expr);
            String type = value.type.toString();
            if(!signature.isEmpty()) signature.append(",");
            signature.append(type);
        }
        return signature.toString();
    }

    private void throwArchiCodeException(ArchiCodeException e) {
        throw e;
    }

    private void throwError(String message, int line, int column) {
        throw new ArchiCodeException(message, line, column);
    }
}
