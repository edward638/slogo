package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

/**
 * @author Belanie Nagiel
 * 
 * PenDown class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class PenDown extends GenCommand implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public PenDown(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * puts pen down such that when the turtle moves, it leaves a trail
	 * 
	 * @return 1
	 */
	public double evaluate(List<NodeI> arguments)
	{
		turtle.setPenShowing(true);
		value = 1;
		return value;
	}
}
