package commandNode;

import model.Turtle;
import java.util.List;

import nodes.CommandNode;
import nodes.Node;
/**
 * @author Belanie Nagiel
 * 
 * And class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class And extends Node implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public And(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if test1 and test2 are non-zero, otherwise 0
	 * 
	 * @return are the two arguments non-zero
	 */
	public double evaluate(List<Node> arguments) {
		if(arguments.get(0).getValue() != 0 && arguments.get(1).getValue() != 0)
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
