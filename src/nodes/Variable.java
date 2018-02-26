package nodes;

import java.util.List;

import model.VariableHistory;

public class Variable extends Node{
	private String name;
	private double value;

	public Variable (String name, double value) {
		super(null, 0);
		this.name = name;
		this.value = value;
	}
	
	public Variable (String name) {
		super(null, 0);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public double evaluate(List<Double> args) {
		return value;
	}
}
