package Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeMaker {
	private ArrayList<tNode> nodes;
	private ArrayList<tNode> heads;
	private int index;
	
	public TreeMaker (List<tNode> nodes) {
		this.nodes = (ArrayList<tNode>) nodes;
		heads = new ArrayList<tNode>();
		index = 0;
		while (index < this.nodes.size()-1) {
			heads.add(makeTree(this.nodes.get(index)));
		}
	}
	
	private tNode makeTree(tNode node) {
		while (node!=null && node.hasNext()) {
			index+=1;
			node.addChild(nodes.get(index));
			tNode curr = node.getChild();
			curr.setParent(node);
			makeTree(curr);
		}
		node.reset();
		return node;
	}
	
	protected List<tNode> getHeads() {
		return heads;
	}
	
	
}
