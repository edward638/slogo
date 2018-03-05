package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class Tangent extends GenCommand implements CommandNode {

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
	public double evaluate(List<NodeI> arguments) {
		double tan = Math.tan(arguments.get(0).getValue());
		value = tan;
		return value;
	}
	

}
