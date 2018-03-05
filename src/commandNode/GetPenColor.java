package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;

public class GetPenColor extends GenCommand implements CommandNode {

	public GetPenColor(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
	}

	@Override
	/**
	 * returns turtle's current color index
	 * 
	 * @return turtle's color index
	 */
	public double evaluate(List<NodeI> arguments) {
		// TODO Auto-generated method stub
		return 0;
	}

}
