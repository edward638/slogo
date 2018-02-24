package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CommandBox extends ControllerHolder{
	private Button commandClearButton;
    private Button commandRunButton;
    private Button commandHelpButton;
    private TextArea commandTextArea;
    private Label commandLabel;
    private ComboBox languageBox;
	public CommandBox(ControllerInterface controller) {
		super(controller);
	}
	
}
