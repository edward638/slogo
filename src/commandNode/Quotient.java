package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Quotient extends Node implements CommandNode {

	public Quotient(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns quotient of the values of expr1 and expr2
	 * 
	 * @return expr1/expr2
	 */
	public double evaluate(List<Double> arguments) {
		if(arguments.get(1) != 0)
		{
			double quot = arguments.get(0)/arguments.get(1);
			value = quot;
			return value;
		}
		else
		{
			//throw error
		}
		return 0;
	}

}
