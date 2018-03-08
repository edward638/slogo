package view.view_exceptions;

public class ImproperScreenComponentException extends RuntimeException{
    public ImproperScreenComponentException() {
        super();
    }
    public ImproperScreenComponentException(String s) {
        super(s);
    }
    public ImproperScreenComponentException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public ImproperScreenComponentException(Throwable throwable) {
        super(throwable);
    }
}
