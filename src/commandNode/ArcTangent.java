package commandNode;


import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

/**
 * @author Belanie Nagiel
 * 
 * ArcTangent class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandInterface interface.
 *
 */
public class ArcTangent extends GeneralCommand implements CommandInterface {

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
	public double evaluate(List<NodeInterface> arguments)
	{
		double arctan = Math.atan(arguments.get(0).getValue());
		value = arctan;
		return value;
	}

}
