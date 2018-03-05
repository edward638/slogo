package nodes;

import java.lang.reflect.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import model.Turtle;
import model.VariableHistory;
import nodes.Node;

public class NodeFactory 
{	
	public static Object makeNode(Class<?> clazz,Turtle t, int numChildren)
	{
		try
		{
			Constructor<?> c = clazz.getConstructor(new Class[] {Turtle.class,Integer.TYPE});
			c.setAccessible(true);
			Object o = c.newInstance(t, numChildren);
			return o;
		}
		catch(Exception e) 
		{
			//CHANGE THIS EXCEPTION
			e.printStackTrace();
		}
		return null;
	}
}
