package parsers;

import java.util.ArrayList;
import java.util.List;


public class Turtle 
{
	private double XCoordinate;
	private double YCoordinate;
	private double[] home = new double[2];
	private double directionAngle;
	private List<String> lines;
	private boolean penShowing;
	private boolean turtleShowing;
	
	
	public Turtle(double xHome, double yHome)
	{
		XCoordinate = xHome;
		YCoordinate = yHome;
		home[0] = xHome;
		home[1] = yHome; 
		directionAngle = 90;
		penShowing = true;
		turtleShowing = true;
		lines = new ArrayList<>();
	}


	public double getXCoordinate() {
		return XCoordinate;
	}
	
	public double getYCoordinate() {
		return YCoordinate;
	}


	public void setCoordinates(double xCoordinate, double yCoordinate) {
		XCoordinate = xCoordinate;
		YCoordinate = yCoordinate;
		addLine("Insert new line here");
	}

	public double getDirectionAngle() {
		return directionAngle;
	}


	public void setDirectionAngle(double directionAngle) {
		this.directionAngle = directionAngle;
	}


	public List<String> getLines() {
		return lines;
	}


	public void addLine(String line) {
		lines.add(line);
	}


	public boolean getPenShowing() {
		return penShowing;
	}


	public void setPenShowing(boolean penShowing) {
		this.penShowing = penShowing;
	}


	public boolean getTurtleShowing() {
		return turtleShowing;
	}


	public void setTurtleShowing(boolean turtleShowing) {
		this.turtleShowing = turtleShowing;
	}

}
