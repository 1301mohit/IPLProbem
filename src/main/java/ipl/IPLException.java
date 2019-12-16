package ipl;

public class IPLException extends Exception {

    public enum ExceptionType {
        NO_DATA_FOUND, NO_SUCH_FILE
    }

    public ExceptionType type;

    public IPLException() {}

    public IPLException(String s, ExceptionType type) {
        super(s);
        this.type = type;
    }

}
