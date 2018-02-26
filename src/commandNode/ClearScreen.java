package commandNode;


import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class ClearScreen extends Node implements CommandNode {

	public ClearScreen(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * erases turtle's trails and sends it to the home position
	 * 
	 * @return the distance the turtle moved
	 */
	public double evaluate(List<Node> arguments) {
		double distance = Math.sqrt(Math.pow(0 - turtle.getXCoordinate(), 2) + Math.pow(0 - turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(0, 0);
		turtle.clearLines();
		value = distance;
		return value;
	}


}
