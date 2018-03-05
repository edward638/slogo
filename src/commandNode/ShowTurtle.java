package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class ShowTurtle extends GeneralCommand implements CommandInterface {

	public ShowTurtle(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * makes turtle visible
	 * 
	 * @return 1
	 */
	public double evaluate(List<NodeInterface> arguments) {
		turtle.setTurtleShowing(true);
		value = 1;
		return value;
	}

}
