package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class NaturalLog extends Node implements CommandNode {

	public NaturalLog(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns natural log of expr
	 * 
	 * @return ln(expr)
	 */
	public double evaluate(List<Double> arguments) {
		value = Math.log(arguments.get(0));
		return value;
	}

}
