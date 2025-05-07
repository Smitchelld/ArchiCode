public enum VarType {
    INT, BOOL, STRING, FLOAT, CHAR, UNKNOWN;

    public static VarType fromString(String text) {
        return switch (text) {
            case "int" -> INT;
            case "bool" -> BOOL;
            case "string" -> STRING;
            case "float" -> FLOAT;
            case "char" -> CHAR;
            default -> UNKNOWN;
        };
    }

    public boolean isNumeric() {
        return this == INT || this == FLOAT;
    }
}