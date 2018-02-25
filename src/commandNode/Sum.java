package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Sum extends Node implements CommandNode
{

	public Sum(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns sum of the values of expr1 and expr2
	 * 
	 * @return expr1 + expr2
	 */
	public double evalute(ArrayList<Double> arguments) {
		double sum = arguments.get(0) + arguments.get(1);
		value = sum;
		return value;
	}
	

}
