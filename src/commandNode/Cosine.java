package commandNode;

import java.util.ArrayList;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Cosine extends Node implements CommandNode{

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
	public double evalute(ArrayList<Double> arguments) {
		double cos = Math.cos(arguments.get(0));
		value = cos;
		return value;
	}

}
