package commandNode;

import java.util.List;

import nodes.Node;
import parsers.Turtle;

public class SetHeading extends Node{

	public SetHeading(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle to an absolute heading
	 * 
	 * @return number of degrees moved
	 */
	public double evaluate(List<Double> arguments) {
		double deg = Math.abs(turtle.getDirectionAngle() - arguments.get(0));
		turtle.setDirectionAngle(arguments.get(0));
		value = deg;
		return deg;
	}


}
