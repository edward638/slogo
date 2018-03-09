package Tree;


import java.util.ArrayList;
import java.util.List;

import nodes.NodeInterface;
import nodes.HeadInterface;
import nodes.CommandInterface;

/**
 * This is the class that makes the tree of nodes. The tree uses the fact that each node
 * has a specific amount of children, and add that may commands after it to its children
 * recursively, building the tree from the bottom up.
 */
public class TreeMaker {
	private ArrayList<NodeInterface> nodes;
	private ArrayList<HeadInterface> heads = new ArrayList<>();
	private int index = 0;

	/**
	 * Constructor which initializes its values and begins the tree-making process
	 * @param nodes the nodes to be made into trees
	 */
	public TreeMaker (List<NodeInterface> nodes) {
		this.nodes = (ArrayList<NodeInterface>) nodes;
		while (index < this.nodes.size()) {
			if (this.nodes.get(index) instanceof HeadInterface &&
					!(this.nodes.get(index) instanceof CommandInterface)) {
				HeadInterface head = (HeadInterface) this.nodes.get(index);
				heads.add(head); //add this head node to the head nodes which represent trees
				index++;
			}
			else {
				CommandInterface head = (CommandInterface) this.nodes.get(index);
				heads.add(makeTree(head));
			}
		}
	}
	
	public List<HeadInterface> getHeads() {
		return heads; //returns the heads of the trees made
	}

	/**
	 * Recursively makes the tree by testing the amount of children and calling
	 * makeTree on a child who also has a child
	 * @param node the node to be added to the tree
	 * @return the head node of the tree
	 */
	private HeadInterface makeTree(CommandInterface node) {
		index+=1; //moves to next index when a head is called
		while (node!=null && node.hasNext()) { //while there are nodes in the list
			NodeInterface curr = nodes.get(index);
			node.add(curr);
			if (curr instanceof CommandInterface) {
				CommandInterface head = (CommandInterface) curr;
				makeTree(head); //add the next node in the list index
			}
			else {
				index++; //moves to next node in the list while in the loop for non-heads
			}
		}
		node.reset(); //resets so can be sorted through later
		return (HeadInterface) node;
	}
}
