package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class Right extends GenCommand implements CommandNode {

	public Right(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle clockwise by degrees angle
	 * 
	 * @return the value of degrees
	 */
	public double evaluate(List<NodeI> arguments)
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
