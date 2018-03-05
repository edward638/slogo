package commandNode;

import java.util.List;

import model.Turtle;
import nodes.*;

public class MakeUserInstruction extends GenCommand implements CommandNode {

	public MakeUserInstruction(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<NodeI> args) {
		Command c = (Command) args.get(0);
		c.add (args.get(1));
		c.add (args.get(2));
		c.getVH().add(c);
		return 1;
	}

}
