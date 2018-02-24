package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.layout.BorderPane;

public abstract class ScreenComponent {
	private ControllerInterface controller;
	private BorderPane borderPane;
	public ScreenComponent(ControllerInterface controller){
		this.controller = controller;
		borderPane = new BorderPane();
		generateGUIComponent();
	}
	protected abstract void mapUserActions();
	protected ControllerInterface getController(){
		return controller;
	}
	protected abstract void generateGUIComponent();
	public BorderPane getGUIComponent(){
		mapUserActions();
		return borderPane;
	};
	protected BorderPane getBorderPane(){
		return borderPane;
	}
}
