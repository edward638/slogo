package Tree;

import java.util.ArrayList;

import nodes.*;
import commandNode.*;
import model.Turtle;
import model.VariableHistory;

import java.awt.Color;

public class TreeTester {
	private static ArrayList<Node> nodes;
	
	public static void main (String [] args) {
		Turtle t = new Turtle(0, 0, Color.WHITE);
		VariableHistory VH = new VariableHistory();
		nodes = new ArrayList<Node>();
		Repeat r = new Repeat(t, 2);
		Constant c1 = new Constant(0);
		Liste l = new Liste();
		Forward f = new Forward(t, 1);
		Constant c2 = new Constant(10);
		TreeMaker tm  = new TreeMaker(nodes);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator();
		System.out.println(te.evaluate(heads));
	}
}

