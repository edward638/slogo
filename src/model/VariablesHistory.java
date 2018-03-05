package model;

import java.util.*;

import nodes.*;
import view.Observer;

/**
 * This stores the variables. Each variable is put into a HashMap mapping its string
 * to its value stored. This allows for other variable objects with the same name
 * to access the values. THere is also a listener implemented which allows the UI to
 * be updated in the variables added and the values being changed.
 *
 * authors: Charles Dracos, Andy Nguyen
 */
public class VariablesHistory implements VariableHistoryObservable{
	private HashMap<String, Double> variables;
	private HashMap<String, CustomCommand> commands;
	private Observer variableHistoryObserver;

	/**
	 * No parameter constructor, initializes the HashMaps
	 */
	public VariablesHistory() {
		variables = new HashMap<>();
		commands = new HashMap<>();
	}

	/**
	 * Adds an observer to the program
	 * @param variableHistoryObserver the observer
	 */
	public void addObserver(Observer variableHistoryObserver){
		this.variableHistoryObserver = variableHistoryObserver;
	}

	/**
	 * Returns the value of what a string maps to
	 * @param name the name of the variable whose value is accessed
	 * @return the value associated with the name
	 */
	public Double getValue (String name) {
		if (variables.get(name)==null) {
			//throws error that there is no variable with that name to be accessed
			throw new NoSuchElementException("Error: No variable with that name");
		}
		return variables.get(name);
	}

	/**
	 * Adds a new Variable Node to the VH, mapping its string to its value,
	 * updating the UI when a variable is added
	 * @param VN
	 */
	public void add (Variable VN) {
		variables.put(VN.getName(), VN.getNewValue());
		variableHistoryObserver.notifyOfChanges();
	}

	/**
	 * Adds a new custom CustomCommand Node to the commands Map, mapping a name to the object
	 * which then stores the lists values and can evaluate itself
	 * @param CN the command
	 */
	public void add (CustomCommand CN) {
		commands.put(CN.getName(), CN);
		variableHistoryObserver.notifyOfChanges();
	}

	/**
	 * Returns the value done by a custom command by getting the command
	 * object associated with a name
	 * @param name the name of the custom command
	 * @return the value returned from evaluate
	 */
	public CustomCommand getCommand (String name) {
		if (commands.get(name)==null) {
			//throws error that there is no variable with that name to be accessed
			throw new NoSuchElementException("Error: No command with that name");
		}
		return commands.get(name);
	}

	public Set<String> getCommandKeys () {
		return commands.keySet(); //returns all commands
	}

	/**
	 * clears the variables in the map and on the screen
	 */
	public void clearHistory(){
		variables.clear();
		commands.clear();
		variableHistoryObserver.notifyOfChanges();
	}

	/**
	 * Returns the variables' values stores
	 * @return List of doubles of the values stored
	 */
	@Override
	public List<String> getVariables()
	{
		List<String> output = new ArrayList<>();
		output.add("Variables: ");
		for (String key: variables.keySet())
		{
			output.add(key + " = " + Double.toString(variables.get(key)));
		}
		output.add("Commands: ");
		for (String key: commands.keySet())
		{
			output.add(key);
		}

		return output;
	}

	/**
	 * ANDY WANTS THESE PLZ TODO: discuss with group
	 */
	public Map<String,Double> getVariablesAndy() {
		Map<String, Double> shallowCopy = new HashMap<String,Double>();
		shallowCopy.putAll(variables);
		return shallowCopy;
	}
	public void changeValue(String variableName, String value){
		try{
			variables.put(variableName,Double.parseDouble(value));
			variableHistoryObserver.notifyOfChanges();
		}catch(Exception e){
			System.out.println("woops");
		}
	}
}
