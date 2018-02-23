package nodes;

public abstract class Node 
{
	public Node()
	{
		//Node(value,children)
		//initialize value at zero
		//children = arguments + 1
	}
	
	public abstract double getValue();
	
	public abstract void evalute();
}