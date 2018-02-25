package Tree;

public class HeadException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private static final String eMessage = "Error: The head node is not a command";
	
	public HeadException (Throwable cause) {
		super(cause);
	}
	
	public HeadException () {
		super(eMessage);
	}
}
