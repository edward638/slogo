package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class Right extends GeneralCommand implements CommandInterface {

	public Right(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle clockwise by degrees angle
	 * 
	 * @return the value of degrees
	 */
	public double evaluate(List<NodeInterface> arguments)
	{
		double deg = turtle.getDirectionAngle() - arguments.get(0).getValue();
		if (deg < 0)
		{
			deg = 360 + deg;
		}
		turtle.setDirectionAngle(deg);
		value = arguments.get(0).getValue();
		return value;
	}

	
}
