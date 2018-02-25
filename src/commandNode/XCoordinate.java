package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class XCoordinate extends Node implements CommandNode{

	public XCoordinate(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's X coordinate from the center of the screen
	 * 
	 * @return turtle's x
	 */
	public double evalute(ArrayList<Double> arguments) {
		value = turtle.getXCoordinate();
		return value;
	}

}