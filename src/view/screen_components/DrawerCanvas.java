package view.screen_components;

import controller.DrawerController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import model.Turtle;
import model.TurtleObservable;
import view.constants.CanvasConstants;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.help_items.HelpPopup;
import view.turtle_info.TurtleInformation;

import java.util.List;


public class DrawerCanvas {
    private Canvas canvas;
    private GraphicsContext gc;
    private ImageView turtleIcon;
    public static final int TURTLE_WIDTH = 50;
    public static final int TURTLE_HEIGHT = 50;
    private String storedColor = "White";
    private StackPane stackPane;
    private TurtleObservable turtle;
    private DrawerController controller;


    public DrawerCanvas(BorderPane borderPane, TurtleObservable turtle){
        stackPane = new StackPane();
        this.turtle = turtle;
        canvas = new Canvas(CanvasConstants.CANVAS_WIDTH, CanvasConstants.CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();
        stackPane.getChildren().add(canvas);
        borderPane.setCenter(stackPane);
        setupRectangle(CanvasConstants.DEFAULT_FILL);
        setupTurtleImageView();
    }

    public void setTurtle(TurtleObservable turtle){
        this.turtle = turtle;
    }
    public void setupTurtleImageView(){
        Image turtleIconImage = new Image(getClass().getClassLoader().getResourceAsStream("black_and_white_turtle.PNG"));
        turtleIcon = new ImageView(turtleIconImage);
        turtleIcon.setFitWidth(TURTLE_HEIGHT);
        turtleIcon.setFitHeight(TURTLE_WIDTH);
        turtleIcon.setOnMouseClicked(imageOnMousePressedEventHandler);
        turtleIcon.setOnMouseDragged((MouseEvent mouseEvent) -> {
            StringBuilder temp = new StringBuilder();
            temp.append("setxy ");
            temp.append(Integer.toString((int) mouseEvent.getSceneX() - 410));
            temp.append(" ");
            temp.append(Integer.toString(250 - (int) mouseEvent.getSceneY()));
            turtleIcon.setOnMouseReleased((MouseEvent mouseEvent2) -> {
                controller.passCommand(temp.toString());
            });

        });

    }

    public void setupRectangle(Color color){
        gc.setFill(color);
        gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        gc.setStroke(CanvasConstants.DEFAULT_STROKE);
        gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
    }

    public void update(){
        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        changeBackgroundColor(storedColor);
        drawLines(turtle.getLines());
        moveTurtle();
    }

    public void moveTurtle(){

        stackPane.getChildren().remove(turtleIcon);
        turtleIcon.setTranslateX(turtle.getXCoordinate() - CanvasConstants.CANVAS_WIDTH/2);
        turtleIcon.setTranslateY(turtle.getYCoordinate() - CanvasConstants.CANVAS_HEIGHT/2);
        turtleIcon.setRotate(-turtle.getDirectionAngle());
        stackPane.getChildren().add(turtleIcon);

    }

    private void drawLines(List<Line> lines){
        for (int x = 0; x < lines.size(); x++){
            Line lineToDraw = lines.get(x);
            gc.setStroke(lines.get(x).getStroke());
            gc.strokeLine(lineToDraw.getStartX(),lineToDraw.getStartY(),lineToDraw.getEndX(), lineToDraw.getEndY());
        }
    }

    public void changeTurtleImage(String imageName){
        Image turtleIconImage = new Image(getClass().getClassLoader().getResourceAsStream(imageName));
        turtleIcon.setImage(turtleIconImage);
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


    private EventHandler<MouseEvent> imageOnMousePressedEventHandler = new EventHandler<>(){
        @Override
        public void handle(MouseEvent t){
            TurtleInformation info = new TurtleInformation(turtle);
        }
    };


    public void setController(DrawerController controller) {
        this.controller = controller;
    }
}
