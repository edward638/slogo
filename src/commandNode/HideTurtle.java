package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class HideTurtle extends Node implements CommandNode{

	public HideTurtle(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * makes turtle invisible
	 * 
	 * @return 0
	 */
	public double evalute(ArrayList<Double> arguments) {
		turtle.setTurtleShowing(false);
		return 0;
	}

}
