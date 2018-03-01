package nodes;

import java.util.List;

/**
 * Most basic type of node. Just stores a value.
 *
 * author: Charles Dracos
 */
public class Constant extends Node{
	private double value;

	/**
	 * Constructor, gives the constant its value
	 * @param value the value of the node
	 */
	public Constant (double value) {
		super(null, 0);
		this.value = value;
	}

	public double getValue() {
		return value; //returns value
	}

	public double evaluate(List<Node> args) {
		return value; //evaluates the nodes, returns value
	}
}