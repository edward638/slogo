package parsers;

import nodes.NodeFactory;
import nodes.Node;

public class SampleMain {
	
	public static void main(String[] args)
	{
		Model m = new Model();
		
		Parser newnew = new Parser(m, "English");
		//newnew.addResources("parsers/regex");
		newnew.parseString("product sum difference fd + 5 6");
		try {
			Node n = (Node)NodeFactory.makeNode(Class.forName("parsers.Sum"));
			System.out.print(n.getValue());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}