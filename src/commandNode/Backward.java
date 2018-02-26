package commandNode;


import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Backward extends Node implements CommandNode
{

	public Backward(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 *moves turtle backward in its current heading by pixels distance
	 * 
	 * @return the value of pixels
	 */
	public double evaluate(List<Double> arguments) 
	{
		double xCor = turtle.getXCoordinate() - arguments.get(0)*Math.sin(turtle.getDirectionAngle());
		double yCor = turtle.getYCoordinate() - arguments.get(0)*Math.cos(turtle.getDirectionAngle());
		turtle.setCoordinates(xCor,yCor);
		//add a line
		value = arguments.get(0);
		return arguments.get(0);
	}
}
