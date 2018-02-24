package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.layout.BorderPane;

public abstract class ScreenComponent {
	private ControllerInterface controller;
	private BorderPane borderPane;
	public ScreenComponent(ControllerInterface controller){
		this.controller = controller;
		borderPane = new BorderPane();
		
	}
	protected ControllerInterface getController(){
		return controller;
	}
	public abstract BorderPane generateGUIComponent();
	protected BorderPane getBorderPane(){
		return borderPane;
	}
}
