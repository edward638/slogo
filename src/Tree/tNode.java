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
	
	public Double getValue() {
		return value;
	}
	
	public tNode getChild() {
		if (current!=children.length) {
			tNode child = children[current];
			current++;
			return child;
		}
		return null;
	}
	
	public void addChild(tNode n) {
		if (current != children.length) {
			children[current] = n;
		}
	}
	
	public boolean hasNext() {
		if (current!=children.length) return true;
		return false;
	}
	
	public void reset() {
		current = 0;
	}
	
	public Double evaluate(List<Double> args) {
		for (int i = 0; i < args.size(); i++) {
			value+=args.get(i);
		}
		return value;
	}
	
	public String toString() {
		String ret = "";
		for (int i = 0; i < children.length; i++) {
			ret = ret + children[i].getValue().toString();
		}
		return ret;
	}
}
