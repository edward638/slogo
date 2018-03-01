package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

/**
 * @author Belanie Nagiel
 * 
 * If class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class If extends Node implements CommandNode{

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public If(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * if expr is not 0, runs the command(s) given in the list
	 * returns the value of the final command executed (or 0 if no commands are executed)
	 * 
	 * @return value of final command executed
	 */
	public double evaluate(List<Node> args) {
		value = 0;
		if(args.get(0).getValue() != 0)
		{
			value = args.get(1).evaluate(null);
		}
		return value;
	}

}
