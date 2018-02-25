package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Right extends Node implements CommandNode{

	public Right(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle clockwise by degrees angle
	 * 
	 * @return the value of degrees
	 */
	public double evalute(ArrayList<Double> arguments) 
	{
		double deg = turtle.getDirectionAngle() - arguments.get(0);
		if (deg < 0)
		{
			deg = 360 - deg;
		}
		turtle.setDirectionAngle(deg);
		
		return arguments.get(0);
	}

	
}
