package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class Sum extends GenCommand implements CommandNode
{

	public Sum(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns sum of the values of expr1 and expr2
	 * 
	 * @return expr1 + expr2
	 */
	public double evaluate(List<NodeI> arguments) {
		double sum = arguments.get(0).getValue() + arguments.get(1).getValue();
		value = sum;
		return value;
	}
	

}
