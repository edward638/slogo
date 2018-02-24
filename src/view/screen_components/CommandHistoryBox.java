package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CommandHistoryBox extends ControllerHolder{
	private Button historyClearButton;
	private TextArea historyTextArea;
	private Label historyLabel;
	public CommandHistoryBox(ControllerInterface controller){
		super(controller);
	}
}
