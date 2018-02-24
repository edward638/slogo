package OperationNodes;

import typeNodes.typeNode;

public class Compare {
	private typeNode left;
	private typeNode right;
	private String compType;

	public Compare (typeNode left, String compType) {
		this.left = left;
		this.compType = compType;
	}
	
	public void addRight (typeNode right) {
		this.right = right;
	}
	
	public double evaluate() {
		if (compType.equals("LESS?")) {
			if (left.evaluate()<right.evaluate()) return 1;
			return 0;
		}
		else if (compType.equals("GREATER?")) {
			if (left.evaluate()>right.evaluate()) return 1;
			return 0;
		}
		else if (compType.equals("EQUAL?")) {
			if (left.evaluate()==right.evaluate()) return 1;
			return 0;
		}
		else if (compType.equals("NOTEQUAL?")) {
			if (left.evaluate()!=right.evaluate()) return 1;
			return 0;
		}
		else if (compType.equals("AND")) {
			if (left.evaluate()!=0 && right.evaluate()!=0) return 1;
			return 0;
		}
		else if (compType.equals("OR")) {
			if (left.evaluate()!=0 || right.evaluate()!=0) return 1;
			return 0;
		}
		if (left.evaluate()==0) return 1;
		return 0;
	}
}
