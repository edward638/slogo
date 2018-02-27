package view.screen_components;

import java.util.List;

import controller.ControllerInterface;
import javafx.scene.control.TextArea;
import model.CommandHistory;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

public class CommandHistoryBox extends HistoryBox{
	private CommandHistory commandHistory;
	public CommandHistoryBox(ControllerInterface controller){
		super(controller);
	}

	public void setCommandHistory(CommandHistory commandHistory){
		this.commandHistory = commandHistory;
	}

	@Override
	protected void mapUserActions() {
		super.getButton().setOnAction((event -> {
			super.getController().clearCommandHistoryBox();
		}));
	}

	public void generateGUIComponent(){
		super.setDimensions(TextAreaConstants.HISTORY_ROWS, TextAreaConstants.HISTORY_COLUMNS);
		super.setUpLabels(LabelConstants.HISTORY_LABEL_TEXT, ButtonConstants.HISTORY_BUTTON_LABEL);
		super.generateGUIComponent();
	}
	
	private void fillBoxWithCommands(List<String> commands){
		TextArea textArea = super.getTextArea();
		String commandsToDisplay = "";
		for(String s: commands){
			commandsToDisplay += s + "\n";
		}
		textArea.setText(commandsToDisplay);
	}
}
