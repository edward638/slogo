package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class Drawer extends ScreenComponent{
	private Canvas canvas;
	private GraphicsContext gc;
	private ComboBox colorBox;
	public Drawer(ControllerInterface controller){
		super(controller);
	}
	public BorderPane generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		//TODO: create borderpane layout
		return borderPane;
	}
}
