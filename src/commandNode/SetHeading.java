package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class SetHeading extends Node implements CommandNode{

	public SetHeading(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle to an absolute heading
	 * 
	 * @return number of degrees moved
	 */
	public double evalute(ArrayList<Double> arguments) {
		double deg = Math.abs(turtle.getDirectionAngle() - arguments.get(0));
		turtle.setDirectionAngle(arguments.get(0));
		value = deg;
		return deg;
	}


}
