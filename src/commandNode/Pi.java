package commandNode;

import java.util.ArrayList;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

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
