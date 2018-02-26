package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class HideTurtle extends Node implements CommandNode {

	public HideTurtle(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * makes turtle invisible
	 * 
	 * @return 0
	 */
	public double evaluate(List<Node> arguments) {
		turtle.setTurtleShowing(false);
		value = 0;
		return value;
	}
}
