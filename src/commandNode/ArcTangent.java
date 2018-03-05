package commandNode;


import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

/**
 * @author Belanie Nagiel
 * 
 * ArcTangent class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class ArcTangent extends GenCommand implements CommandNode{

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public ArcTangent(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * return arctangent of degrees
	 * 
	 * @return arctan(degrees)
	 */
	public double evaluate(List<NodeI> arguments)
	{
		double arctan = Math.atan(arguments.get(0).getValue());
		value = arctan;
		return value;
	}

}
