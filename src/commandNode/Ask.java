package commandNode;

import nodes.GeneralCommand;

import model.Model;
import model.Turtle;

import nodes.NodeInterface;
import nodes.ListNode;

import java.util.List;
import java.util.ArrayList;

/**
 * Implements the Ask command as described on the course website. It uses a temp list of turtles which it
 * acts upon gives a list of commands and then resets the turtle list to what it was before the call.
 *
 * author: Charlie Dracos
 */
public class Ask extends GeneralCommand {

    public Ask (Model m, int numChildren) {
        super (m, numChildren); //generic GeneralCommand constructor
    }

    /**
     * This evaluates the arguments given to it, which are a list of turtles and a list of commands.
     * It uses the list of turtles to act upon and the command which it will use.
     * @param args List of turtles, list of commands
     * @return Value of command executed by command on last turtle
     */
    @Override
    public double evaluate(List<NodeInterface> args) {
        ListNode turtles = (ListNode) args.get(0);
        ListNode commands = (ListNode) args.get(1);
        List<Turtle> tempActive = new ArrayList<>();
        List<Turtle> oldActive = model.getActiveTurtles(); //stores previous active turtles
        int i = 0;
        while (turtles.getElement(i) != null ) {
            NodeInterface node = turtles.getElement(i);
            value = node.getValue(); //gets the ID of the turtle
            if (model.getAllTurtles().containsKey(value)) {
                Turtle newActive = model.getAllTurtles().get(value);
                tempActive.add(newActive); //adds to tempActive
            }
            else { model.addTurtle(value); }
            i++;
        }
        model.setActiveTurtles(tempActive);
        model.update(t -> command(commands));
        model.setActiveTurtles(oldActive);
        return value;
    }

    public void command (ListNode commands) {
        value = commands.evaluate();
    }
}
