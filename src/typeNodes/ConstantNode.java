package typeNodes;

public class ConstantNode extends typeNode{
	
	public ConstantNode (double x) {
		super(x);
	}
	
	public double evaluate() {
		return getValue();
	}
}
