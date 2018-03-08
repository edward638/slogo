package nodes;

import java.lang.reflect.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import model.Model;
import model.Turtle;
import model.VariablesHistory;

public class NodeFactory 
{	
	private Map<String,Class[]> commandToParams;
	private static String PARAMETER_FILE = "parsers/commandToConstructorParameters";
	
	public NodeFactory()
	{
		buildParameterMap();
	}
	
	private void buildParameterMap() 
	{
		commandToParams = new HashMap<>();
		ResourceBundle params = ResourceBundle.getBundle(PARAMETER_FILE);
		Enumeration<String> keys = params.getKeys();
		while(keys.hasMoreElements())
		{
			String key = keys.nextElement();
			String[] classStrings = params.getString(key).split(",");
			Class[] classes = new Class[classStrings.length];
			for (int i = 0; i < classStrings.length; i++)
			{
				System.out.println(classStrings[i]);
				try
				{
					if(classStrings[i].contains("Double") || classStrings[i].contains("Integer"))
					{
						Class primitive = Class.forName(classStrings[i]);
						Field fieldPrimitive = primitive.getDeclaredField("TYPE");
						if(fieldPrimitive != null)
						{
							classes[i] = (Class)fieldPrimitive.get(primitive);
						}
					}
					else
					{
						Class nonPrimitive = Class.forName(classStrings[i]);
						classes[i] = nonPrimitive;
						System.out.println(classes[i].toString());
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			commandToParams.put(key, classes);
		}
	}
	
	
	public static NodeInterface retrieveNode(String commandType, String text)
	{
		Map<String, Class[]> commandToParams = new HashMap<>();
		ResourceBundle params = ResourceBundle.getBundle("parsers/commandToConstructorParameters");
		Enumeration<String> keys = params.getKeys();
		while(keys.hasMoreElements())
		{
			String key = keys.nextElement();
			String[] classStrings = params.getString(key).split(",");
			Class[] classes = new Class[classStrings.length];
			for (int i = 0; i < classStrings.length; i++)
			{
				try
				{
					if(classStrings[i].contains("java.lang"))
					{
						Class primitive = Class.forName(classStrings[i]);
						Field fieldPrimitive = primitive.getDeclaredField("TYPE");
						if(fieldPrimitive != null)
						{
							classes[0] = (Class)fieldPrimitive.get(primitive);
						}
					}
					else
					{
						
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			commandToParams.put(key, classes);
		}
		
		//Object o = makeConstant(text, commandToParams);
		
		//return (NodeInterface) o;
		return null;
	}
	
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
	
	public NodeInterface makeConstant(String type, String text)
	{
		try
		{
			Class<?> clazz = Class.forName("nodes." + type);
			Constructor<?> c = clazz.getConstructor(commandToParams.get("Constant"));
			c.setAccessible(true);
			Object o = c.newInstance(Integer.parseInt(text));
			return (NodeInterface) o;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public NodeInterface makeVariable(String type, String text, VariablesHistory vh)
	{
		try
		{
			Class<?> clazz = Class.forName("nodes." + type);
			Constructor<?> c = clazz.getConstructor(commandToParams.get("Variable"));
			c.setAccessible(true);
			Object o = c.newInstance(text, vh);
			return (NodeInterface) o;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
		
	public static Object makeX(String text)
	{
		Map<String, Class[]> commandToParams = new HashMap<>();
		ResourceBundle params = ResourceBundle.getBundle("parsers/commandToConstructorParameters");
		Enumeration<String> keys = params.getKeys();
		while(keys.hasMoreElements())
		{
			String key = keys.nextElement();
			String[] classes = params.getString(key).split(",");
			//Class[] clazzes = new Class[] {classes};
//			Class[] clazzes = new Class[classes.length];
//			for (int i = 0; i < classes.length; i++)
//			{
//				try {
//					clazzes[i] = Class.forName(classes[i] + ".TYPE");
//					System.out.println(clazzes[i].toString());
//				} catch (ClassNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			commandToParams.put(key, clazzes);	
		}
		try
		{
			//System.out.println("class " + Integer.TYPE.getTypeName());
			System.out.println(Class.forName("java.lang.Double"));
			Class doubleTesting = Class.forName("java.lang.Double");
			Field f = doubleTesting.getDeclaredField("TYPE");
			Class<?> clazz = Class.forName("nodes.Constant");
			Class[] ex = new Class[1];
			ex[0] = (Class)f.get(doubleTesting);
			if(f != null)
			{
				Constructor<?> c = clazz.getConstructor(ex);
				c.setAccessible(true);
				Object o = c.newInstance(Integer.parseInt(text));
				System.out.println(o.toString());
			}
			
			
			//System.out.println(commandToParams.get("Constant").toString());
			//Constructor<?> c = clazz.getConstructor(new Class[] {Class.forName("java.lang.Double")});
			
		}
		catch(Exception e) 
		{
			//CHANGE THIS EXCEPTION
			e.printStackTrace();
		}
		
		return text;
	}
}
