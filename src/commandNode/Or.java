package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

/**
 * @author Belanie Nagiel
 * 
 * Or class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Or extends GenCommand implements CommandNode {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Or(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if test1 or test2 are non-zero, otherwise 0
	 * 
	 * @return is one of the arguments non-zero
	 */
	public double evaluate(List<NodeI> arguments) {
		if(arguments.get(0).getValue() != 0 || arguments.get(1).getValue() != 0)
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
