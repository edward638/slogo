package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.NoSuchElementException;

import nodes.Variable;
import view.Observer;

public class VariableHistory implements VariableHistoryObservable{
	private HashMap<String, Double> variables;
	private Observer variableHistoryObserver;
	public VariableHistory () {
		variables = new HashMap<String, Double>();
	}

	public void addObserver(Observer variableHistoryObserver){
		this.variableHistoryObserver = variableHistoryObserver;
	}

	public Double getValue (String name) {
		if (variables.get(name)==null) {
			throw new NoSuchElementException("Error: No variable with that name");
		}
		return variables.get(name);
	}
	
	public void add (Variable VN) {
		variables.put(VN.getName(), VN.getNewValue());
		variableHistoryObserver.notifyOfChanges();
	}

	public void clearHistory(){
		variables.clear();
		variableHistoryObserver.notifyOfChanges();
	}

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
