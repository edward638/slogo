package commandNode;

import java.util.List;


import nodes.Node;
import parsers.Turtle;

public class Random extends Node {

	public Random(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns random non-negative number strictly less than max
	 * 
	 * @return num between 0 and max
	 */
	public double evaluate(List<Double> arguments) {
		value = Math.floor(Math.random() * arguments.get(0));
		return value;
	}


}
