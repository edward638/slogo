package Tree;

import java.util.ArrayList;
import java.util.List;

import nodes.CommandNode;
import nodes.Node;

public class TreeEvaluator {
	private Double returnValue;
	
	public TreeEvaluator () {
		returnValue = 0.0;
	}
	
	public double evaluate(ArrayList<Node> heads) {
		for (int i = 0; i < heads.size(); i++) {
			evaluateHead(heads.get(i));
		}
		return returnValue;
	}
	
	private void evaluateHead(Node node) {
		ArrayList<Node> nArgs = new ArrayList<Node>();
		while (node.hasNext()) {	
			Node curr = node.getChild();
			if (!curr.hasNext()) {
				nArgs.add(curr);
			}
			else {
				evaluateHead(curr);
				nArgs.add(curr);
			}
		}
		node.reset();
		//System.out.println("calling evaluate");
		returnValue = node.evaluate(nArgs);
		//else returnValue = node.getValue();
	}
}
