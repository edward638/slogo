package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class SetShape extends GeneralCommand implements CommandInterface{

	public SetShape(Turtle turtle, int numChildren) {
		super(turtle, numChildren);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate(List<NodeInterface> arguments) {
		// TODO Auto-generated method stub
		return 0;
	}

}
