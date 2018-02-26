package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class SetTowards extends Node implements CommandNode
{

	public SetTowards(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle to face the point (x, y), where (0, 0) is the center of the screen
	 * 
	 * @return the number of degrees turtle turned
	 */
	public double evaluate(List<Node> arguments) {
		double deg = Math.atan(arguments.get(0).getValue()/arguments.get(1).getValue());
		double change = Math.abs(turtle.getDirectionAngle() - deg);
		turtle.setDirectionAngle(deg);
		value = change;
		return value;
	}


}
