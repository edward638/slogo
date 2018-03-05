package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

/**
 * @author Belanie Nagiel
 * 
 * Forward class that creates a new extension of Node and sets the functionality for the evaluate method implemented from
 * the CommandNode interface.
 *
 */
public class Forward extends GenCommand implements CommandNode {
	private static double radianConversion = Math.PI/180;
	
	/**
	 * Class Constructor
	 * 
	 * @param turt
	 * @param numChildren
	 */
	public Forward(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * moves turtle forward in its current heading by pixels distance
	 * 
	 * @return the value of pixels
	 */
	public double evaluate(List<NodeI> arguments)
	{
		double xCor = turtle.getXCoordinate() + arguments.get(0).getValue()*Math.cos(turtle.getDirectionAngle()*radianConversion);
		double yCor = turtle.getYCoordinate() - arguments.get(0).getValue()*Math.sin(turtle.getDirectionAngle()*radianConversion);
		turtle.setCoordinates(xCor,yCor);
		value = arguments.get(0).getValue();
		//System.out.println(value);
		return value;
	}


}
