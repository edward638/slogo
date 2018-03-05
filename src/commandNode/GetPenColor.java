package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class GetPenColor extends GeneralCommand implements CommandInterface  {

	public GetPenColor(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
	}


	@Override
	/**
	 * returns turtle's current color index
	 * 
	 * @return turtle's current color index
	 */
	public double evaluate(List<NodeInterface> arguments) {
		value = turtle.getPenColorIndex();
		return value;
	}

}
