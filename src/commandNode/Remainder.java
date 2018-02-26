package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Remainder extends Node implements CommandNode {

	public Remainder(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns remainder on dividing the values of expr1 by expr2
	 * 
	 * @return expr1 % expr2
	 */
	public double evaluate(List<Node> arguments) {
		double remainder = arguments.get(0).getValue() % arguments.get(1).getValue();
		value = remainder;
		return value;
	}

}
