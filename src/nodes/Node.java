package nodes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import model.Turtle;

/**
 * This is the abstract class Node which represents any node to be added into the tree.
 * A node has a varying amount of children depending on the type of node and command type.
 * It allows one to go through its children and access their values while also adding
 * nodes in the given amount for the command.
 *
 * author: Charles Dracos
 */
public abstract class Node 
{
	private Node[] children;
	private int current;
	protected double value;
	protected Turtle turtle;

	/**
	 * Creates a new node
	 * @param turt The turtle a node may need to manipulate
	 * @param numChildren The amount of children a node will have
	 */
	public Node(Turtle turt, int numChildren)
	{
		children = new Node[numChildren];
		current = 0;
		turtle = turt;
	}

	/**
	 * Sees if there is a next child to be evaluated
	 * @return true if there is another child, false otherwise
	 */
	public boolean hasNext() 
	{
		if (current!=children.length) return true;
		return false;
	}

	/**
	 * Adds a child node if there is space for the child to be added
	 * @param n Node to be added
	 */
	public void addChild(Node n) 
	{
		if (current != children.length) {
			children[current] = n;
		}
	}

	/**
	 * Returns the child where to node is currently on queue to look at,
	 * increments where the node should be looking for its next child
	 * @return current child node, null if no child
	 */
	public Node getChild() 
	{
		if (current!=children.length) {
			Node child = children[current];
			current++;
			return child;
		}
		return null;
	}

	/**
	 * Resets the current to the first child
	 */
	public void reset() {
		current = 0;
	}

	public double getValue()
	{
		return value; //returns value stored by the node
	}

	/**
	 * Evaluates a node. A command's evaluation does the commands using its
	 * children nodes args, a list evaluates its children, and constant/variable
	 * just return their values
	 * @param args children nodes whose values will be used in computation
	 * @return the return value required by the command
	 */
	public abstract double evaluate (List<Node> args);
}