package view.factories;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import view.constants.LabelConstants;
import view.view_exceptions.BadResourceNameException;

public class LabelFactory {
	public static final String COMMAND = "Command";
	public static final String HISTORY = "History";
	public static final String VARIABLE = "Variable";

	/*
	public static Label getLabelOfType(String labelType){
		switch(labelType){
		case "Command":
			return getSpecifiedLabel(LabelConstants.COMMAND_LABEL_X, LabelConstants.COMMAND_LABEL_Y, LabelConstants.COMMAND_LABEL_TEXT);
		case "History":
			return getSpecifiedLabel(LabelConstants.HISTORY_LABEL_X, LabelConstants.HISTORY_LABEL_Y, LabelConstants.HISTORY_LABEL_TEXT);
		case "Variable":
			return getSpecifiedLabel(LabelConstants.VARIABLE_LABEL_X, LabelConstants.VARIABLE_LABEL_Y, LabelConstants.VARIABLE_LABEL_TEXT);
		default: throw new BadResourceNameException();
		}
	}

	private static Label getSpecifiedLabel(int x, int y, String labelText){
		Label label = new Label(labelText);
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setFont(new Font(LabelConstants.FONT_SIZE));
        return label;
	}
	*/
}
