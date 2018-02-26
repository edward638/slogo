package model;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
	private List<String> commands;
	private int index;
	
	public CommandHistory() {
		commands = new ArrayList<String>();
		index = 0;
	}
	
	public String getCommand () {
		return commands.get(index);
	}
	
	public void addCommand (String command) {
		commands.add(command);
		index++;
	}
	
	public List<String> getCommands(){
		return commands;
	}
	
	public void clearHistory(){
		commands.clear();
	}
}
