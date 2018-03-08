package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class SetHeading extends GeneralCommand {

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
		double x = arguments.get(0).getValue();
		model.update((y) -> setHeading(y, x));
		return value;
	}

	public void setHeading (Turtle t, double x) {
		double deg = Math.abs(t.getDirectionAngle() - x);
		t.setDirectionAngle(x);
		value = deg;
	}
}
