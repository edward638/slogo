package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class SetPosition extends GeneralCommand implements CommandInterface {

	public SetPosition(Model model, int numChildren) {
		super(model, numChildren);
	}

	@Override
	/**
	 * moves turtle to an absolute screen position, where (0, 0) is the center of the screen
	 * 
	 * @return the distance the turtle moved
	 */
	public double evaluate(List<NodeInterface> arguments)
	{
		double distance = 0;
		for (Turtle turtle: model.getActiveTurtles())
		{
			distance = Math.sqrt(Math.pow(arguments.get(0).getValue() + turtle.getHome()[0] - 
					turtle.getXCoordinate(), 2) + Math.pow(arguments.get(1).getValue() + turtle.getHome()[1] - 
							turtle.getYCoordinate(), 2) );
			turtle.setCoordinates(arguments.get(0).getValue() + turtle.getHome()[0], (-1 * arguments.get(1).getValue()) + turtle.getHome()[1]);
		}
		value = distance;
		return value;
	}


}
