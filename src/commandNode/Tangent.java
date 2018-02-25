package commandNode;

import java.util.List;

import nodes.Node;
import parsers.Turtle;

public class Tangent extends Node {

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
	public double evaluate(List<Double> arguments) {
		double tan = Math.tan(arguments.get(0));
		value = tan;
		return value;
	}
	

}
