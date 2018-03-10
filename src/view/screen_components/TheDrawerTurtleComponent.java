package view.screen_components;

import controller.DeactivationDelegate;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.StackPane;
import model.TurtleObservable;
import view.Observer;

public class TheDrawerTurtleComponent {
    private static final int TURTLE_WIDTH = 50;
    private static final int TURTLE_HEIGHT = 50;
    private final double X_OFFSET;
    private final double Y_OFFSET;
    private ImageView turtleImage;
    private TurtleObservable turtle;
    private StackPane drawingScreen;

    private TheDrawerLineComponent theDrawerLineComponent;
    private DeactivationDelegate deactivationDelegate;
    private TurtleInformationPanel informationPanel;
    public TheDrawerTurtleComponent(TurtleObservable turtle, StackPane drawingScreen, Canvas lineCanvas){
        this.turtle = turtle;
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

    public void setDeactivationDelegate(DeactivationDelegate deactivationDelegate){
        this.deactivationDelegate = deactivationDelegate;
        System.out.println(deactivationDelegate == null);
        turtleImage.setOnMouseClicked((e)->deactivationDelegate.deactivate(turtle.getID()));
        this.setClickable();
    }

    private void setClickable(){
        informationPanel = new TurtleInformationPanel(turtle);
        turtleImage.setOnMouseEntered(event -> informationPanel.renderInformation());
    }

    private void drawLines(){
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

    public void update(){
        turtleImage.setVisible(turtle.getTurtleShowing());
        this.setTurtleImage();
        turtleImage.setRotate(-turtle.getDirectionAngle());
        this.move();
        this.drawLines();
    }
}
