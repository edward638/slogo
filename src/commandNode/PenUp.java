package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class PenUp extends GenCommand implements CommandNode{

	public PenUp(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * puts pen up such that when the turtle moves, it does not leaves a trail
	 * 
	 * @return 0
	 */
	public double evaluate(List<NodeI> arguments)
	{
		turtle.setPenShowing(false);
		value = 0;
		return value;
	}
}
