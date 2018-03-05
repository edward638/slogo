package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class SetPenSize extends GenCommand implements CommandNode {

	public SetPenSize(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
	}

	@Override
	/**
	 * sets size of the pen to be pixels thickness
	 * 
	 * @return given pixels
	 */
	public double evaluate(List<NodeI> arguments) {
		turtle.setPenSize(arguments.get(0).getValue());
		value = arguments.get(0).getValue();
		return value;
	}

}
