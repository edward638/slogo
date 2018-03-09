package nodes;

import Tree.TreeEvaluator;
import Tree.TreeMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UnlimitedCommand implements HeadInterface, NodeInterface {
    private NodeInterface command;
    private Stack children;
    private double value;
    private int numChildren;
    TreeEvaluator te;

    public UnlimitedCommand(NodeInterface command, int numChildren) {
        this.command = command;
        this.numChildren = numChildren;
        children = new Stack();
        value = 0.0;
        te = new TreeEvaluator();
    }

    @Override
    public double evaluate(List<NodeInterface> args) {
        int childrenTracker = 0;
        while (!children.empty()) {
            ArrayList<NodeInterface> nodes = new ArrayList<>();
            nodes.add(command);
            while (!children.empty() && childrenTracker<numChildren) {
                if (children.peek() instanceof Constant) { childrenTracker++; }
                nodes.add((NodeInterface) children.pop());
            }
            childrenTracker = 0;
            TreeMaker tm = new TreeMaker(nodes);
            value += te.evaluate(tm.getHeads());
        }
        return value;
    }

    @Override
    public void add(NodeInterface n) {
        children.add(n);
    }

    @Override
    public double getValue() {
        return value;
    }
}
