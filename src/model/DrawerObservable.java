package model;

import javafx.scene.paint.Color;

import java.util.List;

public interface DrawerObservable {
    Color getBackgroundColor();
    List<TurtleObservable> getTurtleObservables();
}
