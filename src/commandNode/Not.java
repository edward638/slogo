package commandNode;

import java.util.List;

import model.Turtle;
import nodes.Node;

public class Not extends Node{

	public Not(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * returns 1 if test is 0 and 0 if test is non-zero
	 * 
	 * @return is the argument 0
	 */
	public double evaluate(List<Double> arguments) {
		if(arguments.get(0) == 0)
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
