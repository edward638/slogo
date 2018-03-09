package commandNode;

import model.Model;
import model.Turtle;
import nodes.GeneralCommand;
import nodes.NodeInterface;
import nodes.ListNode;

import java.util.List;

/**
 * This is the class tell which implements the tell command as told by the course website.
 *
 * author: Charlie Dracos
 */
public class Tell extends GeneralCommand {

    public Tell(Model model, int numChildren) {
        super(model, numChildren); //normal command constructor
    }

    /**
     * Evaluate sets all the turtles in the first list to active, and adds a new turtle
     * if no turtle with that ID is seen
     * @param args List of turtle ID's
     * @return Value of the last turtle ID
     */
    @Override
    public double evaluate(List<NodeInterface> args) {
        ListNode turtles = (ListNode) args.get(0);
        int i = 0;
        model.getActiveTurtles().removeAll(model.getActiveTurtles()); //clears current active turtles
        while (turtles.getElement(i)!=null) {
            NodeInterface node = turtles.getElement(i);
            value = node.getValue(); //gets the ID of the turtle
            if (model.getAllTurtles().containsKey(value)) { //if the turtle with the ID already exists
                Turtle t = model.getAllTurtles().get(value);  //get the turtle
                if (!model.getActiveTurtles().contains(t)) {
                    model.addActiveTurtle(t); //and add to the active turtle list if not already in it
                }
            }
            else {
                model.addTurtle(value);  //make a new turtle if no turtle with the current ID
            }
            i++;
        }
        return value;
    }
}
