package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Model {
	
	private Color backgroundColor;
	private List<Color> colorOptions;
	private List<Shape> shapeOptions;
	private List<Turtle> activeTurtles;
	private Map<Double,Turtle> allTurtles;
	
	public Model(double width, double height)
	{
		//needs actual colors
		colorOptions = new ArrayList<>();
		colorOptions.add(Color.BLUE);
		colorOptions.add(Color.RED);
		shapeOptions = new ArrayList<>();
		activeTurtles = new ArrayList<>();
		allTurtles = new HashMap<>();
		
		Turtle initial = new Turtle(width, height, Color.BLUE);
		
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

	public void addTurtle(Turtle turt) {
		allTurtles.put((double) allTurtles.size(), turt);
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
	
	public List<Turtle> getActiveTurtles()
	{
		return activeTurtles;
	}
	

}
