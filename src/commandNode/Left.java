package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Left extends Node implements CommandNode {

	public Left(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle counterclockwise by degrees angle
	 * 
	 * @return the value of degrees
	 */
	public double evaluate(List<Node> arguments) 
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
