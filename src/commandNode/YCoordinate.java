package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class YCoordinate extends Node implements CommandNode{

	public YCoordinate(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's Y coordinate from the center of the screen
	 * 
	 * @return turtle's Y
	 */
	public double evalute(ArrayList<Double> arguments) {
		value = turtle.getYCoordinate();
		return value;
	}

}