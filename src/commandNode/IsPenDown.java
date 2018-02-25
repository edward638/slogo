package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class IsPenDown extends Node implements CommandNode{

	public IsPenDown(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if turtle's pen is down, 0 if it is up
	 * 
	 * @return turtle's pen status
	 */
	public double evalute(ArrayList<Double> arguments) {
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
