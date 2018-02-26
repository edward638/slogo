package commandNode;
import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class IsPenDown extends Node implements CommandNode {

	public IsPenDown(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if turtle's pen is down, 0 if it is up
	 * 
	 * @return turtle's pen status
	 */
	public double evaluate(List<Double> arguments) {
		if(turtle.getPenShowing())
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
