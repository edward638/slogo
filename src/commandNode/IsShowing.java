package commandNode;

import java.util.ArrayList;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class IsShowing extends Node implements CommandNode {

	public IsShowing(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if turtle is showing, 0 if it is hiding
	 * 
	 * @return turtle's visibility status
	 */
	public double evalute(ArrayList<Double> arguments) {
		if(turtle.getTurtleShowing())
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
