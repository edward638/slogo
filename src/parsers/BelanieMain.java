package parsers;

import model.Turtle;
import model.VariablesHistory;
import nodes.NodeInterface;

public class BelanieMain {
	
	public static void main(String[] args)
	{
		NewNodeFactory nf = new NewNodeFactory();
		NodeInterface n = nf.makeNode("Variable", "five", 1.0, new VariablesHistory());
//		System.out.println(n.getValue());
	}
}
