package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import model.VariablesHistory;
import nodes.*;

/**
 * Makes a new variable as described on the course site
 */

public class MakeVariable extends GeneralCommand implements CommandInterface {
	

	public MakeVariable(Model model, int numChildren) {
		super(model, numChildren);
	}

	@Override
	public double evaluate(List<NodeInterface> args) {
		try {
			Variable v = (Variable) args.get(0);
			v.setValue(args.get(1).getValue()); //sets the value of the variable
			VariablesHistory VH = v.getVH();
			VH.add(v); //adds to its vh
			value = args.get(1).getValue();
			return value;
		}
		catch (ClassCastException e) {
			throw new ImproperNodeException();
		}
	}

}
