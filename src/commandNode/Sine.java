package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class Sine extends GenCommand implements CommandNode {

	public Sine(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns sine of degrees
	 * 
	 * @return sin(degrees)
	 */
	public double evaluate(List<NodeI> arguments) {
		double sin = Math.sin(arguments.get(0).getValue());
		value = sin;
		return value;
	}


}
