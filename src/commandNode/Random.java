package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Random extends Node implements CommandNode{

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
	public double evalute(ArrayList<Double> arguments) {
		value = Math.floor(Math.random() * arguments.get(0));
		return value;
	}


}
