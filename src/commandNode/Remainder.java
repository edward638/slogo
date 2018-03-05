package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class Remainder extends GeneralCommand implements CommandInterface {

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
	public double evaluate(List<NodeInterface> arguments) {
		double remainder = arguments.get(0).getValue() % arguments.get(1).getValue();
		value = remainder;
		return value;
	}

}
