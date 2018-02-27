package nodes;

import java.util.ArrayList;
import java.util.List;

import Tree.TreeEvaluator;
import Tree.TreeMaker;

public class Liste extends Node {
    private ArrayList<Node> elements;

    public Liste () {
        super(null, 0);
        elements = new ArrayList<Node>();
    }

    public void add (Node n) {
        elements.add(n);
    }

    public Node getElement (int index) {
        return elements.get(index);
    }

    public double evaluate(List<Node> args) {
        TreeMaker tm = new TreeMaker(elements);
        ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
        TreeEvaluator te = new TreeEvaluator();
        value = te.evaluate(heads);
        return value;
    }
}