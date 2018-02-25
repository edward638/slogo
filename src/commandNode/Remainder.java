package commandNode;

import java.util.List;

import nodes.Node;
import parsers.Turtle;

public class Remainder extends Node {

	public Remainder(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns remainder on dividing the values of expr1 by expr2
	 * 
	 * @return expr1 % expr2
	 */
	public double evaluate(List<Double> arguments) {
		double remainder = arguments.get(0) % arguments.get(1);
		value = remainder;
		return value;
	}

}
