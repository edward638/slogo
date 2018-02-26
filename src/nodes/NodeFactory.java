package nodes;

import java.lang.reflect.*;

import model.Turtle;
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
			e.printStackTrace();
		}
		return null;
	}
}
