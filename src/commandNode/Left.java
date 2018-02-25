package commandNode;

import java.util.List;

import model.Turtle;
import nodes.Node;

public class Left extends Node{

	public Left(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle counterclockwise by degrees angle
	 * 
	 * @return the value of degrees
	 */
	public double evaluate(List<Double> arguments) 
	{
		double deg = turtle.getDirectionAngle() + arguments.get(0);
		if (deg > 360)
		{
			deg = deg - 360;
		}
		turtle.setDirectionAngle(deg);
		value = arguments.get(0);
		return arguments.get(0);
	}



}
