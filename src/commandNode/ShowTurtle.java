package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class ShowTurtle extends GenCommand implements CommandNode {

	public ShowTurtle(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * makes turtle visible
	 * 
	 * @return 1
	 */
	public double evaluate(List<NodeI> arguments) {
		turtle.setTurtleShowing(true);
		value = 1;
		return value;
	}

}
