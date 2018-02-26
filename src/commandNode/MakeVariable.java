package commandNode;

import java.util.List;

import model.Turtle;
import model.VariableHistory;
import nodes.CommandNode;
import nodes.Node;
import nodes.Variable;

public class MakeVariable extends Node implements CommandNode{
	

	public MakeVariable(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evaluate(List<Node> args) {
		Variable v = (Variable) args.get(0);
		v.setValue(args.get(1).getValue());
		VariableHistory VH = v.getVH();
		VH.add((Variable) v);
		value = args.get(1).getValue();
		return value;
	}

}
