package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Remainder extends Node implements CommandNode {

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
	public double evalute(ArrayList<Double> arguments) {
		double remainder = arguments.get(0) % arguments.get(1);
		value = remainder;
		return value;
	}

}
