package commandNode;


import java.util.List;

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
	public double evaluate(List<Node> arguments) 
	{
		double arctan = Math.atan(arguments.get(0).getValue());
		value = arctan;
		return value;
	}

}
