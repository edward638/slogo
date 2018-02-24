package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import view.constants.ButtonConstants;
import view.constants.ComboBoxConstants;
import view.constants.TextAreaConstants;

public class CommandBox extends ScreenComponent{
	public static final int ITEM_WIDTH = 50;
	private Button commandClearButton;
    private Button commandRunButton;
    private Button commandHelpButton;
    private TextArea commandTextArea;
    private Label commandLabel;
    private ComboBox languageBox;
	public CommandBox(ControllerInterface controller) {
		super(controller);
	}

	@Override
	protected void mapUserActions() {
		commandClearButton.setOnAction((event -> {
			commandTextArea.clear();
		}));
	}

	public void generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		borderPane.setRight(this.getRightComponent());
		borderPane.setCenter(this.getConsoleWindow());
	}
	
	private TextArea getConsoleWindow(){
		commandTextArea = new TextArea();
		commandTextArea.setPrefRowCount(TextAreaConstants.COMMAND_ROWS);
		commandTextArea.setPrefColumnCount(TextAreaConstants.COMMAND_COLUMNS);
		return commandTextArea;
	}
	private VBox getRightComponent(){
		VBox rightComponent = new VBox();
		commandRunButton = new Button(ButtonConstants.COMMAND_RUN_BUTTON_LABEL);
		commandClearButton = new Button(ButtonConstants.COMMAND_CLEAR_BUTTON_LABEL);
		commandHelpButton = new Button(ButtonConstants.COMMAND_HELP_BUTTON_LABEL);
		languageBox = this.getLanguageBox();
		commandRunButton.setMinWidth(ITEM_WIDTH);
		commandClearButton.setMinWidth(ITEM_WIDTH);
		commandHelpButton.setMinWidth(ITEM_WIDTH);
		languageBox.setMinWidth(ITEM_WIDTH);
		rightComponent.getChildren().add(commandRunButton);
		rightComponent.getChildren().add(commandClearButton);
		rightComponent.getChildren().add(commandHelpButton);
		rightComponent.getChildren().add(languageBox);
		return rightComponent;
	}
	private ComboBox getLanguageBox(){
		ComboBox languageBox = new ComboBox();
		String[] options = ComboBoxConstants.LANGUAGE_LIST;
		for (int i = 0 ; i < options.length; i++) {
            languageBox.getItems().add(options[i]);
            languageBox.getSelectionModel().selectFirst();
        }
		return languageBox;
	}
}
