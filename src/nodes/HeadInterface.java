package nodes;

import java.util.List;

/**
 * This is what defines a head of a tree, and when tree building only nodes of
 * this type are allowed to be the head of a tree, as it can access children,
 * return children and add children. All head nodes can evaluate to return a value
 * based on their children or what defines them.
 *
 * author: Charlie Dracos
 */
public interface HeadInterface {

    NodeInterface getNext();

    boolean hasNext();

    double evaluate(List<NodeInterface> args);

    void add(NodeInterface n);

    void reset();
}
