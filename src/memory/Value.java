package memory;

public class Value {

    public static final Value TRUE = new BoolValue(true);
    public static final Value FALSE = new BoolValue(false);

    public Object value;
    public Type type;
    public Value(Object value, Type type) {
        this.value = value;
        this.type = type;
    }

    public int getInt(){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float getFloat(){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getString(){
        return String.valueOf(value);
    }

    public char getChar(){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getBoolean(){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Value mul(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Value div(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Value add(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Value sub(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Value eq(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Value gt(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Value gte(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Value lt(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Value lte(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Value mod(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Value neq(Value v){
        return eq(v).equals(FALSE) ? TRUE : FALSE;
    }

    Value neg(Value v){
        //TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Value and(Value v){
        //TODO
        try{
            return new BoolValue(getBoolean() && v.getBoolean());
        }catch (Exception e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public Value or(Value v){
        //TODO
        try{
            return new BoolValue(getBoolean() || v.getBoolean());
        }catch (Exception e){
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }




}
