package nodes;

/**
 * Most basic type of node. Just stores a value.
 *
 * author: Charles Dracos
 */
public class Constant implements NodeInterface {
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

}