package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class Random extends GeneralCommand implements CommandInterface {

	public Random(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns random non-negative number strictly less than max
	 * 
	 * @return num between 0 and max
	 */
	public double evaluate(List<NodeInterface> arguments) {
		value = Math.floor(Math.random() * arguments.get(0).getValue());
		return value;
	}


}
