package nodes;

import java.util.ArrayList;

import model.Turtle;

public abstract class GenCommand implements HeadI, NodeI {
    protected Turtle turtle;
    private ArrayList<NodeI> children;
    private int numChildren;
    private int current = 0;
    protected double value;

    public GenCommand(Turtle turtle, int numChildren) {
        this.turtle = turtle;
        children = new ArrayList<NodeI>();
        this.numChildren = numChildren;
        value = 0.0;
    }

    public NodeI getNext() {
        NodeI ret = children.get(current);
        current++;
        return ret;
    }

    public boolean hasNext() {
        return current < numChildren;
    }

    public void add(NodeI n) {
        current++;
        children.add(n);
    }

    public void reset() {
        current = 0;
    }

    @Override public double getValue() {
        return value;
    }
}
