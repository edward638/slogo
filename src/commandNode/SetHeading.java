package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class SetHeading extends GeneralCommand implements CommandInterface {

	public SetHeading(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * turns turtle to an absolute heading
	 * 
	 * @return number of degrees moved
	 */
	public double evaluate(List<NodeInterface> arguments) {
		double deg = Math.abs(turtle.getDirectionAngle() - arguments.get(0).getValue());
		turtle.setDirectionAngle(arguments.get(0).getValue());
		value = deg;
		return value;
	}


}
