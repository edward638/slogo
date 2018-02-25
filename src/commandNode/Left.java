package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Left extends Node implements CommandNode{

	public Left(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle counterclockwise by degrees angle
	 * 
	 * @return the value of degrees
	 */
	public double evalute(ArrayList<Double> arguments) 
	{
		double deg = turtle.getDirectionAngle() + arguments.get(0);
		if (deg > 360)
		{
			deg = deg - 360;
		}
		turtle.setDirectionAngle(deg);
		
		return arguments.get(0);
	}



}
