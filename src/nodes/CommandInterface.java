package nodes;

import java.util.List;

/**
 * This interface is what will define a command in the NodeFactory and distinguish from custom
 * commands. Tree building will use this to know whether or not to continue recursion if a child node
 * is a traditional command node with children.
 *
 * author: Charlie Dracos
 */
public interface CommandInterface {

    double evaluate(List<NodeInterface> arguments);
    void reset();
    void add(NodeInterface n);
    NodeInterface getNext();
    boolean hasNext();

}
