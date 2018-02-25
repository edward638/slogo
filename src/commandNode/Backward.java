package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

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
	public double evalute(ArrayList<Double> arguments) 
	{
		double xCor = turtle.getXCoordinate() - arguments.get(0)*Math.sin(turtle.getDirectionAngle());
		double yCor = turtle.getYCoordinate() - arguments.get(0)*Math.cos(turtle.getDirectionAngle());
		turtle.setCoordinates(xCor,yCor);
		//add a line
		
		return arguments.get(0);
	}
}
