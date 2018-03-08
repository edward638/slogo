package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.function.Consumer;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import view.Observer;
import view.screen_components.Palette;

public class Model implements ColorIndexObservable{
	
	private Color backgroundColor;
	private List<Color> colorOptions;
	private List<Shape> shapeOptions;
	private List<Turtle> activeTurtles;
	private Map<Double,Turtle> allTurtles;
	private Observer colorIndexObserver;
	
	public Model(double width, double height)
	{
		//needs actual colors
		colorOptions = new ArrayList<>();
		colorOptions.add(Color.RED);
		colorOptions.add(Color.ORANGE);
		colorOptions.add(Color.YELLOW);
		colorOptions.add(Color.GREEN);
		colorOptions.add(Color.BLUE);
		colorOptions.add(Color.INDIGO);
		colorOptions.add(Color.VIOLET);
		shapeOptions = new ArrayList<>();
		activeTurtles = new ArrayList<>();
		allTurtles = new HashMap<>();
		
		Turtle initial = new Turtle(width, height, Color.BLUE, 1.0);
		
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
		allTurtles.put((double) turt.getValue(), turt);
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
		colorOptions.set((int) index, Color.rgb((int) R, (int) G, (int) B));
		colorIndexObserver.notifyOfChanges();
	}
	
	public Color getColorAtIndex(double index)
	{
		//EXCEPTION FOR IF AN INDEX IS OUT OF BOUNDS
		colorIndexObserver.notifyOfChanges();
		return colorOptions.get((int)index);
	}
	
	public List<Turtle> getActiveTurtles()
	{
		return activeTurtles;
	}

	public void update (Consumer<Turtle> T) {
		for (Turtle t: getActiveTurtles()) {
			T.accept(t);
		}
	}


	public void addObserver(Observer colorListObserver) {
		this.colorIndexObserver = colorListObserver;
	}

	@Override
	public List<Color> getColorList() {
		return colorOptions;
	}

	public void initializePalette(){
		colorIndexObserver.notifyOfChanges();
	}


}
