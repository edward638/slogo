package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class Tangent extends GeneralCommand implements CommandInterface {

	public Tangent(Turtle turt, int numChildren) {
		super(turt, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 *return tangent of degrees
	 * 
	 * @return tan(degrees)
	 */
	public double evaluate(List<NodeInterface> arguments) {
		double tan = Math.tan(arguments.get(0).getValue());
		value = tan;
		return value;
	}
	

}
