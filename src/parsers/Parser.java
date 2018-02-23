package parsers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import nodes.Node;
import nodes.NodeFactory;

public class Parser 
{
	private Map<String,Pattern> myTranslation;
	
	//possibly change to list because order of checking regex matters
	private Map<String,Pattern> regex;
	private String languageFilePath;
	private static final String REGEX_FILE = "parsers/regex";
	private static final String NODE_PACKAGE = "nodes.";
	
	public Parser(Model m, String language)
	{
		regex = new HashMap<>();
		addResources(REGEX_FILE, regex);
		
		languageFilePath = "parsers/" + language;
		myTranslation = new HashMap<>();
		addResources(languageFilePath, myTranslation);
		
	}
	
	public void addResources(String filepath, Map<String,Pattern> map)
	{
		ResourceBundle language = ResourceBundle.getBundle(filepath);
		Enumeration<String> keys = language.getKeys();
		while(keys.hasMoreElements())
		{
			String key = keys.nextElement();
			map.put(key, Pattern.compile(language.getString(key), Pattern.CASE_INSENSITIVE));	
		}
	}
	
	public void parseString(String command)
	{
		String[] commandList = command.trim().split("\\s+");
		Node[] test = new Node[commandList.length];
		
		//have check syntax return list of nodes
		checkSyntax(commandList, test);
		
		
	}

	private String checkLanguage(String command) 
	{
		String x = "?";
		for (String key: myTranslation.keySet())
		{
			//check if it is a command
			if(myTranslation.get(key).matcher(command).matches())
			{
				return key;
			}
		}
		//throw error if it didnt match a specific command
		return x;
	}

	private void checkSyntax(String[] commandList, Node[] test) 
	{
		for (int i = 0; i<commandList.length; i++)
		{
			String text = commandList[i];
			
			boolean match = false;
			for (String key: regex.keySet())
			{
				if(regex.get(key).matcher(text).matches())
				{
					match = true;
					if (key.equals("Command"))
					{
						String commandType = checkLanguage(text);
						System.out.println(commandType);
						try {
							Node n = (Node)NodeFactory.makeNode(Class.forName("nodes.Sum"));
							test[i] = n;
							System.out.println(n.getValue());
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
					}
					else 
					{
						try 
						{
							Node n = (Node)NodeFactory.makeNode(Class.forName("nodes.Sum"));
							System.out.println(n.getValue());
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			}
			if(!match)
			{
//				throw exception for invalid entry
				System.out.println(text);
//				System.out.println("no match");
			}
		}
		
	}	

}
