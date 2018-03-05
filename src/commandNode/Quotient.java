package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;
import parsers.InvalidEntryException;

public class Quotient extends GeneralCommand implements CommandInterface {

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
	public double evaluate(List<NodeInterface> arguments) {
		if(arguments.get(1).getValue() != 0)
		{
			double quot = arguments.get(0).getValue()/arguments.get(1).getValue();
			value = quot;
			return value;
		}
		else
		{
			throw new InvalidEntryException("Error: Cannot divide by zero");
		}
	}

}
