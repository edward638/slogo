package commandNode;

import java.util.List;

import model.Turtle;
import nodes.CommandNode;
import nodes.Node;

public class IfElse extends Node implements CommandNode {

	public IfElse(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	/**
	 * if expr is not 0, runs the trueCommands given in the first list, otherwise runs the falseCommands given in the second list
	 * returns the value of the final command executed (or 0 if no commands are executed)
	 * 
	 * @return value of the final command executed
	 */
	public double evaluate(List<Node> args) {
		value = 0;
		if(args.get(0).getValue() != 0)
		{
			//double val = args.get(1).evaluate("?");
			//value =  val;
		}
		else
		{
			//double val = args.get(2).evaluate("?");
			//value =  val;
		}
		return value;
	}
	

}
