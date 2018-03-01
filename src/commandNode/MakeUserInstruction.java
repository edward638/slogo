package commandNode;

import java.util.List;

import model.Turtle;
import nodes.*;

public class MakeUserInstruction extends Node implements CommandNode {

	public MakeUserInstruction(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<Node> args) {
		Command c = (Command) args.get(0);
		c.addList((Liste) args.get(1));
		c.addList((Liste) args.get(2));
		c.getVH().add(c);
		return c.evaluate(null);
	}

}
