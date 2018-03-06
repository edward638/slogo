package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class SetHeading extends GeneralCommand implements CommandInterface {

	public SetHeading(Model model, int numChildren) {
		super(model, numChildren);
	}

	@Override
	/**
	 * turns turtle to an absolute heading
	 * 
	 * @return number of degrees moved
	 */
	public double evaluate(List<NodeInterface> arguments) {
		double deg = 0;
		for (Turtle turtle: model.getActiveTurtles())
		{
			deg = Math.abs(turtle.getDirectionAngle() - arguments.get(0).getValue());
			turtle.setDirectionAngle(arguments.get(0).getValue());
		}
		value = deg;
		return value;
	}


}
