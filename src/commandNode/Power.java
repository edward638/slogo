package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Power extends Node implements CommandNode{

	public Power(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns base raised to the power of the exponent
	 * 
	 * @return base^exponent
	 */
	public double evalute(ArrayList<Double> arguments) {
		value = Math.pow(arguments.get(0), arguments.get(1));
		return value;
	}



}
