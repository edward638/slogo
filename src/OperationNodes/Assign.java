package OperationNodes;

import typeNodes.VariableNode;
import typeNodes.typeNode;

public class Assign {
	private VariableNode left;
	private typeNode right;
	public Assign (typeNode child) {
		right = child;
		init();
	}
	
	private void init() {
		left = new VariableNode("x", 0);
		left.setValue(right.evaluate());
	}
	
	public double getValue() {
		return left.evaluate();
	}
}
