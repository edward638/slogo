package nodes;

import java.util.List;

import model.VariableHistory;

public class Variable extends Node{
	private String name;
	private double value;
	private VariableHistory VH;
	
	public Variable (String name, VariableHistory VH) {
		super(null, 0);
		this.name = name;
		this.VH = VH;
	}
	
	public String getName() {
		return name;
	}
	
	public double getValue() {
		return VH.getValue(name);
	}
	
	public VariableHistory getVH() {
		return VH;
	}

	public double evaluate(List<Node> args) {
		return value;
	}
}
