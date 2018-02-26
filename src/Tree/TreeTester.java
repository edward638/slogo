package Tree;

import java.util.ArrayList;

public class TreeTester {
	private static ArrayList<tNode> nodes;
	
	public static void main (String [] args) {
		nodes = new ArrayList<tNode>();
		nodes.add(new tNode(0, 2));
		nodes.add(new tNode(6, 2));
		nodes.add(new tNode (4, 0));
		nodes.add(new tNode (3, 1));
		nodes.add(new tNode (2, 0));
		nodes.add(new tNode (7, 0));
//		TreeMaker tm  = new TreeMaker(nodes);
//		ArrayList<tNode> heads = (ArrayList<tNode>) tm.getHeads();
//		TreeEvaluator te = new TreeEvaluator(heads);
	}

}

