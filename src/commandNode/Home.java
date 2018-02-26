package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Home extends Node implements CommandNode {

	public Home(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * moves turtle to the center of the screen (0 0)
	 * 
	 * @return the distance turtle moved
	 */
	public double evaluate(List<Node> arguments) {
		double distance = Math.sqrt(Math.pow(0 - turtle.getXCoordinate(), 2) + Math.pow(0 - turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(0, 0);
		value = distance;
		return distance;
	}


}
