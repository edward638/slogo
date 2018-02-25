package typeNodes;

public class VariableNode extends typeNode{
	private String name;

	public VariableNode (String name, double x) {
		super(x);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue (double x) {
		setValue(x);
	}

	public double evaluate() {
		return getValue();
	}
}
