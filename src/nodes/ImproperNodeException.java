package nodes;

public class ImproperNodeException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private static final String eMessage = "Error: Incorrect node arguments";

    public ImproperNodeException(Throwable cause) {
        super(cause);
    }

    public ImproperNodeException() {
        super(eMessage);
    }
}