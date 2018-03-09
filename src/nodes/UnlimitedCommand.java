package nodes;

import Tree.TreeEvaluator;
import Tree.TreeMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This is the class that allows a command to act on multiple inputs. It functions by using its first node which is
 * the one which has multiple children, and then by using a stack creating a tree which reflects this command
 * being executed multiple times. It is a head as it can be implemented by itself, and also per all nodes
 * is a NodeInterface.
 *
 * author: Charlie Dracos
 */
public class UnlimitedCommand implements HeadInterface, NodeInterface {
    private NodeInterface command;
    private Stack children = new Stack();
    private double value = 0.0;
    private int numChildren;
    private TreeEvaluator te = new TreeEvaluator();

    /**
     * Constructor for a command. It needs to know its first command and
     * how many children that command needs.
     * @param command The type of command
     * @param numChildren How many children it has
     */
    public UnlimitedCommand(NodeInterface command, int numChildren) {
        this.command = command;
        this.numChildren = numChildren;
    }

    /**
     * The evaluate method uses a stack to keep track of how many children are left
     * for the command to act upon. It then creates its own list of nodes which is
     * passed to a tree to then bee evaluated like a normal list.
     * @param args Arguments as needed by a HeadInterface for an evaluate
     * @return the cumulative values done by all commands, as it returns the total work done by an UnlimitedCommand
     */
    @Override
    public double evaluate(List<NodeInterface> args) {
        int childrenTracker = 0; //will keep track of how many children have been added
        while (!children.empty()) { //while there are more nodes in the list
            ArrayList<NodeInterface> nodes = new ArrayList<>(); //this will be the list treeMaker uses
            nodes.add(command);
            while (!children.empty() && childrenTracker<numChildren) {
                if (children.peek() instanceof Constant) {
                    childrenTracker++; //updates for when a child node with no children is added
                }
                nodes.add((NodeInterface) children.pop()); //adds children to the node
            }
            childrenTracker = 0; //resets the amount of children
            TreeMaker tm = new TreeMaker(nodes); //creates a new treeMaker on recent stack
            value += te.evaluate(tm.getHeads()); //evaluates and adds to value
        }
        return value;
    }

    /**
     * Adds a new child to the list of children in this node
     * @param n Node to be added
     */
    @Override
    public void add(NodeInterface n) {
        children.add(n);
    }

    @Override
    public double getValue() {
        return value; //returns the value for use by other nodes
    }
}
