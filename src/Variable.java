public class Variable {
    private final VarType type;
    private Object value;

    public Variable(VarType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public VarType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + value;
    }
}

