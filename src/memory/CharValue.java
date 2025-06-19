package memory;

public class CharValue extends Value{
    public CharValue(char value) {
        super(value, Type.CHAR);
    }
    @Override
    public char getChar() {
        return (char) value;
    }

    @Override
    public String getString() {
        return String.valueOf(getChar());
    }

    @Override
    public Value add(Value v) {
        if(v.type == Type.CHAR){
            return new StringValue(getString() + v.getString());
        }
        return super.add(v);
    }
}
