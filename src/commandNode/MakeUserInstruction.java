package commandNode;

import java.util.List;

import model.Turtle;
import nodes.*;

public class MakeUserInstruction extends GeneralCommand implements CommandInterface {

	public MakeUserInstruction(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<NodeInterface> args) {
		try {
			CustomCommand c = (CustomCommand) args.get(0);
			c.add (args.get(1));
			c.add (args.get(2));
			c.getVH().add(c);
			return 1;
		}
		catch (Exception e) {
			return 0;
		}
	}

}
