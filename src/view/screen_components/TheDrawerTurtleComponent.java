package view.screen_components;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.TurtleObservable;
import view.Observer;

public class TheDrawerTurtleComponent implements Observer {
    private static final int TURTLE_WIDTH = 50;
    private static final int TURTLE_HEIGHT = 50;
    private final double X_OFFSET;
    private final double Y_OFFSET;
    private ImageView turtleImage;
    private TurtleObservable turtle;
    private StackPane drawingScreen;
    private TheDrawerLineComponent theDrawerLineComponent;
    public TheDrawerTurtleComponent(TurtleObservable turtle, StackPane drawingScreen, Canvas lineCanvas){
        this.turtle = turtle;
        turtle.addObserver(this);
        this.drawingScreen = drawingScreen;
        this.theDrawerLineComponent = new TheDrawerLineComponent(lineCanvas);
        X_OFFSET = lineCanvas.getWidth()/2;
        Y_OFFSET = lineCanvas.getHeight()/2;
        turtleImage = new ImageView();
        turtleImage.setFitWidth(TURTLE_WIDTH);
        turtleImage.setFitHeight(TURTLE_HEIGHT);
        this.setTurtleImage();
        drawingScreen.getChildren().add(turtleImage);
        this.update();
    }

    private void drawLines(){
        if(turtle.getLines().isEmpty()){
            theDrawerLineComponent.clearCanvas();
        }
        theDrawerLineComponent.draw(turtle.getLines());
    }

    private void setTurtleImage(){
        turtleImage.setImage(new Image(getClass().getClassLoader().getResourceAsStream(turtle.getTurtleShape())));
    }

    private void move(){
        drawingScreen.getChildren().remove(turtleImage);
        turtleImage.setTranslateX(turtle.getXCoordinate() - X_OFFSET);
        turtleImage.setTranslateY(turtle.getYCoordinate() - Y_OFFSET);
        drawingScreen.getChildren().add(turtleImage);
    }

    private void update(){
        if(!turtle.getTurtleShowing()) turtleImage.setVisible(false);
        this.setTurtleImage();
        turtleImage.setRotate(-turtle.getDirectionAngle());
        this.move();
        this.drawLines();
    }


    @Override
    public void notifyOfChanges() {
        update();
    }
}
