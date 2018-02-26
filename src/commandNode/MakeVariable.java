package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class MakeVariable extends Node implements CommandNode{

	public MakeVariable(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<Double> args) {
		Node history = args.get(0);
		
		
	}

}
