package model;

import java.util.ArrayList;

public class CommandHistory {
	private ArrayList<String> commands;
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
}
