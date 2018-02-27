package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class For extends Node implements CommandNode {

	public For(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<Node> args) {
		// TODO Auto-generated method stub
		return 0;
	}

}
