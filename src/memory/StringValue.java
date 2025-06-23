package memory;

public class StringValue extends Value {
    public StringValue(Object value) {
        super(value, Type.STRING);
    }

    @Override
    public int getInt() {
        return Integer.parseInt(getString());
    }

    @Override
    public Value eq(Value v) {
        if(v.type == Type.STRING) {
            return getString().equals(v.getString()) ? TRUE : FALSE;
        }
        return super.eq(v);
    }
}
