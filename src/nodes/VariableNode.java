package nodes;

import model.VariableHistory;

public class VariableNode extends Node{
	private String name;
	private Double value;

	public VariableNode (String name, Double value) {
		super(null, 0);
		this.name = name;
		this.value = value;
	}
	
	public VariableNode (String name, VariableHistory VH) {
		super(null, 0);
		this.name = name;
		this.value = VH.getValue(this.name);
	}
	
	public String getName() {
		return name;
	}

	public double evaluate() {
		return value;
	}
}
