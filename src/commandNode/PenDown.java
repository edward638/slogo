package commandNode;

import java.util.ArrayList;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class PenDown extends Node implements CommandNode{

	public PenDown(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * puts pen down such that when the turtle moves, it leaves a trail
	 * 
	 * @return 1
	 */
	public double evalute(ArrayList<Double> arguments) 
	{
		turtle.setPenShowing(true);
		value = 1;
		return 1;
	}
}
