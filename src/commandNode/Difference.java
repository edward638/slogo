package commandNode;

import java.util.List;

import model.Turtle;
import nodes.Node;

public class Difference extends Node{

	public Difference(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns difference of the values of expr1 and expr2
	 * 
	 * @return expr1 - expr2
	 */
	public double evaluate(List<Double> arguments) {
		double diff = arguments.get(0) - arguments.get(1);
		value = diff;
		return value;
	}
}
