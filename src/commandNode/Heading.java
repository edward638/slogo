package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Heading extends Node implements CommandNode {

	public Heading(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's heading in degrees
	 * 
	 * @return turtle's direction angle
	 */
	public double evalute(ArrayList<Double> arguments) {
		value = turtle.getDirectionAngle();
		return value;
	}

}
