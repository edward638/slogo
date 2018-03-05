package commandNode;
import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

/**
 * @author Belanie Nagiel
 * 
 * IsPenDown class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandInterface interface.
 *
 */
public class IsPenDown extends GeneralCommand implements CommandInterface {

	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public IsPenDown(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if turtle's pen is down, 0 if it is up
	 * 
	 * @return turtle's pen status
	 */
	public double evaluate(List<NodeInterface> arguments) {
		if(turtle.getPenShowing())
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
