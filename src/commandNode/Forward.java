package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class Forward extends Node implements CommandNode {
	private static double radianConversion = Math.PI/180;
	
	public Forward(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * moves turtle forward in its current heading by pixels distance
	 * 
	 * @return the value of pixels
	 */
	public double evaluate(List<Node> arguments) 
	{
		double xCor = turtle.getXCoordinate() + arguments.get(0).getValue()*Math.cos(turtle.getDirectionAngle()*radianConversion);
		double yCor = turtle.getYCoordinate() - arguments.get(0).getValue()*Math.sin(turtle.getDirectionAngle()*radianConversion);
		turtle.setCoordinates(xCor,yCor);
		value = arguments.get(0).getValue();
		return value;
	}


}
