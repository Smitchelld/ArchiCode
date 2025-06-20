public class ArchiCodeException extends Exception{

    private int line;
    private int column;
    private String fileName;

    public ArchiCodeException(String message, int line, int column){
        super("Error at line " + line + ":" + column + "==> " + message);
    }

    public ArchiCodeException(String message){}

}
