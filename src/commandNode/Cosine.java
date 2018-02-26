package commandNode;

import java.util.List;

import model.Turtle;
import nodes.Node;

public class Cosine extends Node{

	public Cosine(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * return cosine of degrees
	 * 
	 * @return cos(degrees)
	 */
	public double evaluate(List<Double> arguments) {
		double cos = Math.cos(arguments.get(0));
		value = cos;
		return value;
	}

}
