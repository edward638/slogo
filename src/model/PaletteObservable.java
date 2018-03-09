package model;

import javafx.scene.paint.Color;

import java.util.List;

public interface PaletteObservable {
    public Color getBackgroundColor();
    List<Color> getColorList();
    List<String> getShapeOptions();
}
