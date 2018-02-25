package commandNode;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class Pi extends Node implements CommandNode{

	public Pi(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * reports the number Pi
	 * 
	 * @return Pi
	 */
	public double evalute(ArrayList<Double> arguments) {
		value = Math.PI;
		return value;
	}

}
