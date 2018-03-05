package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class XCoordinate extends GenCommand implements CommandNode {

	public XCoordinate(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's X coordinate from the center of the screen
	 * 
	 * @return turtle's x
	 */
	public double evaluate(List<NodeI> arguments) {
		value = turtle.getXCoordinate();
		return value;
	}

}
