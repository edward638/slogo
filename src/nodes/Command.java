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
public class Command extends Node {
    private String name;
    private VariableHistory VH;
    private ArrayList<Liste> lists;
    /**
     * Creates a new Command node
     *
     * @param name name of the custom command
     * @param VH the variable history to track all custom commands
     */
    public Command(String name, VariableHistory VH) {
        super(null, 0);
        this.name = name;
        this.VH = VH;
        lists = new ArrayList<Liste>();
    }

    public String getName() {
        return name; //returns name of the commands
    }

    public VariableHistory getVH() {
        return VH; //returns the VH
    }

    public void addList(Liste l) {
        lists.add(l); //adds a new Liste to the command
    }

    public double getValue() {
        return lists.get(1).evaluate(null); //returns the value of evaluate the commands
    }


    @Override
    public double evaluate(List<Node> args) {
        return lists.get(1).evaluate(null); //returns same as getValue
    }
}
