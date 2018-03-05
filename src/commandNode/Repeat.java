package commandNode;

import model.Turtle;
import nodes.*;

import java.util.List;

/**
 * Implements REPEAT as describe on the course website
 */

public class Repeat extends GeneralCommand implements CommandInterface {

    public Repeat (Turtle turt, int numChildren) {
        super(turt, numChildren);
    }

    @Override
    public double evaluate(List<NodeInterface> args) {
        try {
            double d = args.get(0).getValue();
            for (int i = 0; i < d; i++) {
                ListNode l = (ListNode) args.get(1);
                value = l.evaluate();
            }
            return value;
        }
        catch (ClassCastException e) {
            throw new ImproperNodeException();
        }
    }
}
