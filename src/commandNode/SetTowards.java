package commandNode;

import java.util.List;

import model.Model;
import model.Turtle;
import nodes.CommandInterface;
import nodes.GeneralCommand;
import nodes.NodeInterface;

public class SetTowards extends GeneralCommand
{
	private double degreeConversion = 180/Math.PI;
			
	public SetTowards(Model model, int numChildren) {
		super(model, numChildren);
	}

	@Override
	/**
	 * turns turtle to face the point (x, y), where (0, 0) is the center of the screen
	 * 
	 * @return the number of degrees turtle turned
	 */
	public double evaluate(List<NodeInterface> arguments) {
		double rad = Math.atan(arguments.get(1).getValue()/arguments.get(0).getValue());
		double deg = rad * degreeConversion; 
		if(arguments.get(0).getValue() < 0)
		{
			deg = 180 + deg;
		}
		
		double change = 0;
		for (Turtle turtle: model.getActiveTurtles())
		{
			change = Math.abs(turtle.getDirectionAngle() - deg);
			turtle.setDirectionAngle(deg);
		}
		value = change;
		return value;
	}


}
