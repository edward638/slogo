package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class SetTowards extends Node implements CommandNode
{
	private double degreeConversion = 180/Math.PI;
			
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
		double rad = Math.atan(arguments.get(1).getValue()/arguments.get(0).getValue());
		double deg = rad * degreeConversion; 
		if(arguments.get(0).getValue() < 0)
		{
			deg = 180 + deg;
		}
		double change = Math.abs(turtle.getDirectionAngle() - deg);
		turtle.setDirectionAngle(deg);
		value = change;
		return value;
	}


}
