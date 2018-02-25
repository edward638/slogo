package commandNodesnotdone;

import java.util.ArrayList;

import nodes.CommandNode;
import nodes.Node;
import parsers.Turtle;

public class ArcTangent extends Node implements CommandNode{

	public ArcTangent(Turtle turt, int numChildren) {
		super(turt, numChildren);
	}

	@Override
	public double evalute(ArrayList<Double> arguments) 
	{
		return 0;
	}

}
