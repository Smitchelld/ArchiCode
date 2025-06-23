package memory;

public class FloatValue extends Value {
    public FloatValue(Float value) {
        super(value, Type.FLOAT);
    }

    @Override
    public float getFloat() {
        return (float) value;
    }

    @Override
    public int getInt() {
        return (int) getFloat();
    }

    @Override
    public boolean getBoolean() {
        return getFloat() != 0;
    }

    @Override
    public Value add(Value v) {
        if(v.type == Type.FLOAT || v.type == Type.INT) {
            return new FloatValue(getFloat() + v.getFloat());
        }
        return super.add(v);
    }

    @Override
    public Value sub(Value v) {
        if(v.type == Type.FLOAT || v.type == Type.INT) {
            return new FloatValue(getFloat() - v.getFloat());
        }
        return super.sub(v);
    }

    @Override
    public Value mul(Value v) {
        if(v.type == Type.FLOAT || v.type == Type.INT) {
            return new FloatValue(getFloat() * v.getFloat());
        }
        return super.mul(v);
    }

    @Override
    public Value div(Value v) {
        if(v.getInt() == 0){
            throw new ArithmeticException("Cannot divide by 0");
        }
        if(v.type == Type.FLOAT || v.type == Type.INT) {
            return new FloatValue(getFloat() / v.getFloat());
        }
        return super.div(v);
    }

    @Override
    public Value eq(Value v) {
        if(v.type == Type.FLOAT || v.type == Type.INT) {
            return getFloat() == v.getFloat() ? TRUE : FALSE;
        }
        return super.eq(v);
    }

    @Override
    public Value gt(Value v) {
        if(v.type == Type.FLOAT || v.type == Type.INT) {
            return getFloat() > v.getFloat() ? TRUE : FALSE;
        }
        return super.gt(v);
    }

    @Override
    public Value lt(Value v) {
        if(v.type == Type.FLOAT || v.type == Type.INT) {
            return getFloat() < v.getFloat() ? TRUE : FALSE;
        }
        return super.gt(v);
    }

    @Override
    public Value neg() {
        return new FloatValue(-getFloat());
    }
}
