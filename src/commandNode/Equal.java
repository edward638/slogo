package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

/**
 * @author Belanie Nagiel
 * 
 * Equal class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Equal extends Node implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Equal(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if the value of expr1 and the value of expr2 are equal, otherwise 0
	 * 
	 * @return expr1 == expr2
	 */
	public double evaluate(List<Node> arguments) {
		if(arguments.get(0).getValue() == arguments.get(1).getValue())
		{
			value = 1;
			return value;
		}
		else
		{
			value = 0;
			return value;
		}
	}


}
