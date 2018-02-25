package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

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
	public double evalute(ArrayList<Double> arguments) {
		double sin = Math.sin(arguments.get(0));
		value = sin;
		return value;
	}


}
