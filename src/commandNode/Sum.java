package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class Sum extends GeneralCommand implements CommandInterface
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
	public double evaluate(List<NodeInterface> arguments) {
		double sum = arguments.get(0).getValue() + arguments.get(1).getValue();
		value = sum;
		return value;
	}
	

}
