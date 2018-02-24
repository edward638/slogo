package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class CommandHistoryBox extends ScreenComponent{
	private Button historyClearButton;
	private TextArea historyTextArea;
	private Label historyLabel;
	public CommandHistoryBox(ControllerInterface controller){
		super(controller);
	}
	public BorderPane generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		//TODO: create borderpane layout
		return borderPane;
	}
}
