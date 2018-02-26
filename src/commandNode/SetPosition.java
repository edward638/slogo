package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class SetPosition extends Node implements CommandNode {

	public SetPosition(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * moves turtle to an absolute screen position, where (0, 0) is the center of the screen
	 * 
	 * @return the distance the turtle moved
	 */
	public double evaluate(List<Node> arguments) 
	{
		double distance = Math.sqrt(Math.pow(arguments.get(0).getValue() - 
				turtle.getXCoordinate(), 2) + Math.pow(arguments.get(1).getValue() - 
						turtle.getYCoordinate(), 2) );
		turtle.setCoordinates(arguments.get(0).getValue(), arguments.get(1).getValue());
		value = distance;
		return value;
	}


}
