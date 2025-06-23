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
        try{
            return Integer.parseInt(value.toString());
        }catch(Exception e){
            throw new UnsupportedOperationException("Cannot get int from " + type);
        }

    }

    public float getFloat(){
        try{
            return Float.parseFloat(value.toString());
        }catch(Exception e){
            throw new UnsupportedOperationException("Cannot get float from " + type);
        }
    }

    public String getString(){
        return String.valueOf(value);
    }

    public char getChar(){
        //TODO
        try{
            return value.toString().charAt(0);
        }catch(Exception e){
            throw new UnsupportedOperationException("Cannot get char from " + type);
        }
    }

    public boolean getBoolean(){
        //TODO
        try{
            return Boolean.parseBoolean(value.toString());
        }catch(Exception e){
            throw new UnsupportedOperationException("Cannot get boolean from " + type);
        }
    }

    public Value mul(Value v){
        //TODO
        throw new UnsupportedOperationException("Cannot mul " + type + " and " + v.type);
    }

    public Value div(Value v){
        //TODO
        throw new UnsupportedOperationException("Cannot div " + type + " by " + v.type);
    }

    public Value add(Value v){
        //TODO
        throw new UnsupportedOperationException("Cannot add " + type + " to " + v.type);
    }

    public Value sub(Value v){
        //TODO
        throw new UnsupportedOperationException("Cannot sub " + type + " from " + v.type);
    }

    public Value eq(Value v){
        //TODO
        throw new UnsupportedOperationException("Cannot compare " + type + " and " + v.type);
    }

    public Value gt(Value v){
        //TODO
        throw new UnsupportedOperationException("Cannot compare " + type + " and " + v.type);
    }

    public Value gte(Value v){
        return eq(v).equals(TRUE) || gt(v).equals(TRUE) ? TRUE : FALSE;
    }

    public Value lt(Value v){
        //TODO
        throw new UnsupportedOperationException("Cannot compare " + type + " and " + v.type);
    }

    public Value lte(Value v){
        return (eq(v).equals(TRUE) || lt(v).equals(TRUE)) ? TRUE : FALSE;
    }

    public Value mod(Value v){
        //TODO
        throw new UnsupportedOperationException("Cannot compare " + type + " and " + value);
    }

    public Value neq(Value v){
        return eq(v).equals(FALSE) ? TRUE : FALSE;
    }

    public Value neg(){
        //TODO
        throw new UnsupportedOperationException("Cannot get negative form " + type);
    }

    public Value and(Value v){
        //TODO
        try{
            return new BoolValue(getBoolean() && v.getBoolean());
        }catch (Exception e){
            throw new UnsupportedOperationException("Cannot compare " + type + " and " + v.type);
        }
    }

    public Value or(Value v){
        //TODO
        try{
            return new BoolValue(getBoolean() || v.getBoolean());
        }catch (Exception e){
            throw new UnsupportedOperationException("Cannot compare " + type + " and " + v.type);
        }
    }


    public Value not() {
        throw new UnsupportedOperationException("Cannot reverse " + type);
    }

    public Value castTo(Type targetType) {
        if (this.type == targetType) {
            return this;
        }
        switch (targetType) {
            case FLOAT:
                return new FloatValue(this.getFloat());
            case INT:
                return new IntValue(this.getInt());
            case BOOL:
                return new BoolValue(this.getBoolean());
            case CHAR:
                return new CharValue(this.getChar());
            case STRING:
                return new StringValue(this.toString());
            default:
                throw new IllegalArgumentException("Unsupported cast to " + targetType);
        }
    }
}
