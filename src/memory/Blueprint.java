package memory;

import gen.ArchiCodeParser;

import java.util.Map;

public class Blueprint {

    public Blueprint(String name, String signature, Map<String, String> params, ArchiCodeParser.BlockContext block,String returnName ,Value returnValue) {
    }

    public Blueprint(String name, String signature, Map<String, String> params, ArchiCodeParser.BlockContext block) {
    }


    public static String generateSignature(ArchiCodeParser.ParamListContext paramList) {
        if(paramList == null) return "";
        StringBuilder signature = new StringBuilder();
        for(ArchiCodeParser.ParamContext param : paramList.param()) {
            if(!signature.isEmpty()){
                signature.append(",");
            }
            signature.append(param.type().getText());
        }
        return signature.toString();
    }

}
