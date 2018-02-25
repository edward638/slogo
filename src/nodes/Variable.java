package nodes;

import java.util.List;

import model.VariableHistory;

public class Variable extends Node{
	private String name;
	private Double value;

	public Variable (String name, Double value) {
		super(null, 0);
		this.name = name;
		this.value = value;
	}
	
	public Variable (String name, VariableHistory VH) {
		super(null, 0);
		this.name = name;
		this.value = VH.getValue(this.name);
	}
	
	public String getName() {
		return name;
	}

	public Double evaluate(List<Double> args) {
		return value;
	}
}
