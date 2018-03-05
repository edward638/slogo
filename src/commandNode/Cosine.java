package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

/**
 * @author Belanie Nagiel
 * 
 * Cosine class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Cosine extends GenCommand implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Cosine(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * return cosine of degrees
	 * 
	 * @return cos(degrees)
	 */
	public double evaluate(List<NodeI> arguments) {
		double cos = Math.cos(arguments.get(0).getValue());
		value = cos;
		return value;
	}

}
