package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class VariableHistoryBox extends ControllerHolder{
	private TextArea variableTextArea;
	private Button variableClearButton;
	private Label variableLabel;
	public VariableHistoryBox(ControllerInterface controller){
		super(controller);
	}
}
