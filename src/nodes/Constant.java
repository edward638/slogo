package nodes;

import java.util.List;

public class Constant extends Node{
	private Double value;
	
	public Constant (double value) {
		super(null, 0);
		this.value = value;
	}

	public double evaluate(List<Double> args) {
		return value;
	}
}