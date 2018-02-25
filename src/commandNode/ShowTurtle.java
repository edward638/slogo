package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class ShowTurtle extends Node implements CommandNode{

	public ShowTurtle(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * makes turtle visible
	 * 
	 * @return 1
	 */
	public double evalute(ArrayList<Double> arguments) {
		turtle.setTurtleShowing(true);
		value = 1;
		return 1;
	}

}
