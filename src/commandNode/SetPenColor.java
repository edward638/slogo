package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class SetPenColor extends GenCommand implements CommandNode{

	public SetPenColor(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
	}

	@Override
	/**
	 * sets color of the pen to that represented by index
	 * 
	 * @return given index
	 */
	public double evaluate(List<NodeI> arguments) {
		turtle.setPenColor(arguments.get(0).getValue());
		value = arguments.get(0).getValue();
		return value;
	}

}
