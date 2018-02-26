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
		double distance = Math.sqrt(Math.pow(turtle.getHome()[0] - turtle.getXCoordinate(), 2) + Math.pow(turtle.getHome()[1] - turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(turtle.getHome()[0], turtle.getHome()[1]);
		value = distance;
		return distance;
	}


}
