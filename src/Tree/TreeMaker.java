package Tree;

import java.util.ArrayList;
import java.util.List;

import typeNodes.typeNode;

public class TreeMaker {
	private ArrayList<typeNode> nodes;
	private ArrayList<typeNode> heads;
	private int index;
	
	public TreeMaker (List<typeNode> nodes) {
		this.nodes = (ArrayList<typeNode>) nodes;
		heads = new ArrayList<typeNode>();
		index = 0;
		heads.add(makeTree(nodes.get(index)));
	}
	
	private typeNode makeTree(typeNode node) {
		typeNode head = node;
		while (head.hasNext()) {
			index++;
			head.addChild(nodes.get(index));
			node = head.getChild();
			makeTree(node);
			head = node.getParent();
		}
		return head;
	}
	
	
}
