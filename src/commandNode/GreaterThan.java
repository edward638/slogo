package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class GreaterThan extends GeneralCommand implements CommandInterface {

	public GreaterThan(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if the value of expr1 is strictly greater than the value of expr2, otherwise 0
	 * 
	 * @return is expr1 > expr2
	 */
	public double evaluate(List<NodeInterface> arguments) {
		if(arguments.get(0).getValue() > arguments.get(1).getValue())
		{
			value = 1;
			return value;
		}
		else
		{
			value = 0;
			return value;
		}
	}

}
