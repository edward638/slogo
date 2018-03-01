package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

/**
 * @author Belanie Nagiel
 * 
 * Heading class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Heading extends Node implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Heading(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns the turtle's heading in degrees
	 * 
	 * @return turtle's direction angle
	 */
	public double evaluate(List<Node> arguments) {
		value = turtle.getDirectionAngle();
		return value;
	}

}
