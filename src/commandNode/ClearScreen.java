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
		double distance = Math.sqrt(Math.pow(turtle.getHome()[0] - turtle.getXCoordinate(), 2) + Math.pow(turtle.getHome()[1] - turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(turtle.getHome()[0], turtle.getHome()[1]);
		turtle.setDirectionAngle(90);
		turtle.clearLines();
		value = distance;
		return value;
	}


}
