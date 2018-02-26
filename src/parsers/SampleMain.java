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

		List<Node> nodes = newnew.parseString("make :x fd 50");

		
		TreeMaker tm  = new TreeMaker(nodes);
		ArrayList<Node> heads = (ArrayList<Node>) tm.getHeads();
		TreeEvaluator te = new TreeEvaluator(heads);
		System.out.println(te.getValue());
	}

}