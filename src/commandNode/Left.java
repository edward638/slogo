package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

/**
 * @author Belanie Nagiel
 * 
 * Left class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandInterface interface.
 *
 */
public class Left extends GeneralCommand implements CommandInterface {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Left(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle counterclockwise by degrees angle
	 * 
	 * @return the value of degrees
	 */
	public double evaluate(List<NodeInterface> arguments)
	{
		double deg = turtle.getDirectionAngle() + arguments.get(0).getValue();

		if (deg > 360)
		{
			deg = deg - 360;
		}

		turtle.setDirectionAngle(deg);
		value = arguments.get(0).getValue();
		return value;
	}



}
