package memory;

import gen.ArchiCodeParser;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Memory {

    public Stack<HashMap<String, Value>> Variables = new Stack<HashMap<String, Value>>();
    public Map<String, Map<String, Blueprint>> Blueprints = new HashMap<>();
    public static Stack<String> FunctionCallStack = new Stack<>();
    private Path filePath;
    private static final int RecursionLimit = 30;
    private static int RecursionCounter = 0;


    public Memory(Path filePath) {
        this.filePath = filePath;
        Variables.push(new HashMap<>());
    }
    public Memory(Memory memory) {
        this.filePath = memory.filePath;
        this.Blueprints = new HashMap<>(memory.Blueprints);
        this.Variables = new Stack<>();
        HashMap<String, Value> sharedGlobalScope = memory.Variables.firstElement();
        this.Variables.push(sharedGlobalScope);
    }

    public void newScope() {
        Variables.push(new HashMap<>());
    }

    public void endScope() {
        Variables.pop();
    }

    public void createVariable(String name, Type type, Value value) {
        var scope = Variables.peek();
        if(scope.containsKey(name)){
            throw new RuntimeException("Variable already exists");
        }
        scope.put(name, value);
    }

    public Value resolveVariable(String name) {
        return resolveVariable(name, 0);
    }

    public Value resolveVariable(String name, int scopeDepth) {
        if(scopeDepth < 0 || scopeDepth >= Variables.size() - 1){
            throw new RuntimeException("Invalid scope depth");
        }
        for (int i = Variables.size() - 1 - scopeDepth; i >= 0; i--) {
            var scope = Variables.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        StringBuilder message = new StringBuilder();
        for(int i = scopeDepth; i < Variables.size(); i++){
            var variable = Variables.get(i);
            var variableKey = variable.keySet();
            if(!variableKey.isEmpty()) {
                message.append(variableKey).append(" ");
            }
        }
        message.delete(message.length() - 1, message.length());


        throw new RuntimeException("Variable {"+ name+"} not found maybe you meant one of these: " + message.toString());
    }



    public void printVariables() {
        System.out.println("=====Mem=====");
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

    public void assignValue(String varName, Value value) {
        Value var = resolveVariable(varName);
        if(var.type != value.type){
            throw new RuntimeException("Value type mismatch");
        }
        var.value = value.value;
    }

    public void createBlueprint(String name, String signature, Blueprint blueprint) {
        if(Blueprints.containsKey(name) && Blueprints.get(name).containsKey(signature)){
            throw new RuntimeException("Duplicate Blueprint name: " + name);
        }
        if(!Blueprints.containsKey(name)){
            Blueprints.put(name, new HashMap<>());
        }
        Blueprints.get(name).put(signature, blueprint);
    }

    public Blueprint resolveBlueprint(String name, String signature) {
        for(var outerEntry : Blueprints.keySet()) {
            for(var innerEntry : Blueprints.get(outerEntry).keySet()) {
                System.out.println(""+outerEntry + "-> " + innerEntry);
            }
        }
        if(!Blueprints.containsKey(name)){
            throw new RuntimeException("Blueprint not found: " + name);
        }
        if(!Blueprints.get(name).containsKey(signature)){
            StringBuilder message = new StringBuilder();
            var scope = Blueprints.get(name);
            for(var x : scope.keySet()){
                message.append(name).append("(").append(x).append(") or ");
            }
            message.delete(message.length() - 3, message.length());
            throw new RuntimeException("Blueprint not found: " + name + " (" + signature + ") maybe you meant: " + message.toString());
        }
        return Blueprints.get(name).get(signature);
    }

    public static void countRecursion(){
        RecursionCounter++;
        if(RecursionCounter > RecursionLimit){
            throw new RuntimeException("Recursion limit exceeded");
        }
    }
    public static void decrementRecursion(){
        RecursionCounter--;
    }

    public static void addCallStack(String name){
        FunctionCallStack.push(name);
    }
    public static void removeCallStack(){
        FunctionCallStack.pop();
    }
    public static String getCallStack(){
        return FunctionCallStack.peek();
    }
}
