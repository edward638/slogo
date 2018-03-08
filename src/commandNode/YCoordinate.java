package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class YCoordinate extends GeneralCommand {

	public YCoordinate(Model model, int numChildren) {
		super(model, numChildren);
	}

	@Override
	/**
	 * returns the turtle's Y coordinate from the center of the screen
	 * 
	 * @return turtle's Y
	 */
	public double evaluate(List<NodeInterface> arguments) {
		for (Turtle turtle: model.getActiveTurtles())
		{
			value = turtle.getYCoordinate();
		}
		return value;
	}

}
