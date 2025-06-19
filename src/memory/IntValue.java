package memory;

import com.sun.jdi.IntegerValue;

public class IntValue extends Value{
    public IntValue(int value) {
        super(value, Type.INT);
    }

    @Override
    public int getInt() {
        return (int) value;
    }

    @Override
    public float getFloat() {
        return (float) getInt();
    }

    @Override
    public boolean getBoolean() {
        if(getInt() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Value add(Value v) {
        if(v.type == Type.INT) {
            return new IntValue(getInt() + v.getInt());
        }else if(v.type == Type.FLOAT){
            return new FloatValue(getFloat() + v.getFloat());
        }
        return super.add(v);
    }

    @Override
    public Value sub(Value v) {
        if(v.type == Type.INT) {
            return new IntValue(getInt() - v.getInt());
        }else if(v.type == Type.FLOAT){
            return new FloatValue(getFloat() - v.getFloat());
        }
        return super.sub(v);
    }

    @Override
    public Value mul(Value v) {
        if(v.type == Type.INT) {
           return new IntValue(getInt() * v.getInt());
        }else if(v.type == Type.FLOAT){
            return new FloatValue(getFloat() * v.getFloat());
        }
        return super.mul(v);
    }

    @Override
    public Value div(Value v) {
        if(v.getInt() == 0){
            throw new ArithmeticException("Cannot divide by 0");
        }
        if(v.type == Type.INT) {
            return new IntValue(getInt() / v.getInt());
        }else if(v.type == Type.FLOAT){
            return new FloatValue(getFloat() / v.getFloat());
        }

        return super.div(v);
    }

    @Override
    public Value eq(Value v) {
        if(v.type == Type.INT) {
            return new BoolValue(getInt() == v.getInt());
        }else if(v.type == Type.FLOAT){
            return new BoolValue(getFloat() == v.getFloat());
        }else if(v.type == Type.BOOL){
            return new BoolValue(getBoolean() == v.getBoolean());
        }
        return super.eq(v);
    }
}
