package Tree;

import java.util.ArrayList;

import nodes.*;
import commandNode.*;
import model.Turtle;
import model.VariableHistory;

public class TreeTester {
	private static ArrayList<Node> nodes;
	
	public static void main (String [] args) {
		Turtle t = new Turtle(0, 0);
		VariableHistory VH = new VariableHistory();
		nodes = new ArrayList<Node>();
		MakeVariable mv = new MakeVariable(t, 2);
		nodes.add(mv);
		Variable v = new Variable (":x", VH);
		nodes.add(v);
		Constant c = new Constant(0);
		nodes.add(c);
		DoTimes dt = new DoTimes(t, 2);
		nodes.add(dt);
		Liste l = new Liste();
		l.add(v);
		l.add(new Constant(10));
		nodes.add(l);
		Liste l2 = new Liste();
		l.add(new Forward(t, 1));
		l.add(v);
		nodes.add(l2);
		TreeMaker tm  = new TreeMaker(nodes);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator();
		System.out.println(te.evaluate(heads));
	}
}

