package OperationNodes;

public class Return {
	private CommandNode child;

	public Return(CommandNode child) {
		this.child = child;
	}

	public double returnValue() {
		return child.evaluate();
	}
}
