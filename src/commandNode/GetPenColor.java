package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class GetPenColor extends GeneralCommand implements CommandInterface  {

	public GetPenColor(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
	}


	@Override
	public double evaluate(List<NodeInterface> arguments) {
		// TODO Auto-generated method stub
		return 0;
	}

}
