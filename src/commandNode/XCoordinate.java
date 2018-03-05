package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class XCoordinate extends GeneralCommand implements CommandInterface {

	public XCoordinate(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's X coordinate from the center of the screen
	 * 
	 * @return turtle's x
	 */
	public double evaluate(List<NodeInterface> arguments) {
		value = turtle.getXCoordinate();
		return value;
	}

}
