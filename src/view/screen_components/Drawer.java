package view.screen_components;

import controller.ControllerInterface;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import model.TurtleObservable;
import view.Observer;
import view.constants.CanvasConstants;
import view.constants.ComboBoxConstants;

import javafx.scene.shape.Line;
import java.util.List;

public class Drawer extends ScreenComponent implements Observer{
	public static final double TURTLE_START_X = CanvasConstants.CANVAS_WIDTH/2;
	public static final double TURTLE_START_Y = CanvasConstants.CANVAS_HEIGHT/2;
	public static final int TURTLE_WIDTH = 50;
	public static final int TURTLE_HEIGHT = 50;

	//other turtle images taken from:
	// https://pixabay.com/en/turtle-animal-reptile-water-green-294522/
	// https://pixabay.com/en/sea-turtle-floral-flowers-2952470/

	private Image turtleIcon;
	private Canvas canvas;
	private GraphicsContext gc;
	private ComboBox<String> backgroundColorBox;
	private ComboBox<String> penColorBox;
	private ComboBox<String> turtleImageBox;
	private TurtleObservable turtle;
	public Drawer(ControllerInterface controller){
		super(controller);
	}

	public void setTurtle(TurtleObservable turtle){
		this.turtle = turtle;
	}

	@Override
	protected void mapUserActions() {
		backgroundColorBox.valueProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				update();
			}
		});
		turtleImageBox.valueProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				changeTurtleImage();
			}
		});
		penColorBox.valueProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				changePenColor();
			}
		});
	}

	public void generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		borderPane.setPadding(new Insets(10,20,10,20));
		generateCanvas(borderPane);
		generateBorderPaneBottom(borderPane);
	}

	private void generateCanvas(BorderPane borderPane){
		canvas = new Canvas(CanvasConstants.CANVAS_WIDTH, CanvasConstants.CANVAS_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(CanvasConstants.DEFAULT_FILL);
		gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
		gc.setStroke(CanvasConstants.DEFAULT_STROKE);
		gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
		turtleIcon = new Image(getClass().getClassLoader().getResourceAsStream("black_and_white_turtle.PNG"));
		gc.drawImage(turtleIcon, TURTLE_START_X - TURTLE_WIDTH/2, TURTLE_START_Y - TURTLE_HEIGHT/2, TURTLE_WIDTH, TURTLE_HEIGHT);
		borderPane.setCenter(canvas);
	}

	private void generateBorderPaneBottom(BorderPane borderPane){
		HBox hbox = new HBox();
		backgroundColorBox = new ComboBox<>();
		penColorBox = new ComboBox<>();
		turtleImageBox = new ComboBox<>();
		addComboBoxOptions(hbox, backgroundColorBox, ComboBoxConstants.BACKGROUND_COLOR_LIST);
		addComboBoxOptions(hbox, penColorBox, ComboBoxConstants.PEN_COLOR_LIST);
		addComboBoxOptions(hbox, turtleImageBox, ComboBoxConstants.TURTLE_IMAGE_LIST);
		borderPane.setBottom(hbox);
	}

	private void addComboBoxOptions(HBox hbox, ComboBox<String> comboBox, String[] options){
		for (int x = 0 ; x < options.length; x++) {
			comboBox.getItems().add(options[x]);
		}
		comboBox.getSelectionModel().selectFirst();
		hbox.getChildren().add(comboBox);
	}

	private void changeBackgroundColor(){
		String color = (String) backgroundColorBox.getValue();
		if (color.equals("White")){
			gc.setFill(Color.WHITE);
			gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
			gc.setStroke(CanvasConstants.DEFAULT_STROKE);
			gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
		}
		if (color.equals("Blue")){
			gc.setFill(Color.BLUE);
			gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
			gc.setStroke(CanvasConstants.DEFAULT_STROKE);
			gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
		}
	}

	private void changePenColor(){
		String color = (String) penColorBox.getValue();
		Color penColor = null;
		if (color.equals("Red")) {
			penColor = Color.RED;
		}
		if (color.equals("Green")){
			penColor = Color.GREEN;
		}
		if(color.equals("Black")){
			penColor = Color.BLACK;
		}
		super.getController().setPenColor(penColor);
	}

	private void changeTurtleImage(){
		String imageName = (String) turtleImageBox.getValue();
		turtleIcon = new Image(getClass().getClassLoader().getResourceAsStream(imageName));
		//TODO: make this more elegant
		update();
	}

	private void drawLines(List<Line> lines){
		for (int x = 0; x < lines.size(); x++){
			Line lineToDraw = lines.get(x);
			gc.setStroke(lines.get(x).getStroke());
			gc.strokeLine(lineToDraw.getStartX(),lineToDraw.getStartY(),lineToDraw.getEndX(), lineToDraw.getEndY());
		}
	}

	public void update(){
		gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
		changeBackgroundColor();
		drawLines(turtle.getLines());
		moveTurtle();
	}


	public void moveTurtle(){
		gc.save();
		rotate(gc, turtle.getDirectionAngle(), turtle.getXCoordinate(), turtle.getYCoordinate());
		if(turtle.getTurtleShowing()){
			gc.drawImage(turtleIcon, turtle.getXCoordinate() - TURTLE_WIDTH/2, turtle.getYCoordinate() - TURTLE_HEIGHT/2, TURTLE_WIDTH, TURTLE_HEIGHT);
		}
		gc.restore();
	}

// Method taken from https://stackoverflow.com/questions/18260421/how-to-draw-image-rotated-on-javafx-canvas
	private void rotate(GraphicsContext gc, double angle, double px, double py) {
		Rotate r = new Rotate(-angle, px, py);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}

	@Override
	public void notifyOfChanges() {
		update();
	}
}
