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
		Constant c0 = new Constant(20);
		nodes.add(c0);
		MakeUserInstruction mui = new MakeUserInstruction(t, 3);
		nodes.add(mui);
		Command c = new Command("circle", VH);
		nodes.add(c);
		Liste l = new Liste();
		l.add(v);
		nodes.add(l);
		Liste l2 = new Liste();
		Forward f = new Forward(t, 1);
		l2.add(f);
		l2.add(v);
		nodes.add(l2);
		nodes.add(c);
		TreeMaker tm  = new TreeMaker(nodes);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator();
		System.out.println(te.evaluate(heads));
	}
}

