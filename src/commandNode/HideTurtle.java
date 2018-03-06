package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

/**
 * @author Belanie Nagiel
 * 
 * HideTurtle class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandInterface interface.
 *
 */
public class HideTurtle extends GeneralCommand implements CommandInterface {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public HideTurtle(Model model, int numChildren) {
		super(model, numChildren);
	}

	@Override
	/**
	 * makes turtle invisible
	 * 
	 * @return 0
	 */
	public double evaluate(List<NodeInterface> arguments) {
		for (Turtle turtle: model.getActiveTurtles())
		{
			turtle.setTurtleShowing(false);
		}
		value = 0;
		return value;
	}
}
