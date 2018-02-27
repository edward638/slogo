package Tree;

import java.util.ArrayList;

import nodes.*;
import commandNode.*;
import model.Turtle;

public class TreeTester {
	private static ArrayList<Node> nodes;
	
	public static void main (String [] args) {
		Turtle t = new Turtle(0, 0);
		nodes = new ArrayList<Node>();
		/**Repeat r = new Repeat(null, 2);
		Backward b = new Backward(t, 1);
		Constant c = new Constant(5);
		nodes.add(r);
		nodes.add(b);
		nodes.add(c);
		Liste l = new Liste();
		Forward f = new Forward(t, 1);
		Constant c2 = new Constant(20);
		Backward b2 = new Backward(t, 1);
		Constant c3 = new Constant(5);
		l.add(f);
		l.add(c2);
		l.add(b2);
		l.add(c3);
		nodes.add(l);**/
		TreeMaker tm  = new TreeMaker(nodes);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator();
		System.out.println(te.evaluate(heads));
	}
}

