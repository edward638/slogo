package Tree;

public class NodeArgumentException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private static final String eMessage = "ERROR: There are an improper amount of arguments";
	
	public NodeArgumentException(Throwable cause) {
		super(cause);
	}
	
	public NodeArgumentException() {
		super(eMessage);
	}
}
