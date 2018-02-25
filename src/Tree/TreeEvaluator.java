package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeEvaluator {
	private Double returnValue;
	private ArrayList<tNode> heads;
	private HashMap<tNode, ArrayList<Double>> args;
	
	public TreeEvaluator (List<tNode> heads) {
		this.heads = (ArrayList<tNode>) heads;
		args = new HashMap<tNode, ArrayList<Double>>();
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
	
	private void evaluateHead(tNode node) {
		ArrayList<Double> nArgs = new ArrayList<Double>();
		args.put(node, nArgs);
		while (node.hasNext()) {	
			tNode curr = node.getChild();
			//System.out.println(curr.getValue());
			if (!curr.hasNext()) {
				nArgs.add(curr.getValue());
				args.put(node, nArgs);
			}
			else {
				evaluateHead(curr);
				nArgs.add(curr.getValue());
				args.put(node, nArgs);
			}
		}
		returnValue = node.evaluate(args.get(node));
	}
}
