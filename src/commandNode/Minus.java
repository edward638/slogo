package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

/**
 * @author Belanie Nagiel
 * 
 * Minus class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandInterface interface.
 *
 */
public class Minus extends GeneralCommand implements CommandInterface {

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
	public double evaluate(List<NodeInterface> arguments) {
		value = -1*arguments.get(0).getValue();
		return value;
	}



}
