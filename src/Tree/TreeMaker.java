package Tree;


import java.util.ArrayList;
import java.util.List;

import nodes.*;

/**
 * This is the class that makes the tree of nodes. The tree uses the fact that each node
 * has a specific amount of children, and add that may commands after it to its children
 * recursively, building the tree from the bottom up.
 */
public class TreeMaker {
	private ArrayList<NodeI> nodes;
	private ArrayList<HeadI> heads;
	private int index;

	/**
	 * Constructor which initializes its values and begins the tree-making process
	 * @param nodes the nodes to be made into trees
	 */
	public TreeMaker (List<NodeI> nodes) {
		this.nodes = (ArrayList<NodeI>) nodes;
		heads = new ArrayList<HeadI>();
		index = 0;
		while (index < this.nodes.size()) {
			try {
				HeadI head = (HeadI) this.nodes.get(index);
				heads.add(makeTree(head)); //add this head node to the head nodes which represent trees
			}
			catch (Exception e) {
				throw new HeadException();
			}
		}
	}
	
	public List<HeadI> getHeads() {
		return heads; //returns the heads of the trees made
	}

	/**
	 * Recursively makes the tree by testing the amount of children and calling
	 * makeTree on a child who also has a child
	 * @param node the node to be added to the tree
	 * @return the head node of the tree
	 */
	private HeadI makeTree(HeadI node) {
		index+=1;
		while (node!=null && node.hasNext()) { //while there are nodes in the list
			try {
				NodeI curr = nodes.get(index);
				node.add(curr);
				if (curr instanceof HeadI) {
					HeadI head = (HeadI) curr;
					makeTree(head); //add the next node in the list index
				}
				else {
					index++;
				}
			}
			catch (IndexOutOfBoundsException e) {
				throw new NodeArgumentException(); //if a child is expected but nothing there throws error
			}
		}
		node.reset(); //resets so can be sorted through later
		return node;
	}
}
