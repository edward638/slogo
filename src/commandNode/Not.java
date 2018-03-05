package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

/**
 * @author Belanie Nagiel
 * 
 * Not class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Not extends GenCommand implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Not(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if test is 0 and 0 if test is non-zero
	 * 
	 * @return is the argument 0
	 */
	public double evaluate(List<NodeI> arguments) {
		if(arguments.get(0).getValue() == 0)
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
