package nodes;

import java.util.ArrayList;
import java.util.List;

import Tree.TreeEvaluator;
import Tree.TreeMaker;

/**
 *  This is the List class. A list stores an array of other types of
 *  nodes and allows methods to call to the list evaluate to execute
 *  commands if it is a list of commands or get the variable elements
 *  if it is a list of variables.
 *
 *  author: Charles Dracos
 */
public class Liste implements NodeI {
    private ArrayList<NodeI> elements;
    private double value;

    /**
     * Liste has no parameters in its constructor as it has no children to be reached by
     * the treeMaker/evaluator and does not need to directly call the turtle.
     */
    public Liste () {
        elements = new ArrayList<NodeI>();
        value = 0.0;
    }

    public NodeI getElement (int index) {
        return elements.get(index);
    }

    public void add(NodeI n) {
        elements.add(n);
    }

    public double evaluate() {
        TreeMaker tm = new TreeMaker(elements);
        ArrayList<HeadI> heads = (ArrayList<HeadI>) tm.getHeads();
        TreeEvaluator te = new TreeEvaluator();
        value = te.evaluate(heads);
        return value;
    }

    @Override
    public double getValue() {
        return value;
    }
}