package ipl;

public class IPLException extends Exception {

    public enum ExceptionType {
        NO_SUCH_FILE
    }

    ExceptionType type;

    public IPLException() {}

    public IPLException(String s, ExceptionType type) {
        super(s);
        this.type = type;
    }

}
