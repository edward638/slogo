package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Or extends Node implements CommandNode{

	public Or(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if test1 or test2 are non-zero, otherwise 0
	 * 
	 * @return is one of the arguments non-zero
	 */
	public double evalute(ArrayList<Double> arguments) {
		if(arguments.get(0) != 0 || arguments.get(1) != 0)
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
