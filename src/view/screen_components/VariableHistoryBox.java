package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.layout.BorderPane;
import model.VariableHistory;
import nodes.Variable;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

public class VariableHistoryBox extends HistoryBox{
	private VariableHistory variableHistory;
	public VariableHistoryBox(ControllerInterface controller){
		super(controller);
	}

	public void setVariableHistory(VariableHistory variableHistory){
		this.variableHistory = variableHistory;
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
