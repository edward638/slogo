package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class GreaterThan extends Node implements CommandNode{

	public GreaterThan(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if the value of expr1 is strictly greater than the value of expr2, otherwise 0
	 * 
	 * @return is expr1 > expr2
	 */
	public double evalute(ArrayList<Double> arguments) {
		if(arguments.get(0) > arguments.get(1))
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
