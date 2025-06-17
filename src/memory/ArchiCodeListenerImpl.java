package memory;

import java.util.HashMap;
import java.util.Stack;

public class ArchiCodeListenerImpl {

    public Stack<HashMap<String, Value>> Variables = new Stack<HashMap<String, Value>>();

    private void newScope(){
        Variables.push(new HashMap<>());
    }

    private void exitScope(){
        Variables.pop();
    }
}
