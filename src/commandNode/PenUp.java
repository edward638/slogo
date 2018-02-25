package commandNode;

import java.util.ArrayList;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class PenUp extends Node implements CommandNode{

	public PenUp(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * puts pen up such that when the turtle moves, it does not leaves a trail
	 * 
	 * @return 0
	 */
	public double evalute(ArrayList<Double> arguments) 
	{
		turtle.setPenShowing(false);
		value = 1;
		return 0;
	}

}
