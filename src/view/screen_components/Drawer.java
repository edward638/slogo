package view.screen_components;

import controller.ControllerInterface;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import view.constants.ComboBoxConstants;

public class Drawer extends ScreenComponent{
	public static final int CANVAS_WIDTH = 450;
	public static final int CANVAS_HEIGHT = 450;
	public static final Color DEFAULT_FILL = Color.WHITE;
	public static final Color DEFAULT_STROKE = Color.BLACK;
	private Canvas canvas;
	private GraphicsContext gc;
	private ComboBox backgroundColorBox;
	public Drawer(ControllerInterface controller){
		super(controller);
	}
	public BorderPane generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		borderPane.setPadding(new Insets(10,20,10,20));
		//TODO: create borderpane layout
		generateCanvas(borderPane);
		generateBackgroundColorBox(borderPane);
		return borderPane;
	}

	private void generateCanvas(BorderPane borderPane){
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(DEFAULT_FILL);
		gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
		gc.strokeRect(0,0, canvas.getWidth(),canvas.getHeight());
		borderPane.setCenter(canvas);
	}

	private void generateBackgroundColorBox(BorderPane borderPane){
		backgroundColorBox = new ComboBox();
		String[] choices = ComboBoxConstants.COLOR_LIST;
		for (int x = 0 ; x < choices.length; x++) {
			backgroundColorBox.getItems().add(choices[x]);
		}
		backgroundColorBox.getSelectionModel().selectFirst();
		borderPane.setBottom(backgroundColorBox);
	}

}
