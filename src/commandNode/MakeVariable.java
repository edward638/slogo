package commandNode;

import java.util.List;

import model.Turtle;
import model.VariableHistory;
import nodes.CommandNode;
import nodes.GenCommand;
import nodes.NodeI;
import nodes.Variable;

/**
 * Makes a new variable as described on the course site
 */

public class MakeVariable extends GenCommand implements CommandNode{
	

	public MakeVariable(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<NodeI> args) {
		Variable v = (Variable) args.get(0);
		v.setValue(args.get(1).getValue()); //sets the value of the variable
		VariableHistory VH = v.getVH();
		VH.add(v); //adds to its vh
		value = args.get(1).getValue();
		return value;
	}

}
