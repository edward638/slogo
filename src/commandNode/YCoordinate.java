package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class YCoordinate extends Node implements CommandNode {

	public YCoordinate(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's Y coordinate from the center of the screen
	 * 
	 * @return turtle's Y
	 */
	public double evaluate(List<Node> arguments) {
		value = turtle.getYCoordinate();
		return value;
	}

}
