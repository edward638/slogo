package view.factories;

import javafx.scene.control.TextArea;
import view.constants.TextAreaConstants;
import view.view_exceptions.BadResourceNameException;

public class TextAreaFactory {
	/*
	public static final String COMMAND = "Command";
	public static final String HISTORY = "History";
	public static final String VARIABLE = "Variable";

	public static TextArea generateTextAreaOfType(String textAreaType){
		switch(textAreaType){
			case "Command":
				return getSpecifiedTextArea(TextAreaConstants.COMMAND_TEXT_X, TextAreaConstants.COMMAND_TEXT_Y, TextAreaConstants.COMMAND_ROWS, TextAreaConstants.COMMAND_COLUMNS);
			case "History":
				return getSpecifiedTextArea(TextAreaConstants.HISTORY_TEXT_X, TextAreaConstants.HISTORY_TEXT_Y, TextAreaConstants.HISTORY_ROWS, TextAreaConstants.HISTORY_COLUMNS);
			case "Variable":
				return getSpecifiedTextArea(TextAreaConstants.VARIABLE_TEXT_X, TextAreaConstants.VARIABLE_TEXT_Y, TextAreaConstants.VARIABLE_ROWS, TextAreaConstants.VARIABLE_COLUMNS);
			default: throw new BadResourceNameException();
		}
	}

	private static TextArea getSpecifiedTextArea(int x, int y, int rows, int cols){
		TextArea textArea = new TextArea();
		textArea.setLayoutX(x);
        textArea.setLayoutY(y);
        textArea.setPrefRowCount(rows);
        textArea.setPrefColumnCount(cols);
        return textArea;
	}
	*/
}
