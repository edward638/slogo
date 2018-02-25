package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.layout.BorderPane;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

public class VariableHistoryBox extends HistoryBox{
	public VariableHistoryBox(ControllerInterface controller){
		super(controller);
	}

	@Override
	protected void mapUserActions() {
		super.getButton().setOnAction((event -> {
			super.getController().clearVariableBox();
		}));
	}

	public void generateGUIComponent(){
		super.setDimensions(TextAreaConstants.VARIABLE_ROWS, TextAreaConstants.VARIABLE_COLUMNS);
		super.setUpLabels(LabelConstants.VARIABLE_LABEL_TEXT, ButtonConstants.VARIABLE_BUTTON_LABEL);
		super.generateGUIComponent();
	}
}
