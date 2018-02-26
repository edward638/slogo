package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Cosine extends Node implements CommandNode {

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
	public double evaluate(List<Node> arguments) {
		double cos = Math.cos(arguments.get(0).getValue());
		value = cos;
		return value;
	}

}
