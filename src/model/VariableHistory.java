package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.NoSuchElementException;

import nodes.Variable;
import view.Observer;

/**
 * This stores the variables. Each variable is put into a HashMap mapping its string
 * to its value stored. This allows for other variable objects with the same name
 * to access the values. THere is also a listener implemented which allows the UI to
 * be updated in the variables added and the values being changed.
 *
 * authors: Charles Dracos, Andy Nguyen
 */
public class VariableHistory implements VariableHistoryObservable{
	private HashMap<String, Double> variables;
<<<<<<< HEAD
	private VariableHistoryObserver variableHistoryObserver;

	/**
	 * No parameter constructor, initializes the HashMap
	 */
=======
	private Observer variableHistoryObserver;
>>>>>>> 1cc37e8807c1aa42bda45d0559c40d0cb24bc8f5
	public VariableHistory () {
		variables = new HashMap<String, Double>();
	}

<<<<<<< HEAD
	/**
	 * Adds an observer to the program
	 * @param variableHistoryObserver the observer
	 */
	public void addVariableHistoryObserver(VariableHistoryObserver variableHistoryObserver){
=======
	public void addObserver(Observer variableHistoryObserver){
>>>>>>> 1cc37e8807c1aa42bda45d0559c40d0cb24bc8f5
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
	 * clears the variables in the map and on the screen
	 */
	public void clearHistory(){
		variables.clear();
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
		for (String key: variables.keySet())
		{
			output.add(key + " = " + Double.toString(variables.get(key)));
		}

		return output;
	}
}
