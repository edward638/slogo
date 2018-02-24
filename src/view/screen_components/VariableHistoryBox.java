package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class VariableHistoryBox extends ScreenComponent{
	private TextArea variableTextArea;
	private Button variableClearButton;
	private Label variableLabel;
	public VariableHistoryBox(ControllerInterface controller){
		super(controller);
	}
	public BorderPane generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		//TODO: create borderpane layout
		return borderPane;
	}
}
