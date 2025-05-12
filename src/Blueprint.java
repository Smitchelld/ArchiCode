import java.util.List;
import java.util.Map;

public class Blueprint {
    private final String name;
    private final String signature;
    private final Map<String, String> params;
    private final ArchiCodeParser.BlockContext block;
    private final String returnName;
    private final Variable returnVariable;

    public Blueprint(String name, String signature, Map<String, String> params, ArchiCodeParser.BlockContext block,String returnName ,Variable returnVariable) {
        this.name = name;
        this.signature = signature;
        this.params = params;
        this.block = block;
        this.returnName = returnName;
        this.returnVariable = returnVariable;
    }
    public String getName() {
        return name;
    }

    public String getSignature() {
        return signature;
    }

    public Map<String,String> getParams() {
        return params;
    }

    public Variable getReturnVariable() {
        return returnVariable;
    }

    public String getReturnName() {
        return returnName;
    }

    public ArchiCodeParser.BlockContext getBlock() {
        return block;
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


