package commandNode;

import java.util.ArrayList;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class ArcTangent extends Node implements CommandNode{

	public ArcTangent(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * return arctangent of degrees
	 * 
	 * @return arctan(degrees)
	 */
	public double evalute(ArrayList<Double> arguments) 
	{
		double arctan = Math.atan(arguments.get(0));
		value = arctan;
		return value;
	}

}
