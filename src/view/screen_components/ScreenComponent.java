package view.screen_components;

import javafx.scene.layout.BorderPane;

public abstract class ScreenComponent {
	private BorderPane borderPane;
	public ScreenComponent(){
		borderPane = new BorderPane();
		generateGUIComponent();
	}
	protected abstract void mapUserActions();
	protected abstract void generateGUIComponent();
	public BorderPane getGUIComponent(){
		mapUserActions();
		return borderPane;
	};
	protected BorderPane getBorderPane(){
		return borderPane;
	}
}
