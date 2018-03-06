package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class ID extends GeneralCommand implements CommandInterface{

	public ID(Model model, int numChildren) {
		super(model, numChildren);
	}

	@Override
	/**
	 * returns current active turtle's ID number
	 * ID values typically start at 1 and increase by 1 with each new turtle created
	 * 
	 * @return ID number of active turtle
	 */
	public double evaluate(List<NodeInterface> arguments) {
		for (Turtle turtle: model.getActiveTurtles())
		{
			value = turtle.getValue();
		}
		return value;
	}

}
