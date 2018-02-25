package commandNode;

import java.util.List;

import model.Turtle;
import nodes.Node;

public class Right extends Node {

	public Right(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle clockwise by degrees angle
	 * 
	 * @return the value of degrees
	 */
	public double evaluate(List<Double> arguments) 
	{
		double deg = turtle.getDirectionAngle() - arguments.get(0);
		if (deg < 0)
		{
			deg = 360 - deg;
		}
		turtle.setDirectionAngle(deg);
		value = arguments.get(0);
		return arguments.get(0);
	}

	
}
