import gen.ArchiCodeBaseListener;
import gen.ArchiCodeParser;
import memory.Blueprint;
import memory.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ArchiCodeListenerImpl extends ArchiCodeBaseListener {

    public Stack<HashMap<String, String>> Variables = new Stack<>();
    public Map<String, Map<String, String>> Blueprints = new HashMap<>();


    ArchiCodeListenerImpl(){
        newScope();
    }

    private void newScope(){
        Variables.push(new HashMap<>());
    }

    private void exitScope(){
        Variables.pop();
    }

    @Override
    public void enterBlock(ArchiCodeParser.BlockContext ctx) {
        newScope();
    }

    @Override
    public void exitBlock(ArchiCodeParser.BlockContext ctx) {
        exitScope();
    }

    @Override
    public void enterDefineStatement(ArchiCodeParser.DefineStatementContext ctx) {
        var scope = Variables.peek();
        var name = ctx.VarName().getText();
        var line = ctx.getStart().getLine();
        var column = ctx.getStart().getCharPositionInLine();
        String declaration = "line " + line + " column " + column;
        if(scope.containsKey(name)){
            throw new RuntimeException("Variable {" + name +"} already defined at " + scope.get(name));
        }

        scope.put(name,declaration);
//        for(int i = 0; i < Variables.size(); i++){
//            var variable = Variables.get(i);
//            var variableKey = variable.keySet();
//            for(int k = 0; k < i; k++){
//                System.out.print(" ");
//            }
//            System.out.println(variableKey);
//        }
//        System.out.println("==============");
    }

    @Override
    public void enterBlueprintStatement(ArchiCodeParser.BlueprintStatementContext ctx) {
        newScope();
        String name = ctx.CapitalVarName().getText();
        String signature = Blueprint.generateSignature(ctx.paramList());

        var line = ctx.getStart().getLine();
        var column = ctx.getStart().getCharPositionInLine();
        String declaration = "line " + line + " column " + column;

        if(Blueprints.containsKey(name) && Blueprints.get(name).containsKey(signature)){
            throw new RuntimeException("Blueprint{"+ name + " (" + signature + ")} already defined at " + Blueprints.get(name).get(signature));
        }

        Map<String, String> params = new HashMap<>();
        var scope = Variables.peek();
        if(ctx.paramList() != null){
            for(var param : ctx.paramList().param()){
                if(scope.containsKey(param.VarName().getText())){
                    System.err.println("Error at line "+ctx.getStart().getLine() +": Variable {" + param.VarName().getText() +"} already defined at " + scope.get(param.VarName().getText()));
                    System.exit(1);
                }
                String varDeclaration = "line " + param.getStart().getLine() + " column " + param.getStart().getCharPositionInLine();
                scope.put(param.VarName().getText(), varDeclaration);
                params.put(param.VarName().getText(), param.type().getText());
            }
        }
        Blueprint blueprint;
        if(ctx.type() != null && ctx.VarName() != null){
            //Value value = TODO
            String returnName = ctx.VarName().getText();

            blueprint = new Blueprint(name, signature, params, ctx.block(), returnName, null);
        }else{
            blueprint = new Blueprint(name, signature, params, ctx.block());
        }

        if(Blueprints.containsKey(name)){
            Blueprints.get(name).put(signature, declaration);
        }
        else{
            Blueprints.put(name, new HashMap<>());
            Blueprints.get(name).put(signature, declaration);
        }
        exitScope();
    }

    @Override
    public void enterRepeatFixed(ArchiCodeParser.RepeatFixedContext ctx) {
        var scope = Variables.peek();
        scope.put("step", null);

        for(int i = 0; i < Variables.size(); i++){
            var variable = Variables.get(i);
            var variableKey = variable.keySet();
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            System.out.println(variableKey);
        }
        System.out.println("==============");
    }

    @Override
    public void enterRepeatFor(ArchiCodeParser.RepeatForContext ctx) {
        var scope = Variables.peek();
        scope.put("step", null);

        for(int i = 0; i < Variables.size(); i++){
            var variable = Variables.get(i);
            var variableKey = variable.keySet();
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            System.out.println(variableKey);
        }
        System.out.println("==============");
    }

    @Override
    public void enterRepeatUntil(ArchiCodeParser.RepeatUntilContext ctx) {
        var scope = Variables.peek();
        scope.put("step", null);

        for(int i = 0; i < Variables.size(); i++){
            var variable = Variables.get(i);
            var variableKey = variable.keySet();
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            System.out.println(variableKey);
        }
        System.out.println("==============");
    }
}
