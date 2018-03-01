package Tree;

import java.util.ArrayList;
import java.util.List;

import model.CommandHistory;

import nodes.CommandNode;
import nodes.Node;

/**
 * This is the class that makes the tree of nodes. The tree uses the fact that each node
 * has a specific amount of children, and add that may commands after it to its children
 * recursively, building the tree from the bottom up.
 */
public class TreeMaker {
	private ArrayList<Node> nodes;
	private ArrayList<Node> heads;
	private int index;

	/**
	 * Constructor which initializes its values and begins the tree-making process
	 * @param nodes the nodes to be made into trees
	 */
	public TreeMaker (List<Node> nodes) {
		this.nodes = (ArrayList<Node>) nodes;
		heads = new ArrayList<Node>();
		index = 0;
		while (index < this.nodes.size()) {
			if (!(this.nodes.get(index) instanceof CommandNode)) {
				throw new HeadException(); //cannot have a non-command head of tree
			}
			heads.add(makeTree(this.nodes.get(index))); //add this head node to the head nodes which represent trees
		}
	}
	
	public List<Node> getHeads() {
		return heads; //returns the heads of the trees made
	}

	/**
	 * Recursively makes the tree by testing the amount of children and calling
	 * makeTree on a child who also has a child
	 * @param node the node to be added to the tree
	 * @return the head node of the tree
	 */
	private Node makeTree(Node node) {
		index+=1;
		while (node!=null && node.hasNext()) { //while there are nodes in the list
			try {
				node.addChild(nodes.get(index)); //add the next node in the list index
			}
			catch (IndexOutOfBoundsException e) {
				throw new NodeArgumentException(); //if a child is expected but nothing there throws error
			}
			Node curr = node.getChild(); //recursive step on the child
			makeTree(curr);
		}
		node.reset(); //resets to can be sorted through later
		return node;
	}
}
