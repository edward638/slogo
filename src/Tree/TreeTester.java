package Tree;

import java.util.ArrayList;

import nodes.*;
import commandNode.*;
import model.Turtle;
import model.VariableHistory;
import model.CommandHistory;

import javafx.scene.paint.Color;

public class TreeTester {
	private static ArrayList<Node> nodes;

	public static void main (String [] args) {
		Turtle t = new Turtle(0.0, 0.0, Color.WHITE);
		CommandHistory CH = new CommandHistory();
		VariableHistory VH = new VariableHistory(CH);
		nodes = new ArrayList<Node>();
		MakeVariable  mv = new MakeVariable(t, 2);
		nodes.add(mv);
		Variable v = new Variable(":X", VH);
		nodes.add(v);
		Constant c = new Constant(0);
		nodes.add(c);
		For f = new For(t, 2);
		nodes.add(f);
		Liste l = new Liste();
		l.add(v);
		Constant c2 = new Constant(1);
		l.add(c2);
		Constant c3 = new Constant(10);
		l.add(c3);
		Constant c4 = new Constant(1);
		l.add(c4);
		nodes.add(l);
		Liste l2 = new Liste();
		Forward fw = new Forward(t, 1);
		l2.add(fw);
		l2.add(v);
		nodes.add(l2);
		TreeMaker tm  = new TreeMaker(nodes, CH);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator();
		System.out.println(te.evaluate(heads));

	}
}

