package commandNode;

import java.util.List;

import model.Turtle;
import nodes.*;

/**
 * Implements FOR as described on the course site
 */

public class For extends GeneralCommand implements CommandInterface {

	public For(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<NodeInterface> args) {
		try {
			ListNode l = (ListNode) args.get(0);
			Variable v = (Variable) l.getElement(0);
			Constant start = (Constant) l.getElement(1);
			Constant end = (Constant) l.getElement(2);
			Constant increment = (Constant) l.getElement(3);

			ListNode commands = (ListNode) args.get(1);

			for (double i = start.getValue(); i <= end.getValue(); i+=increment.getValue()) {
				v.setNewValue(i); //update the variable
				value = commands.evaluate();
			}

			return value;
		}
		catch (ClassCastException e) {
			throw new ImproperNodeException();
		}
	}

}
