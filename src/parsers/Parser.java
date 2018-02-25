package parsers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import nodes.Node;
import nodes.NodeFactory;

/**
 * @author Belanie Nagiel
 * 
 * This class takes in command strings and outputs them as lists of nodes so that the the tree building class 
 * evaluate the command. It also throws errors for incorrect syntax and use of words that are not recognized
 * as commands.
 *
 */
public class Parser 
{
	private Map<String,Pattern> myTranslation;
	
	//possibly change to list because order of checking regex matters
	private Map<String,Pattern> regex;
	private Map<String,Integer> children;
	private String languageFilePath;
	private static final String REGEX_FILE = "parsers/regex";
	private static final String NODE_PACKAGE = "commandNode.";
	private Turtle turt;
	
	/**
	 * Class Constructor
	 * Creates the two hashmaps for the syntax recognition and command recognition
	 * given the current language.
	 * 
	 * @param m the current model
	 * @param language the current language
	 */
	public Parser(Model m, String language)
	{
		regex = new HashMap<>();
		addResources(REGEX_FILE, regex);
		
		languageFilePath = "resources.languages/" + language;
		myTranslation = new HashMap<>();
		addResources(languageFilePath, myTranslation);
		
		children = new HashMap<>();
		ResourceBundle numChildren = ResourceBundle.getBundle("parsers/numChildren");
		Enumeration<String> keys = numChildren.getKeys();
		while(keys.hasMoreElements())
		{
			String key = keys.nextElement();
			children.put(key, Integer.parseInt(numChildren.getString(key)));	
		}
		
		turt = new Turtle(0,0);
	}
	
	/**
	 * Creates a hashmap given a file path to a properties file and a map to fill. Used to 
	 * create key value pairs of syntax to patterns and commands to patterns in the given
	 * language
	 * 
	 * @param filepath
	 * @param map
	 */
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
	
	/**
	 * Creates a list of nodes out of the string command given as an argument
	 * 
	 * @param command The string command from the GUI
	 * @return a list of nodes that the tree builder can use to create the tree
	 */
	public Node[] parseString(String command)
	{
		String[] commandList = command.trim().split("\\s+");
		Node[] nodeList = new Node[commandList.length];
		
		checkSyntax(commandList, nodeList);
		
		return nodeList;
		
	}
	
	/**
	 * fill the nodeList with the appropriate nodes based on matching string input to node types
	 * also checks for syntax errors
	 * 
	 * @param commandList the list of strings given by the user
	 * @param nodeList the empty nodeList that will be filled
	 */
	private void checkSyntax(String[] commandList, Node[] nodeList) 
	{
		//NEED TO PASS IT A TURTLE
		
		
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
						
						try 
						{
							Node n = (Node)NodeFactory.makeNode(Class.forName(NODE_PACKAGE + commandType), turt, children.get(commandType));
							nodeList[i] = n;
							System.out.println(n.getValue());
						}
						catch(Exception e)
						{
							//throw class doesnt exist error
							e.printStackTrace();
						}
						
					}
					else 
					{
						try 
						{
							Node n = (Node)NodeFactory.makeNode(Class.forName(NODE_PACKAGE + key), turt,children.get(key));
							nodeList[i] = n;
							System.out.println(n.getValue());
						}
						catch(Exception e)
						{
							//throw class doesnt exist error
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

	/**
	 * Given a command in any language will return the appropriate command type
	 * Checks for invalid command errors
	 * 
	 * @param command string identified as command syntax in a user input
	 * @return a string indicating the appropriate command typ
	 */
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
}
