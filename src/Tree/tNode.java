package Tree;

import java.util.List;

public class tNode {
	private tNode[] children;
	private Double value;
	private int current;
	
	public tNode (double value, int size) {
		this.value = value;
		children = new tNode [size];
		current = 0;
	}
	
	public boolean hasNext() {
		if (current!=children.length) return true;
		return false;
	}
	
	public void addChild(tNode n) {
		if (current != children.length) {
			children[current] = n;
		}
	}
	
	public tNode getChild() {
		if (current!=children.length) {
			tNode child = children[current];
			current++;
			return child;
		}
		return null;
	}
	
	public Double getValue() {
		return value;
	}
	
	public Double evaluate(List<Double> args) {
		for (int i = 0; i < args.size(); i++) {
			value+=args.get(i);
		}
		//System.out.println(value);
		return value;
	}
	
	public void reset() {
		current = 0;
	}
	
	public String toString() {
		String ret = "";
		for (int i = 0; i < children.length; i++) {
			ret = ret + children[i].getValue().toString();
		}
		return ret;
	}
}
