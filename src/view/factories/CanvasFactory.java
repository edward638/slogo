package view.factories;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class CanvasFactory {
	public static final int CANVAS_X = 50;
    public static final int CANVAS_Y = 50;
    public static final int CANVAS_WIDTH = 450;
    public static final int CANVAS_HEIGHT = 450;
    public static final Color DEFAULT_FILL = Color.WHITE;
    public static final Color DEFAULT_STROKE = Color.BLACK;
    
	public static Canvas generateCanvas(){
		Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setLayoutX(CANVAS_X);
        canvas.setLayoutY(CANVAS_Y);
        canvas.getGraphicsContext2D().setFill(DEFAULT_FILL);
        canvas.getGraphicsContext2D().fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        canvas.getGraphicsContext2D().setStroke(DEFAULT_STROKE);
        canvas.getGraphicsContext2D().strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
        return canvas;
	}
	
}
