package view.view_exceptions;

/**
 * The purpose of this class is to to provide an unchecked Exception that gets thrown whenever
 * bad simulation events happen. e.g. trying to produce a cell of a simulation type that doesn't fit the list
 * of possible simulation types
 * @author Andy Nguyen
 *
 */
public class BadResourceNameException extends RuntimeException{
	public BadResourceNameException() {
        super();
    }
    public BadResourceNameException(String s) {
        super(s);
    }
    public BadResourceNameException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public BadResourceNameException(Throwable throwable) {
        super(throwable);
    }
}
