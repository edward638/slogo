package parsers;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Parser 
{
	private Map<String,Pattern> myTranslation;
	private Map<String,Pattern> regex;
	private String languageFilePath;
	private static final String REGEX_FILE = "parsers/regex";
	
	public Parser(Model m, String language)
	{
		regex = new HashMap<>();
		addResources(REGEX_FILE, regex);
		
//		languageFilePath = "parsers/" + language;
//		myTranslation = new HashMap<>();
//		addResources(languageFilePath, myTranslation);
		
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
		for(String k: map.keySet())
		{
			System.out.println(k);
			System.out.println(map.get(k));
		}
	}
	
	public void parseString(String command)
	{
		String[] commandList = command.trim().split("\\s+");
		String[] test = new String[commandList.length];
		
		for (int i = 0; i<commandList.length; i++)
		{
			String text = commandList[i];
			
			for (String key: regex.keySet())
			{
				if(regex.get(key).matcher(text).matches())
				{
					test[0] = "matched" + key;
					System.out.println(text);
					System.out.println(test[0]);
				}
			}
		}
		
	}
	
	

}
