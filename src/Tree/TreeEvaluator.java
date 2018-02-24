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
		execute();
	}
	
	private void execute() {
		for (int i = 0; i < heads.size(); i++) {
			evaluate(heads.get(i));
		}
	}
	
	private void evaluate(tNode node) {
		ArrayList<Double> nArgs = new ArrayList<Double>();
		args.put(node, nArgs);
		while (node.hasNext()) {	
			tNode curr = node.getChild();
			System.out.println(curr.getValue());
			if (curr.getChild()==null) {
				nArgs.add(curr.getValue());
				args.put(node, nArgs);
			}
			else {
				evaluate(curr);
			}
		}
		returnValue = node.evaluate(args.get(node));
	}
	
	public Double getValue() {
		return returnValue;
	}
}
