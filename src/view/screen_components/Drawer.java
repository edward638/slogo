package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;

public class Drawer extends ControllerHolder{
	private Canvas canvas;
	private GraphicsContext gc;
	private ComboBox colorBox;
	public Drawer(ControllerInterface controller){
		super(controller);
	}
}
