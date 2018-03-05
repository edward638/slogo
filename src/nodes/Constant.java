package nodes;

import java.util.List;

/**
 * Most basic type of node. Just stores a value.
 *
 * author: Charles Dracos
 */
public class Constant implements NodeI{
	private double value;

	/**
	 * Constructor, gives the constant its value
	 * @param value the value of the node
	 */
	public Constant (double value) {
		this.value = value;
	}

	public double getValue() {
		return value; //returns value
	}

	public boolean hasNext() {
		return false; //never has a child
	}
}