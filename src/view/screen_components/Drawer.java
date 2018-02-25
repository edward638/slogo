package view.screen_components;

import controller.ControllerInterface;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import view.constants.CanvasConstants;
import view.constants.ComboBoxConstants;

public class Drawer extends ScreenComponent{
	private Canvas canvas;
	private GraphicsContext gc;
	private ComboBox<String> backgroundColorBox;
	public Drawer(ControllerInterface controller){
		super(controller);
	}

	@Override
	protected void mapUserActions() {
		backgroundColorBox.valueProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				changeColor();
			}
		});
	}

	public void generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		borderPane.setPadding(new Insets(10,20,10,20));
		generateCanvas(borderPane);
		generateBackgroundColorBox(borderPane);
	}

	private void generateCanvas(BorderPane borderPane){
		canvas = new Canvas(CanvasConstants.CANVAS_WIDTH, CanvasConstants.CANVAS_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(CanvasConstants.DEFAULT_FILL);
		gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
		gc.setStroke(CanvasConstants.DEFAULT_STROKE);
		gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
		borderPane.setCenter(canvas);
	}

	private void generateBackgroundColorBox(BorderPane borderPane){
		backgroundColorBox = new ComboBox<>();
		String[] choices = ComboBoxConstants.COLOR_LIST;
		for (int x = 0 ; x < choices.length; x++) {
			backgroundColorBox.getItems().add(choices[x]);
		}
		backgroundColorBox.getSelectionModel().selectFirst();
		borderPane.setBottom(backgroundColorBox);
	}

	private void changeColor(){
		String color = (String) backgroundColorBox.getValue();
		if (color.equals("White")){
			gc.setFill(Color.WHITE);
			gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
			gc.setStroke(CanvasConstants.DEFAULT_STROKE);
			gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
		}
		if (color.equals("Black")){
			gc.setFill(Color.BLACK);
			gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
			gc.setStroke(CanvasConstants.DEFAULT_STROKE);
			gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
		}
	}
}
