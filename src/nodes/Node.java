package nodes;

import parsers.Turtle;

public abstract class Node 
{
	private Node[] children;
	private Node parent;
	private int current;
	protected double value;
	protected Turtle turtle;
	
	public Node(Turtle turt, int numChildren)
	{
		children = new Node[numChildren];
		current = 0;
		value = 0;
		turtle = turt;
	}
	
	public boolean hasNext() 
	{
		if (current!=children.length) return true;
		return false;
	}
	
	public void setParent(Node n) 
	{
		if (n==null) {
			this.parent = this;
		}
		else { this.parent = n; }
	}
	
	public void addChild(Node n) 
	{
		if (current != children.length) {
			children[current] = n;
		}
	}
	
	public Node getChild() 
	{
		if (current!=children.length) {
			Node child = children[current];
			current++;
			return child;
		}
		return null;
	}
	
	public Node getParent() 
	{
		return parent;
	}
	
	public Double getValue() 
	{
		return value;
	}
}