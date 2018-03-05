package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class PenUp extends GeneralCommand implements CommandInterface {

	public PenUp(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * puts pen up such that when the turtle moves, it does not leaves a trail
	 * 
	 * @return 0
	 */
	public double evaluate(List<NodeInterface> arguments)
	{
		turtle.setPenShowing(false);
		value = 0;
		return value;
	}
}
