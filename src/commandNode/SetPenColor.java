package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;


public class SetPenColor extends GeneralCommand implements CommandInterface{

	public SetPenColor(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
	}

	@Override
	/**
	 * sets color of the pen to that represented by index
	 * 
	 * @return given index
	 */
	public double evaluate(List<NodeInterface> arguments) {
		turtle.setPenColor(arguments.get(0).getValue());
		value = arguments.get(0).getValue();
		return value;
	}

}
