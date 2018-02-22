package OperationNodes;

import typeNodes.typeNode;

public class Binop {
	private typeNode left;
	private typeNode right;
	private String opType;
	
	public Binop (typeNode left, String opType) {
		this.left = left;
		this.opType = opType;
	}
	
	public void addRight (typeNode right) {
		this.right = right;
	}
	
	public double evaluate() {
		if (opType.equals("SUM")) {
			return left.evaluate() + right.evaluate();
		}
		else if (opType.equals("DIFFERENCE")) {
			return left.evaluate() - right.evaluate();
		}
		else if (opType.equals("PRODUCT")) {
			return left.evaluate()*right.evaluate();
		}
		else if (opType.equals("QUOTIENT")) {
			return left.evaluate()/right.evaluate();
		}
		else if (opType.equals("REMAINDER")) {
			return left.evaluate()%right.evaluate();
		}
		return -left.evaluate();
	}

}
