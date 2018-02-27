package Tree;

import java.util.ArrayList;
import java.util.List;

import nodes.CommandNode;
import nodes.Node;

public class TreeEvaluator {
	private Double returnValue;
	private ArrayList<Node> heads;
	
	public TreeEvaluator (List<Node> heads) {
		this.heads = (ArrayList<Node>) heads;
		returnValue = 0.0;
		evaluate();
	}
		
	public Double getValue() {
		return returnValue;
	}
	
	private void evaluate() {
		for (int i = 0; i < heads.size(); i++) {
			evaluateHead(heads.get(i));
		}
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
		if (node instanceof CommandNode)  {
			CommandNode CN = (CommandNode) node;
			returnValue = CN.evaluate(nArgs);
		}
		//else returnValue = node.getValue();
	}
}
