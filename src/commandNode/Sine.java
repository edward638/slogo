package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class Sine extends GeneralCommand implements CommandInterface {

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
	public double evaluate(List<NodeInterface> arguments) {
		double sin = Math.sin(arguments.get(0).getValue());
		value = sin;
		return value;
	}


}
