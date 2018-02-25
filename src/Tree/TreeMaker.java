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
		while (index < this.nodes.size()) {
			heads.add(makeTree(this.nodes.get(index)));
		}
	}
	
	protected List<tNode> getHeads() {
		return heads;
	}
	
	private tNode makeTree(tNode node) {
		index+=1;
		while (node!=null && node.hasNext()) {
			node.addChild(nodes.get(index));
			tNode curr = node.getChild();
			makeTree(curr);
		}
		node.reset();
		return node;
	}
}
