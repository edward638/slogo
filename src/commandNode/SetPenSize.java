package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class SetPenSize extends GeneralCommand implements CommandInterface {

	public SetPenSize(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
	}

	@Override
	/**
	 * sets size of the pen to be pixels thickness
	 * 
	 * @return given pixels
	 */
	public double evaluate(List<NodeInterface> arguments) {
		turtle.setPenSize(arguments.get(0).getValue());
		value = arguments.get(0).getValue();
		return value;
	}


}
