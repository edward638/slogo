package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.function.Consumer;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Model {
	
	private Color backgroundColor;
	private List<Color> colorOptions;
	private List<Shape> shapeOptions;
	private List<Turtle> activeTurtles;
	private Map<Double,Turtle> allTurtles;

	private static double XHome;
	private static double YHome;

	private int currentTurtle = 0;
	
	public Model(double width, double height)
	{
		//needs actual colors
		colorOptions = new ArrayList<>();
		colorOptions.add(Color.BLUE);
		colorOptions.add(Color.RED);
		shapeOptions = new ArrayList<>();
		activeTurtles = new ArrayList<>();
		allTurtles = new HashMap<>();
		XHome = width;
		YHome = height;
		Turtle initial = new Turtle(XHome, YHome, Color.BLUE, 1.0);
		
		allTurtles.put(1.0, initial);
		activeTurtles.add(initial);
		
	}
	
	public List<Shape> getShapeOptions() 
	{
		return shapeOptions;
	}

	public Map<Double, Turtle> getAllTurtles() 
	{
		return allTurtles;
	}

	public void addTurtle(double ID) {
		Turtle t = new Turtle (XHome, YHome, Color.BLUE, ID);
		allTurtles.put((double) t.getValue(), t);
		activeTurtles.add(t);
	}
	
	public void addActiveTurtle(Turtle turt) {
		activeTurtles.add(turt);
	}

	public Color getBackgroundColor() 
	{
		return backgroundColor;
	}
	
	public void setBackgroundColor(double index) 
	{
		this.backgroundColor = colorOptions.get((int) index);
	}
	
	public List<Color> getColorOptions() 
	{
		return colorOptions;
	}
	
	public void setColorOptions(double index, double R, double G, double B) {
		//EXCEPTION FOR IF R,G,B ARE OUT OF BOUNDS
		
		this.colorOptions = colorOptions;
	}
	
	public Color getColorAtIndex(double index)
	{
		//EXCEPTION FOR IF AN INDEX IS OUT OF BOUNDS
		
		return colorOptions.get((int)index);
	}

	public Turtle getActiveTurtle() { return activeTurtles.get(currentTurtle); }
	
	public List<Turtle> getActiveTurtles()
	{
		return activeTurtles;
	}

	public void setActiveTurtles(List<Turtle> newActives) {
		activeTurtles = newActives;
	}

	public void update (Consumer<Turtle> T) {
		for (Turtle t: getActiveTurtles()) {
			T.accept(t);
			currentTurtle++;
		}
		currentTurtle = 0;
	}
	

}
