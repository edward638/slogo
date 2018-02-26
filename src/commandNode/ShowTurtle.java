package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class ShowTurtle extends Node implements CommandNode {

	public ShowTurtle(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * makes turtle visible
	 * 
	 * @return 1
	 */
	public double evaluate(List<Double> arguments) {
		turtle.setTurtleShowing(true);
		value = 1;
		return value;
	}

}
