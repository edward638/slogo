package commandNode;

import model.Turtle;
import nodes.GenCommand;
import nodes.NodeI;
import nodes.CommandNode;
import nodes.Liste;

import java.util.List;

/**
 * Implements REPEAT as describe on the course website
 */

public class Repeat extends GenCommand implements CommandNode {

    public Repeat (Turtle turt, int numChildren) {
        super(turt, numChildren);
    }

    @Override
    public double evaluate(List<NodeI> args) {
        double d = args.get(0).getValue();
        for (int i = 0; i < d; i++) {
            Liste l = (Liste) args.get(1);
            value = l.evaluate();
        }
        return value;
    }
}
