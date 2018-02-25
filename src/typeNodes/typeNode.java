package typeNodes;

public abstract class typeNode {
	private double value;

	public typeNode (double x) {
		value = x;
	}
	
	protected double getValue() {
		return value;
	}
	
	protected void setValue(double x) {
		value = x;
	}
	
	public abstract double evaluate();
}
