package Tree;

/**
 * Exception for when the top of a tree is not a valid head
 *
 * author: Charles Dracos
 */
public class HeadException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private static final String eMessage = "Error: The head node is not a command";
	
	public HeadException () {
		super(eMessage);
	}
}
