package commandNode;

import java.util.List;


import nodes.Node;
import parsers.Turtle;

public class Product extends Node {

	public Product(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns product of the values of expr1 and expr2
	 * 
	 * @return expr1 * expr2
	 */
	public double evaluate(List<Double> arguments) {
		double prod = arguments.get(0)*arguments.get(1);
		value = prod;
		return value;
	}


}
