package memory;

import gen.ArchiCodeParser;

import java.util.Map;

public class Blueprint {

    String name;
    String signature;
    Map<String, String> params;
    ArchiCodeParser.BlockContext block;
    String returnName;
    Value returnValue;
    Type returnType;
    boolean isVoid;

    public Blueprint(String name, String signature, Map<String, String> params, ArchiCodeParser.BlockContext block,String returnName ,Value returnValue, Type returnType) {
        this.name = name;
        this.signature = signature;
        this.params = params;
        this.block = block;
        this.returnName = returnName;
        this.returnValue = returnValue;
        this.isVoid = false;
        this.returnType = returnType;
    }

    public Blueprint(String name, String signature, Map<String, String> params, ArchiCodeParser.BlockContext block) {
        this.name = name;
        this.signature = signature;
        this.params = params;
        this.block = block;
        this.isVoid = true;
    }


    public static String generateSignature(ArchiCodeParser.ParamListContext paramList) {
        if(paramList == null) return "";
        StringBuilder signature = new StringBuilder();
        for(ArchiCodeParser.ParamContext param : paramList.param()) {
            if(!signature.isEmpty()){
                signature.append(",");
            }
            Type type = Type.fromString(param.type().getText());
            signature.append(type.toString());
        }
        return signature.toString();
    }

    public Map<String, String> getParams(){
        return params;
    }

    public ArchiCodeParser.BlockContext getBlock(){
        return block;
    }

    public String getReturnName() {
        return returnName;
    }

    public Value getReturnValue() {
        return returnValue;
    }

    public boolean isVoid() {
        return isVoid;
    }

    public Type getReturnType() {
        return returnType;
    }
}
