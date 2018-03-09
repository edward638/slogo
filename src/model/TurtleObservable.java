package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.Observer;

import java.util.List;

public interface TurtleObservable {
    void addObserver(Observer observer);
    public double getXCoordinate();
    public double getYCoordinate();
    public double getDirectionAngle();
    public List<Line> getLines();
    public boolean getTurtleShowing();
    String getTurtleShape();
}
