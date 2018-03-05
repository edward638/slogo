package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

/**
 * @author Belanie Nagiel
 * 
 * Home class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Home extends GenCommand implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Home(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * moves turtle to the center of the screen (0 0)
	 * 
	 * @return the distance turtle moved
	 */
	public double evaluate(List<NodeI> arguments) {
		double distance = Math.sqrt(Math.pow(turtle.getHome()[0] - turtle.getXCoordinate(), 2) + Math.pow(turtle.getHome()[1] - turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(turtle.getHome()[0], turtle.getHome()[1]);
		value = distance;
		return distance;
	}


}
