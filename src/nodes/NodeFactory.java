package nodes;

import java.lang.reflect.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import model.Model;
import model.Turtle;

public class NodeFactory 
{	
	public static Object makeNode(Class<?> clazz,Model model, int numChildren)
	{
		try
		{
			Constructor<?> c = clazz.getConstructor(new Class[] {Model.class,Integer.TYPE});
			c.setAccessible(true);
			Object o = c.newInstance(model, numChildren);
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
