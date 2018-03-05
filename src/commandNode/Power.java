package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class Power extends GeneralCommand implements CommandInterface {

	public Power(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns base raised to the power of the exponent
	 * 
	 * @return base^exponent
	 */
	public double evaluate(List<NodeInterface> arguments) {
		value = Math.pow(arguments.get(0).getValue(), arguments.get(1).getValue());
		return value;
	}



}
