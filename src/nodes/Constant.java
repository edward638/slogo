package nodes;

import java.util.List;

public class Constant extends Node{
	private Double value;
	
	public Constant (Double value) {
		super(null, 0);
		this.value = value;
	}

	public Double evaluate(List<Double> args) {
		return value;
	}
}