package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

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
	public double evaluate(List<Double> arguments) {
		value = turtle.getDirectionAngle();
		return value;
	}

}
