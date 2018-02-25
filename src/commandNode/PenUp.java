package commandNode;

import java.util.List;

import nodes.Node;
import parsers.Turtle;

public class PenUp extends Node{

	public PenUp(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * puts pen up such that when the turtle moves, it does not leaves a trail
	 * 
	 * @return 0
	 */
	public double evaluate(List<Double> arguments) 
	{
		turtle.setPenShowing(false);
		value = 1;
		return 0;
	}
}
