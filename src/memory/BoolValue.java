package memory;

public class BoolValue extends Value {
    public BoolValue(boolean value) {
        super(value, Type.BOOL);
    }


    @Override
    public boolean getBoolean() {
        return (boolean)value;
    }

    @Override
    public Value and(Value v) {
        if(v.type == Type.BOOL) {
            return new BoolValue(getBoolean() && v.getBoolean());
        }
        return super.and(v);
    }

    @Override
    public Value or(Value v) {
        if(v.type == Type.BOOL) {
            return new BoolValue(getBoolean() || v.getBoolean());
        }
        return super.or(v);
    }
}
