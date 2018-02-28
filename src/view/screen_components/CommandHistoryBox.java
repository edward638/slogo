package view.screen_components;

import java.util.List;

import controller.ControllerInterface;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditorSkin;
import model.CommandHistory;
import model.CommandHistoryObservable;
import view.CommandHistoryObserver;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

public class CommandHistoryBox extends HistoryBox implements CommandHistoryObserver{
	private CommandHistoryObservable commandHistory;
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

	@Override
	public void notifyCommandHistoryObserver() {
		super.fillBox(commandHistory.getCommands());
	}
}
