package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class ShowTurtle extends GeneralCommand  {

	public ShowTurtle(Model model, int numChildren) {
		super(model, numChildren);
	}

	@Override
	/**
	 * makes turtle visible
	 * 
	 * @return 1
	 */
	public double evaluate(List<NodeInterface> arguments) {
		for (Turtle turtle: model.getActiveTurtles())
		{
			turtle.setTurtleShowing(true);
		}
		value = 1;
		return value;
	}

}
