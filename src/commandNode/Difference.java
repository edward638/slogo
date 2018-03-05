package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

/**
 * @author Belanie Nagiel
 * 
 * Difference class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Difference extends GenCommand implements CommandNode{

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Difference(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns difference of the values of expr1 and expr2
	 * 
	 * @return expr1 - expr2
	 */
	public double evaluate(List<NodeI> arguments) {
		double diff = arguments.get(0).getValue() - arguments.get(1).getValue();
		value = diff;
		return value;
	}
}
