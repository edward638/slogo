package model;

import javafx.scene.paint.Color;

public class ColorPalette {
	
	private Color backgroundColor;
	private Color[] colorOptions;
	
	public ColorPalette()
	{
		Color[] example = {Color.RED,Color.BLUE};
		colorOptions = example;
	}
	
	public Color getBackgroundColor() 
	{
		return backgroundColor;
	}
	
	public void setBackgroundColor(Color backgroundColor) 
	{
		this.backgroundColor = backgroundColor;
	}
	
	public Color[] getColorOptions() 
	{
		return colorOptions;
	}
	
	public void setColorOptions(double index, double R, double G, double B) {
		this.colorOptions = colorOptions;
	}
	
	public Color getColorAtIndex(double index)
	{
		//EXCEPTION FOR IF AN INDEX IS OUT OF BOUNDS
		
		return colorOptions[(int) index];
	}
	
	

}
