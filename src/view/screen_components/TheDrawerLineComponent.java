package view.screen_components;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Line;

import java.util.List;

public class TheDrawerLineComponent {
    private Canvas canvas;
    private GraphicsContext gc;
    public TheDrawerLineComponent(Canvas canvas){
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
    }
    public void draw(List<Line> linesToDraw){
        for(Line line : linesToDraw){
            gc.setStroke(line.getStroke());
            System.out.println(line.getStrokeWidth());
            gc.setLineWidth(line.getStrokeWidth());
            gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
        }
    }
}
