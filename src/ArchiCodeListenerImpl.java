import gen.ArchiCodeBaseListener;
import gen.ArchiCodeParser;
import memory.Blueprint;
import memory.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ArchiCodeListenerImpl extends ArchiCodeBaseListener {

    public Stack<HashMap<String, Value>> Variables = new Stack<HashMap<String, Value>>();
    public Map<String, Map<String, Blueprint>> Blueprints = new HashMap<>();



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
        if(scope.containsKey(name)){
            throw new RuntimeException("Duplicate Variable name: " + name);
        }

        scope.put(name,null);
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
        String name = ctx.CapitalVarName().getText();

        String signature = Blueprint.generateSignature(ctx.paramList());
        if(Blueprints.containsKey(name) && Blueprints.get(name).containsKey(signature)){
            throw new RuntimeException("Duplicate Blueprint name: " + name);
        }

        Map<String, String> params = new HashMap<>();

        if(ctx.paramList() != null){
            for(var param : ctx.paramList().param()){
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
            Blueprints.get(name).put(signature, blueprint);
        }
        else{
            Blueprints.put(name, new HashMap<>());
            Blueprints.get(name).put(signature, blueprint);
        }

        for (Map.Entry<String, Map<String, Blueprint>> outerEntry : Blueprints.entrySet()) {
            String outerKey = outerEntry.getKey();
            Map<String, Blueprint> innerMap = outerEntry.getValue();

            for (String innerKey : innerMap.keySet()) {
                System.out.println("Blueprint: " + outerKey + " -> " + innerKey);
            }
        }
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
