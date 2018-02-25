package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class NotEqual extends Node implements CommandNode{

	public NotEqual(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if the value of expr1 and the value of expr2 are not equal, otherwise 0
	 * 
	 * @returns expr1 != expr2
	 */
	public double evalute(ArrayList<Double> arguments) {
		if(arguments.get(0) != arguments.get(1))
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
