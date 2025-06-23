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
    public float getFloat() {
        if(getBoolean()){
            return 1.0F;
        }
        return 0.0F;
    }

    @Override
    public int getInt() {
        if(getBoolean()){
            return 1;
        }
        return 0;
    }

    @Override
    public char getChar() {
        if(getBoolean()){
            return 't';
        }
        return 'f';
    }

    @Override
    public Value and(Value v) {
        if(v.type == Type.BOOL) {
            return getBoolean() && v.getBoolean() ? TRUE : FALSE;
        }
        return super.and(v);
    }

    @Override
    public Value or(Value v) {
        if(v.type == Type.BOOL) {
            return getBoolean() || v.getBoolean() ? TRUE : FALSE;
        }
        return super.or(v);
    }

    @Override
    public Value eq(Value v) {
        if(v.type == Type.BOOL) {
            return getBoolean() == v.getBoolean() ? TRUE : FALSE;
        }
        return super.eq(v);
    }

    @Override
    public Value not() {
        return !(getBoolean()) ? TRUE : FALSE;
    }
}
