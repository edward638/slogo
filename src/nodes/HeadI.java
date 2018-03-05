package nodes;

import java.util.List;

public interface HeadI {

    public NodeI getNext();
    public boolean hasNext();
    public double evaluate(List<NodeI> args);
    public void add(NodeI n);
    public void reset();
}
