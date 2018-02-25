package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Tangent extends Node implements CommandNode {

	public Tangent(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 *return tangent of degrees
	 * 
	 * @return tan(degrees)
	 */
	public double evalute(ArrayList<Double> arguments) {
		double tan = Math.tan(arguments.get(0));
		value = tan;
		return value;
	}
	

}
