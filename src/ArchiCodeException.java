public class ArchiCodeException extends RuntimeException{

    private int line;
    private int column;
    private String fileName;

    public ArchiCodeException(String message, int line, int column){
        super(">line " + line + ":" + column + " => " + message);
    }
}
