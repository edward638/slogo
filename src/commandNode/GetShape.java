package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class GetShape extends GeneralCommand implements CommandInterface{

	public GetShape(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate(List<NodeInterface> arguments) {
		// TODO Auto-generated method stub
		return 0;
	}

}
