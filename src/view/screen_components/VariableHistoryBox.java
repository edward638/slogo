package view.screen_components;

import controller.ControllerInterface;
import model.VariableHistoryObservable;
import view.Observer;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

public class VariableHistoryBox extends HistoryBox implements Observer {
	private VariableHistoryObservable variableHistory;
	public VariableHistoryBox(ControllerInterface controller){
		super(controller);
	}

	public void setVariableHistory(VariableHistoryObservable variableHistory){
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


	@Override
	public void notifyOfChanges() {
		super.fillBox(variableHistory.getVariables());
	}
}
