package commandNode;

import java.util.ArrayList;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

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
		value = 0;
		return 0;
	}

}
