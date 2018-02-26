package parsers;

public class InvalidEntryException extends Exception{
	// Parameterless Constructor
    public InvalidEntryException() {}

    // Constructor that accepts a message
    public InvalidEntryException(String message)
    {
       super(message);
    }

}
