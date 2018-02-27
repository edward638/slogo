package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class DoTimes extends Node implements CommandNode{

	public DoTimes(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * runs command(s) for each value specified in the range, i.e., from (1 - limit) inclusive 
	 * returns the value of the final command executed (or 0 if no commands are executed)
	 * note, variable is assigned to each succeeding value so that it can be accessed by the command(s)
	 * 
	 * @return value of the final command executed
	 */
	public double evaluate(List<Node> args) {
		
	}

}
