package nodes;

import java.lang.reflect.*;

public class NodeFactory 
{
	public static Object makeNode(Class<?> clazz)
	{
		try
		{
			Constructor<?> c = clazz.getDeclaredConstructor();
			Object o = c.newInstance();
			return o;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
