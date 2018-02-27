package commandNode;

import model.Turtle;
import nodes.Node;
import nodes.CommandNode;

import java.util.List;

public class Repeat extends Node implements CommandNode {

    public Repeat (Turtle turt, int numChildren) {
        super(turt, numChildren);
    }

    @Override
    public double evaluate(List<Node> args) {
        double d = args.get(0).getValue();
        for (int i = 0; i < d; i++) {
            value = args.get(1).evaluate(null);
        }
        return value;
    }
}
