package commandNode;

import java.util.List;

import model.Turtle;
import nodes.*;

/**
 * Implements FOR as described on the course site
 */

public class For extends Node implements CommandNode {

	public For(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<Node> args) {
		Liste l = (Liste) args.get(0);

		Variable v = (Variable) l.getElement(0);
		Constant start = (Constant) l.getElement(1);
		Constant end = (Constant) l.getElement(2);
		Constant increment = (Constant) l.getElement(3);

		Liste commands = (Liste) args.get(1);

		for (double i = start.getValue(); i <= end.getValue(); i+=increment.getValue()) {
			v.setNewValue(i); //update the variable
			value = commands.evaluate(null);
		}

		return value;
	}

}
