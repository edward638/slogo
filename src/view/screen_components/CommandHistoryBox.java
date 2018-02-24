package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.layout.BorderPane;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

public class CommandHistoryBox extends HistoryBox{
	public CommandHistoryBox(ControllerInterface controller){
		super(controller);
	}

	@Override
	protected void mapUserActions() {

	}

	public void generateGUIComponent(){
		super.setDimensions(TextAreaConstants.HISTORY_ROWS, TextAreaConstants.HISTORY_COLUMNS);
		super.setUpLabels(LabelConstants.HISTORY_LABEL_TEXT, ButtonConstants.HISTORY_BUTTON_LABEL);
		super.generateGUIComponent();
	}
}
