package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Sine extends Node implements CommandNode {

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
	public double evaluate(List<Double> arguments) {
		double sin = Math.sin(arguments.get(0));
		value = sin;
		return value;
	}


}
