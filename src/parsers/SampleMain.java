package parsers;

import java.util.ArrayList;
import java.util.List;

import Tree.TreeEvaluator;
import Tree.TreeMaker;
import Tree.tNode;
import nodes.*;

public class SampleMain {
	
	public static void main(String[] args)
	{
		Model m = new Model();
		
		Parser newnew = new Parser(m, "English");
		//newnew.addResources("parsers/regex");
		List<Node> nodes = newnew.parseString("fd fd 50");
		TreeMaker tm  = new TreeMaker(nodes);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator(heads);
		System.out.println(te.getValue());
	}

}