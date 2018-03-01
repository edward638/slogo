package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.Observer;



public class Turtle implements TurtleObservable
{
	private double XCoordinate;
	private double YCoordinate;
	private double[] home = new double[2];
	private double directionAngle;
	private List<Line> lines;
	private boolean penShowing;
	private boolean turtleShowing;
	private Color penColor;
	private double screenWidth;
	private double screenHeight;
	
	//THIS IS ANDY'S SUGGESTION
	private Observer turtleObserver;

	//Could pass pen color in parameter! Right now we call setPenColor in controller. TODO: Discuss this idea, Also screen size in constructor?
	public Turtle(double width, double height, Color color)
	{
		screenWidth = width;
		screenHeight = height;
		XCoordinate = width/2;
		YCoordinate = height/2;
		home[0] = width/2;
		home[1] = height/2; 
		directionAngle = 90;
		penShowing = true;
		turtleShowing = true;
		lines = new ArrayList<Line>();
		penColor = color;
	}

	public void addObserver(Observer turtleObserver){
		this.turtleObserver = turtleObserver;
	}

	public double getXCoordinate() {
		return XCoordinate;
	}
	
	public double getYCoordinate() {
		return YCoordinate;
	}

	public void setCoordinates(double futureX, double futureY) {
		double currentX = XCoordinate;
		double currentY = YCoordinate;
		Line remainingLineToDraw = new Line(currentX, currentY, futureX, futureY);
		Line oldLine;
		do{
			oldLine = remainingLineToDraw;
			remainingLineToDraw = handleWraparound(remainingLineToDraw);
			XCoordinate = remainingLineToDraw.getEndX();
			YCoordinate = remainingLineToDraw.getEndY();
		}while(!linesAreEqual(oldLine, remainingLineToDraw));
		turtleObserver.notifyOfChanges();
	}

	private boolean linesAreEqual(Line oldLine, Line newLine){
		return oldLine.getStartX() == newLine.getStartX() &&
				oldLine.getStartY() == newLine.getStartY() &&
				oldLine.getEndY() == newLine.getEndY() &&
				oldLine.getEndX() == newLine.getEndX();
	}
	
	public double[] getHome(){
		return home;
	}

	public double getDirectionAngle() {
		//System.out.println(directionAngle);
		return directionAngle;
	}


	public void setDirectionAngle(double directionAngle) {
		this.directionAngle = directionAngle;
		turtleObserver.notifyOfChanges();
	}


	public List<Line> getLines() {
		return lines;
	}


	private void addLine(Line line) {
		if(penShowing){
			line.setStroke(penColor);
			lines.add(line);
		}
	}
	
	public void clearLines()
	{
		lines = new ArrayList<Line>();
		turtleObserver.notifyOfChanges();
	}


	public boolean getPenShowing() {
		return penShowing;
	}


	public void setPenShowing(boolean penShowing) {
		this.penShowing = penShowing;
		turtleObserver.notifyOfChanges();
	}

	public boolean getTurtleShowing() {
		return turtleShowing;
	}

	public void setPenColor(Color penColor) {
		this.penColor = penColor;
	}


	public void setTurtleShowing(boolean turtleShowing) {
		this.turtleShowing = turtleShowing;
		turtleObserver.notifyOfChanges();
	}

	private Line handleWraparound(Line lineToDraw){
		if (lineToDraw.getEndX() > screenWidth){
			return handleRightHandWraparound(lineToDraw);
		}else if (lineToDraw.getEndX() < 0){
			return handleLeftHandWraparound(lineToDraw);
		}else if (lineToDraw.getEndY() > screenHeight){
			return handleBottomWraparound(lineToDraw);
		}else if (lineToDraw.getEndY() < 0){
			return handleTopWraparound(lineToDraw);
		}else{
			this.addLine(lineToDraw);
			return lineToDraw;
		}
	}

	/*
	 * adds the appropriate line to lines and then returns the starting point and ending point of the next line
	 */
	private Line handleLeftHandWraparound(Line line){
		double slope = (line.getEndY() - line.getStartY())/(line.getEndX() - line.getStartX());
		double newX = 0;
		double newY = -slope*line.getStartX() + line.getStartY(); // check this
		Line toDraw = new Line(line.getStartX(), line.getStartY(), newX, newY);
		addLine(toDraw);
		return new Line(screenWidth,newY,line.getEndX() + screenWidth,line.getEndY());

	}

	/*
	 * adds the appropriate line to lines and then returns the starting point and ending point of the next line
	 */
	private Line handleRightHandWraparound(Line line){
		double slope = (line.getEndY() - line.getStartY())/(line.getEndX() - line.getStartX());
		double newX = screenWidth;
		double newY = slope*newX -slope*line.getStartX() + line.getStartY(); // check this
		Line toDraw = new Line(line.getStartX(), line.getStartY(), newX, newY);
		addLine(toDraw);
		return new Line(0,newY,line.getEndX() - screenWidth,line.getEndY());
	}

	/*
	 * adds the appropriate line to lines and then returns the starting point and ending point of the next line
	 */
	private Line handleTopWraparound(Line line){
		double slope = (line.getEndY() - line.getStartY())/(line.getEndX() - line.getStartX());
		double newY = 0;
		double newX = line.getStartX() - (line.getStartY() - newY) / slope;
		Line toDraw = new Line(line.getStartX(), line.getStartY(), newX, newY);
		addLine(toDraw);
		return new Line(newX,screenHeight,line.getEndX(),line.getEndY() + screenHeight);
	}

	/*
	 * adds the appropriate line to lines and then returns the starting point and ending point of the next line
	 */
	private Line handleBottomWraparound(Line line){
		double slope = (line.getEndY() - line.getStartY())/(line.getEndX() - line.getStartX());
		double newY = screenHeight;
		double newX = line.getStartX() - (line.getStartY() - newY) / slope;
		Line toDraw = new Line(line.getStartX(), line.getStartY(), newX, newY);
		addLine(toDraw);
		return new Line(newX,0,line.getEndX(),line.getEndY() - screenHeight);
	}

}
