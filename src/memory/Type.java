package memory;

import java.util.HashMap;
import java.util.Map;

public enum Type {
    INT("int"),
    FLOAT("float"),
    STRING("string"),
    CHAR("char"),
    BOOL("bool"),
    NULL("null");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public static Type inferType(Value val) {
        var value = val.value;
        if(value instanceof Integer) {return INT;}
        if(value instanceof Float) {return FLOAT;}
        if(value instanceof String) {return STRING;}
        if(value instanceof Character) {return CHAR;}
        if(value instanceof Boolean) {return BOOL;}
        return NULL;
        //TODO
    }

    public String getName() {
        return name;
    }

    private static final Map<String, Type> LOOKUP = new HashMap<>();

    static {
        for (Type t : Type.values()) {
            LOOKUP.put(t.name, t);
        }
    }

    public static Type fromString(String str) {
        Type result = LOOKUP.get(str);
        if (result == null) {
            throw new IllegalArgumentException("Unknown type: " + str);
        }
        return result;
    }
}
