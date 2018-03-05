package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class Pi extends GenCommand implements CommandNode {

	public Pi(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * reports the number Pi
	 * 
	 * @return Pi
	 */
	public double evaluate(List<NodeI> arguments) {
		value = Math.PI;
		return value;
	}

}
