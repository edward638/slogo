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
		VariableHistory VH = new VariableHistory();
		nodes = new ArrayList<Node>();
		MakeVariable mv = new MakeVariable(null, 2);
		nodes.add(mv);
		Variable v = new Variable(":x", VH);
		nodes.add(v);
		Constant c0 = new Constant(30);
		nodes.add(c0);
		MakeVariable mv2 = new MakeVariable(null, 2);
		nodes.add(mv2);
		Variable v2 = new Variable(":y", VH);
		nodes.add(v2);
		Constant c02 = new Constant(20);
		nodes.add(c02);
		MakeUserInstruction mui = new MakeUserInstruction(t, 3);
		nodes.add(mui);
		Command c = new Command("exampleCommand", VH);
		nodes.add(c);
		Liste l = new Liste();
		l.add(v);
		l.add(v2);
		nodes.add(l);
		Liste l2 = new Liste();
		Forward f = new Forward(t, 1);
		l2.add(f);
		l2.add(v);
		Right r = new Right(t, 1);
		l2.add(r);
		l2.add(v2);
		nodes.add(l2);
		nodes.add(c);
		TreeMaker tm  = new TreeMaker(nodes);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator();
		System.out.println(te.evaluate(heads));

	}
}

