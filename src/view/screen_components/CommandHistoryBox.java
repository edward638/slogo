package view.screen_components;

import controller.CommandHistoryController;
import model.CommandHistory;
import model.CommandHistoryObservable;
import view.Observer;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

public class CommandHistoryBox extends HistoryBox implements Observer {
	private CommandHistoryObservable commandHistory;
	public CommandHistoryBox(){
		super();
	}

	private CommandHistoryController controller;

	public void setController(CommandHistoryController controller){
		this.controller = controller;
	}

	public void setCommandHistory(CommandHistory commandHistory){
		this.commandHistory = commandHistory;
	}

	@Override
	protected void mapUserActions() {
		super.getButton().setOnAction((event -> {
			controller.clearCommandHistoryBox();
		}));
	}

	public void generateGUIComponent(){
		super.setDimensions(TextAreaConstants.HISTORY_ROWS, TextAreaConstants.HISTORY_COLUMNS);
		super.setUpLabels(LabelConstants.HISTORY_LABEL_TEXT, ButtonConstants.HISTORY_BUTTON_LABEL);
		super.generateGUIComponent();
	}

	@Override
	public void notifyOfChanges() {
		super.fillBox(commandHistory.getCommands());
	}
}
