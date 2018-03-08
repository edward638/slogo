package nodes;

import java.lang.reflect.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import commandNode.MakeUserInstruction;
import model.Model;
import model.Turtle;
import model.VariablesHistory;
import parsers.InvalidEntryException;

public class NodeFactory 
{	
	//private Map<String,Class[]> commandToParams;
	//private static String PARAMETER_FILE = "parsers/commandToConstructorParameters";

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
	
	
//	private void buildParameterMap() 
//	{
//		commandToParams = new HashMap<>();
//		ResourceBundle params = ResourceBundle.getBundle(PARAMETER_FILE);
//		Enumeration<String> keys = params.getKeys();
//		while(keys.hasMoreElements())
//		{
//			String key = keys.nextElement();
//			String[] classStrings = params.getString(key).split(",");
//			Class[] classes = new Class[classStrings.length];
//			for (int i = 0; i < classStrings.length; i++)
//			{
//				System.out.println(classStrings[i]);
//				try
//				{
//					if(classStrings[i].contains("Double") || classStrings[i].contains("Integer"))
//					{
//						Class primitive = Class.forName(classStrings[i]);
//						Field fieldPrimitive = primitive.getDeclaredField("TYPE");
//						if(fieldPrimitive != null)
//						{
//							classes[i] = (Class)fieldPrimitive.get(primitive);
//						}
//					}
//					else
//					{
//						Class nonPrimitive = Class.forName(classStrings[i]);
//						classes[i] = nonPrimitive;
//						System.out.println(classes[i].toString());
//					}
//				}
//				catch(Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//			commandToParams.put(key, classes);
//		}
//	}
//
//	public void makeToken(String type, Object ... args) {
//		// TODO Auto-generated method stub
//		// get list of parameter classes for type
//		// getting the correct constructor for the correct type
//		// make array of type Object of size the same as parameters given to constructor
//		// match using isAssignableFrom the arg.getClass and the constructor class from the file
//		   // fill object array with matched values
//		// create using newInstance and passing array of objects
//		//x = new Object[para]
//				
//				//c.newInstance(x)
//		
//	}
//	public NodeInterface makeConstant(String type, String text)
//	{
//		try
//		{
//			Class<?> clazz = Class.forName("nodes." + type);
//			Constructor<?> c = clazz.getConstructor(commandToParams.get(type));
//			c.setAccessible(true);
//			Object o = c.newInstance(Integer.parseInt(text));
//			return (NodeInterface) o;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public NodeInterface makeVariable(String type, String text, VariablesHistory vh)
//	{
//		try
//		{
//			Class<?> clazz = Class.forName("nodes." + type);
//			Constructor<?> c = clazz.getConstructor(commandToParams.get("Variable"));
//			c.setAccessible(true);
//			Object o = c.newInstance(text, vh);
//			return (NodeInterface) o;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return null;
//	}
}
