package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

/**
 * @author Belanie Nagiel
 * 
 * Minus class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Minus extends Node implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Minus(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * returns negative of the values of expr
	 * 
	 * @return -expr
	 */
	public double evaluate(List<Node> arguments) {
		value = -1*arguments.get(0).getValue();
		return value;
	}



}
