package commandNode;

import java.util.List;

import model.Turtle;
import nodes.Node;

public class XCoordinate extends Node {

	public XCoordinate(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's X coordinate from the center of the screen
	 * 
	 * @return turtle's x
	 */
	public double evaluate(List<Double> arguments) {
		value = turtle.getXCoordinate();
		return value;
	}

}
