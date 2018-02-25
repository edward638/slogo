package parsers;

import nodes.NodeFactory;
import nodes.Node;

public class SampleMain {
	
	public static void main(String[] args)
	{
		Model m = new Model();
		
		Parser newnew = new Parser(m, "English");
		//newnew.addResources("parsers/regex");
		newnew.parseString("fd fd");
	}

}