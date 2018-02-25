package nodes;

public class ConstantNode extends Node{
	private Double value;
	
	public ConstantNode (Double value) {
		super(null, 0);
		this.value = value;
	}
	
	public double evaluate() {
		return value;
	}
}