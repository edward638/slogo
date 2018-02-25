package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class SetPosition extends Node implements CommandNode{

	public SetPosition(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * moves turtle to an absolute screen position, where (0, 0) is the center of the screen
	 * 
	 * @return the distance the turtle moved
	 */
	public double evalute(ArrayList<Double> arguments) 
	{
		double distance = Math.sqrt(Math.pow(arguments.get(0) - turtle.getXCoordinate(), 2) + Math.pow(arguments.get(1) - turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(arguments.get(0), arguments.get(1));
		return distance;
	}


}
