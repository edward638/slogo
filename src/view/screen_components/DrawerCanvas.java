package view.screen_components;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import model.Turtle;
import view.constants.CanvasConstants;

import java.util.List;

public class DrawerCanvas {
    private Canvas canvas;
    private GraphicsContext gc;
    private Image turtleIcon;
    public static final int TURTLE_WIDTH = 50;
    public static final int TURTLE_HEIGHT = 50;
    private String storedColor = "White";

    public DrawerCanvas(BorderPane borderPane){
        canvas = new Canvas(CanvasConstants.CANVAS_WIDTH, CanvasConstants.CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        borderPane.setCenter(canvas);
        turtleIcon = new Image(getClass().getClassLoader().getResourceAsStream("black_and_white_turtle.PNG"));
        setupRectangle(CanvasConstants.DEFAULT_FILL);
    }

    public void setupRectangle(Color color){
        gc.setFill(color);
        gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        gc.setStroke(CanvasConstants.DEFAULT_STROKE);
        gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
    }

    public void update(Turtle turtle){
        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        changeBackgroundColor(storedColor);
        drawLines(turtle.getLines());
        moveTurtle(turtle);
    }

    public void moveTurtle(Turtle turtle){
        gc.save();
        rotate(gc, turtle.getDirectionAngle(), turtle.getXCoordinate(), turtle.getYCoordinate());
        if(turtle.getTurtleShowing()){
            gc.drawImage(turtleIcon, turtle.getXCoordinate() - TURTLE_WIDTH/2, turtle.getYCoordinate() - TURTLE_HEIGHT/2, TURTLE_WIDTH, TURTLE_HEIGHT);
        }
        gc.restore();
    }

    private void drawLines(List<Line> lines){
        for (int x = 0; x < lines.size(); x++){
            Line lineToDraw = lines.get(x);
            gc.setStroke(lines.get(x).getStroke());
            gc.strokeLine(lineToDraw.getStartX(),lineToDraw.getStartY(),lineToDraw.getEndX(), lineToDraw.getEndY());
        }
    }

    public void changeTurtleImage(String imageName){
        turtleIcon = new Image(getClass().getClassLoader().getResourceAsStream(imageName));
    }

    public void changeBackgroundColor(String color){
        storedColor = color;
        if (storedColor.equals("White")){
            setupRectangle(Color.WHITE);
        }
        if (storedColor.equals("Blue")){
            setupRectangle(Color.BLUE);
        }
    }

    // Method taken from https://stackoverflow.com/questions/18260421/how-to-draw-image-rotated-on-javafx-canvas
    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(-angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

}
