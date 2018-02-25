package commandNode;

import java.util.ArrayList;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Product extends Node implements CommandNode {

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
	public double evalute(ArrayList<Double> arguments) {
		double prod = arguments.get(0)*arguments.get(1);
		value = prod;
		return value;
	}


}
