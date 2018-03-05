package model;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Line;

public class HandleWraparound {
	
	private double screenWidth;
	private double screenHeight;
	private List<Line> lines;
	
	public HandleWraparound (double width, double height)
	{
		screenWidth = width;
		screenHeight = height;
		lines = new ArrayList<Line>();
	}

	public List<Line> drawLine(double currentX, double currentY, double futureX, double futureY) 
	{
		Line remainingLineToDraw = new Line(currentX, currentY, futureX, futureY);
		Line oldLine;
		do{
			oldLine = remainingLineToDraw;
			remainingLineToDraw = handleAllWraparound(remainingLineToDraw);
		}while(!linesAreEqual(oldLine, remainingLineToDraw));
		return lines;
	}
	
	private boolean linesAreEqual(Line oldLine, Line newLine){
		return oldLine.getStartX() == newLine.getStartX() &&
				oldLine.getStartY() == newLine.getStartY() &&
				oldLine.getEndY() == newLine.getEndY() &&
				oldLine.getEndX() == newLine.getEndX();
	}
	
	private Line handleAllWraparound(Line lineToDraw){
		Line2D.Double topLine = new Line2D.Double(0,0,screenWidth,0);
		Line2D.Double rightLine = new Line2D.Double(screenWidth,0,screenWidth,screenHeight);
		Line2D.Double bottomLine = new Line2D.Double(screenWidth,screenHeight,0,screenHeight);
		Line2D.Double leftLine = new Line2D.Double(0,screenHeight,0,0);
		if (lineToDraw.getStartX() != screenWidth && linesIntersect(rightLine, lineToDraw)){
			return handleRightHandWraparound(lineToDraw);
		}else if (lineToDraw.getStartX() != 0 && linesIntersect(leftLine, lineToDraw)){
			return handleLeftHandWraparound(lineToDraw);
		}else if (lineToDraw.getStartY() != screenHeight && linesIntersect(bottomLine, lineToDraw)){
			return handleBottomWraparound(lineToDraw);
		}else if (lineToDraw.getStartY() != 0 && linesIntersect(topLine, lineToDraw)){
			return handleTopWraparound(lineToDraw);
		}else{
			lines.add(lineToDraw);
			return lineToDraw;
		}
	}

	private boolean linesIntersect(Line2D.Double borderLine, Line lineToDraw){
		return borderLine.intersectsLine(lineToDraw.getStartX(), lineToDraw.getStartY(), lineToDraw.getEndX(), lineToDraw.getEndY());
	}

	/*
	 * adds the appropriate line to lines and then returns the starting point and ending point of the next line
	 */
	private Line handleLeftHandWraparound(Line line){
		double slope = (line.getEndY() - line.getStartY())/(line.getEndX() - line.getStartX());
		double newX = 0;
		double newY = -slope*line.getStartX() + line.getStartY(); // check this
		Line toDraw = new Line(line.getStartX(), line.getStartY(), newX, newY);
		lines.add(toDraw);
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
		lines.add(toDraw);
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
		lines.add(toDraw);
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
		lines.add(toDraw);
		return new Line(newX,0,line.getEndX(),line.getEndY() - screenHeight);
	}
	

}
