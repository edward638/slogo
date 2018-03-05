package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class SetPosition extends GenCommand implements CommandNode {

	public SetPosition(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * moves turtle to an absolute screen position, where (0, 0) is the center of the screen
	 * 
	 * @return the distance the turtle moved
	 */
	public double evaluate(List<NodeI> arguments)
	{
		double distance = Math.sqrt(Math.pow(arguments.get(0).getValue() + turtle.getHome()[0] - 
				turtle.getXCoordinate(), 2) + Math.pow(arguments.get(1).getValue() + turtle.getHome()[1] - 
						turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(arguments.get(0).getValue() + turtle.getHome()[0], (-1 * arguments.get(1).getValue()) + turtle.getHome()[1]);
		value = distance;
		return value;
	}


}
