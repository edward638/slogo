package commandNode;

import java.util.List;

import nodes.Node;
import parsers.Turtle;

public class YCoordinate extends Node {

	public YCoordinate(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's Y coordinate from the center of the screen
	 * 
	 * @return turtle's Y
	 */
	public double evaluate(List<Double> arguments) {
		value = turtle.getYCoordinate();
		return value;
	}

}
