package view.screen_components;

import controller.VariableHistoryController;
import model.VariableHistoryObservable;
import view.Observer;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

public class VariableHistoryBox extends HistoryBox implements Observer {
	private VariableHistoryObservable variableHistory;
	private VariableHistoryController controller;
	public VariableHistoryBox(){
		super();
	}

	public void setController(VariableHistoryController controller){
		this.controller = controller;
	}

	public void setVariableHistory(VariableHistoryObservable variableHistory){
		this.variableHistory = variableHistory;
	}

	@Override
	protected void mapUserActions() {
		super.getButton().setOnAction((event -> {
			controller.clearVariableBox();
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
