package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class YCoordinate extends GeneralCommand implements CommandInterface {

	public YCoordinate(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's Y coordinate from the center of the screen
	 * 
	 * @return turtle's Y
	 */
	public double evaluate(List<NodeInterface> arguments) {
		value = turtle.getYCoordinate();
		return value;
	}

}
