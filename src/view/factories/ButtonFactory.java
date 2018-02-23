package view.factories;

import javafx.scene.control.Button;
import view.constants.ButtonConstants;
import view.view_exceptions.BadResourceNameException;

public class ButtonFactory {
	public static final String COMMAND_RUN = "CommandRun";
	public static final String COMMAND_CLEAR = "CommandClear";
	public static final String VARIABLE = "Variable";
	public static final String HISTORY = "History";
	public static Button getButtonOfType(String buttonType){
		switch(buttonType){
			case "CommandRun":
				return getSpecifiedButton(ButtonConstants.COMMAND_RUN_BUTTON_X, ButtonConstants.COMMAND_RUN_BUTTON_Y, ButtonConstants.COMMAND_RUN_BUTTON_LABEL);
			case "CommandClear":
				return getSpecifiedButton(ButtonConstants.COMMAND_CLEAR_BUTTON_X, ButtonConstants.COMMAND_CLEAR_BUTTON_Y, ButtonConstants.COMMAND_CLEAR_BUTTON_LABEL);
			case "Variable":
				return getSpecifiedButton(ButtonConstants.VARIABLE_BUTTON_X, ButtonConstants.VARIABLE_BUTTON_Y, ButtonConstants.VARIABLE_BUTTON_LABEL);
			case "History":
				return getSpecifiedButton(ButtonConstants.HISTORY_BUTTON_X, ButtonConstants.HISTORY_BUTTON_Y, ButtonConstants.HISTORY_BUTTON_LABEL);
			default: throw new BadResourceNameException();
		}
	}
	private static Button getSpecifiedButton(int x, int y, String label){
		Button button = new Button(label);
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
	}
}
