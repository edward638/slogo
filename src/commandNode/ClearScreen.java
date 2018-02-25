package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class ClearScreen extends Node implements CommandNode{

	public ClearScreen(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * erases turtle's trails and sends it to the home position
	 * 
	 * @return the distance the turtle moved
	 */
	public double evalute(ArrayList<Double> arguments) {
		double distance = Math.sqrt(Math.pow(0 - turtle.getXCoordinate(), 2) + Math.pow(0 - turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(0, 0);
		//clear the turtle's trails
		
		return distance;
	}


}
