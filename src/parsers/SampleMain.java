package parsers;

import java.util.ArrayList;
import java.util.List;

import Tree.TreeEvaluator;
import Tree.TreeMaker;

import model.Turtle;
import nodes.*;

public class SampleMain {
	
	public static void main(String[] args) throws ClassNotFoundException, InvalidEntryException
	{
		Turtle turt = new Turtle(0,0);

		Parser newnew = new Parser(turt, "English");
		//newnew.addResources("parsers/regex");
<<<<<<< HEAD
		List<Node> nodes = newnew.parseString("make :x fd 50");
=======
		List<Node> nodes = newnew.parseString("make :x [ fd 50 ] 50 70 [ :x 2 ]");
>>>>>>> 2908dd6bd35456718edf46a12da48306d8cb44d9
		
		TreeMaker tm  = new TreeMaker(nodes);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator(heads);
		System.out.println(te.getValue());
	}

}