package commandNode;

import java.util.List;

import model.Turtle;
import nodes.Node;

public class Minus extends Node{

	public Minus(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns negative of the values of expr
	 * 
	 * @return -expr
	 */
	public double evaluate(List<Double> arguments) {
		value = -1*arguments.get(0);
		return value;
	}



}
