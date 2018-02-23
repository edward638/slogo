package Tree;

import java.util.ArrayList;

public class TreeTester {
	private static int index;
	private static ArrayList<Node> nodes;
	
	public static void main (String [] args) {
		Tester();
	}
	public static void Tester () {
		index = 0;
		nodes = new ArrayList<Node>();
		nodes.add(new Node(10, 3));
		nodes.add(new Node(5, 0));
		nodes.add(new Node (3, 1));
		nodes.add(new Node (2, 0));
		nodes.add(new Node (1, 0));
		Node head = treeMake(nodes.get(index));
		System.out.println(head.toString());
	}
	
	public static Node treeMake (Node node) {
		Node head = node;
		while (head!=null && head.hasNext()) {
			index+=1;
			head.addChild(nodes.get(index));
			node = head.getChild();
			treeMake(node);
			node = head.getParent();
		}
		return head;
	}
}

class Node {
	private Node[] children;
	private Node parent;
	private Double value;
	private int current;
	
	public Node (double value, int size) {
		this.value = value;
		children = new Node [size];
		current = 0;
	}
	
	public boolean hasNext() {
		if (current!=children.length) return true;
		return false;
	}
	
	public void setParent(Node n) {
		if (n==null) {
			this.parent = this;
		}
		else { this.parent = n; }
	}
	
	public void addChild(Node n) {
		if (current != children.length) {
			children[current] = n;
		}
	}
	
	public Node getChild() {
		if (current!=children.length) {
			Node child = children[current];
			current++;
			return child;
		}
		return null;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public Double getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		String ret = "";
		for (int i = 0; i < children.length; i++) {
			ret = ret + children[i].getValue().toString();
		}
		return ret;
	}
}
