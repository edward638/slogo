package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Home extends Node implements CommandNode{

	public Home(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * moves turtle to the center of the screen (0 0)
	 * 
	 * @return the distance turtle moved
	 */
	public double evalute(ArrayList<Double> arguments) {
		double distance = Math.sqrt(Math.pow(0 - turtle.getXCoordinate(), 2) + Math.pow(0 - turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(0, 0);
		return distance;
	}


}
