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
public class Liste extends Node {
    private ArrayList<Node> elements;

    /**
     * Liste has no parameters in its constructor as it has no children to be reached by
     * the treeMaker/evaluator and does not need to directly call the turtle.
     */
    public Liste () {
        super(null, 0);
        elements = new ArrayList<Node>();
    }

    /**
     * Add a node to the array of elements in the list
     * @param n node being added
     */
    public void add (Node n) {
        elements.add(n);
    }

    public Node getElement (int index) {
        return elements.get(index); //returns element at a specific index
    }

    /**
     * Overrides the Node getChild to give a do nothing node
     * @return constant node of value zero
     */
    @Override
    public Node getChild() {
        return new Constant(0);
    }

    /**
     * Evaluates commands in the list
     * @param args mandatory parameter from superclass that is null
     * @return the value given by the last command executed
     */
    public double evaluate(List<Node> args) {
        //TODO: FIX THIS!!!!!!
        /*
        TreeMaker tm = new TreeMaker(elements);
        ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
        TreeEvaluator te = new TreeEvaluator();
        value = te.evaluate(heads);
        return value;
        */
        return 0;
    }
}