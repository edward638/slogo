package nodes;

import java.util.ArrayList;

import Tree.TreeMaker;

public class List extends Node {
    private ArrayList<Node> children;
    private TreeMaker tm;
    private int current;

    public List () {
        super(null, 0);
        children = new ArrayList<Node>();
        current = 0;
    }

    @Override
    public void addChild (Node n) {
        children.add(n);
    }

}
