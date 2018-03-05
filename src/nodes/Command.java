package nodes;

import java.util.ArrayList;

import model.VariableHistory;

import java.util.List;

/**
 * This is the command class which represent a custom command, allowing it to be called
 * in the future
 *
 * author: Charles Dracos
 */
public class Command extends VariableI implements HeadI, CommandNode, NodeI {
    private static final int MAX_CHILDREN = 2;

    private ArrayList<Liste> lists;
    private double value;
    private int current = 0;
    /**
     * Creates a new Command node
     *
     * @param name name of the custom command
     * @param VH the variable history to track all custom commands
     */
    public Command(String name, VariableHistory VH) {
        super(name, VH);
        lists = new ArrayList<>();
        value = 0.0;
    }

    public double getValue() {
        return value; //returns the value of evaluate the commands
    }

    @Override
    public boolean hasNext() {
        return current<MAX_CHILDREN; //should say if it has another list
    }

    @Override
    public NodeI getNext() {
        Liste ret = lists.get(current);
        current++;
        return ret;
    }

    @Override
    public void add(NodeI n) {
        try {
            Liste l = (Liste) n;
            lists.add(l);
            current++;
        }
        catch (Exception e) {
            throw new ImproperNodeException();
        }
    }

    @Override
    public double evaluate(List<NodeI> args) {
        Liste commands = lists.get(1);
        commands.evaluate();
        value = commands.getValue();
        return value;
    }

    @Override
    public void reset() {
        current = 0;
    }
}
