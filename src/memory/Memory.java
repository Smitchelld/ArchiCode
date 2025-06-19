package memory;

import gen.ArchiCodeParser;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Memory {

    public Stack<HashMap<String, Value>> Variables = new Stack<HashMap<String, Value>>();
    public Map<String, Map<String, Blueprint>> Blueprints = new HashMap<>();

    private Path filePath;

    public Memory(Path filePath) {
        this.filePath = filePath;
        Variables.push(new HashMap<>());
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
        for(int i = Variables.size() - 1; i >= 0; i--) {;
            var scope = Variables.get(i);
            if(scope.containsKey(name)) {
                return scope.get(name);
            }

        }
        throw new RuntimeException("Variable not found" + name);
    }

    public Value resolveVariable(String name, int scopeDepth) {
        if(scopeDepth < 0 || scopeDepth > Variables.size() - 1){
            throw new RuntimeException("Invalid scope depth");
        }
        for (int i = Variables.size() - 1 - scopeDepth; i >= 0; i--) {
            var scope = Variables.get(i);
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        throw new RuntimeException("Variable not found: " + name);
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
}
