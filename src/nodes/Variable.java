package nodes;

import java.util.List;

import model.VariableHistory;

/**
 * Is the variable node. A variable has a string and value associated with it.
 * A variable needs to access a VariableHistory to stores its value when made
 * and access its value when a variable with a stored name is created.
 *
 * author: Charles Dracos
 */
public class Variable extends VariableI implements NodeI {
	private double value;

	/**
	 * Creates a new Variable with a name and acces to VH
	 * @param name the name of the variable
	 * @param VH VariableHistory of the program
	 */
	public Variable (String name, VariableHistory VH) {
		super(name, VH);
		value = 0.0;
	}

	public double getNewValue() {
		return value; //returns value assigned by the make command
	}
	
	public double getValue() {
		return VH.getValue(name); //gets value from VH associated with name
	}
	
	public void setValue (double value) {
		this.value = value; //sets the value when first made
	}

	/**
	 * sets the value when updated by a loop, updating the VH
	 * @param value new value of the variable to be stored across classes
	 */
	public void setNewValue (double value) {
		this.value = value;
		VH.add(this);
	}

	public String toString() {
		return name;
	}
}
