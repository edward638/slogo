package view.screen_components;

import controller.ClearValueDelegate;
import controller.ValueModifierDelegate;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.VariableHistoryObservable;
import propertiesFiles.ResourceBundleManager;
import view.Observer;

import java.util.Map;

public class VariableHistoryBox extends ScreenComponent implements Observer {
	private static final int TEXTAREA_ROWS = 10;
	private static final int VALUEFIELD_WIDTH = 30;
	private static final int VARIABLE_COLUMNS = 12;
	private VariableHistoryObservable variableHistory;
	private ClearValueDelegate clearValueDelegate;
	private ValueModifierDelegate valueModifierDelegate;
	private TextArea textArea;
	private Button clearButton;
	private Button submitButton;
	private TextField editValueField;
	private ComboBox<String> variableComboBox;
	public VariableHistoryBox(){
		super();
	}

	public void setClearValueDelegate(ClearValueDelegate theClearValueDelegate){
		this.clearValueDelegate = theClearValueDelegate;
	}

	public void setValueModifierDelegate(ValueModifierDelegate valueModifierDelegate){
		this.valueModifierDelegate = valueModifierDelegate;
	}

	public void setVariableHistory(VariableHistoryObservable variableHistory){
		this.variableHistory = variableHistory;
	}

	@Override
	protected void mapUserActions() {
		clearButton.setOnAction((event -> {
			clearValueDelegate.clear();
		}));
		submitButton.setOnAction((event -> {
			valueModifierDelegate.changeValue(variableComboBox.getValue(), editValueField.getText());
		}));
	}

	public void generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		this.addButtonAndLabels(borderPane);
		this.addTextArea(borderPane);
	}

	protected void fillBox(Map<String, Double> variableMap){
		StringBuilder commandsToDisplay = new StringBuilder();
		for(String variableName : variableMap.keySet()){
			commandsToDisplay.append(variableName);
			commandsToDisplay.append(": ");
			commandsToDisplay.append(variableMap.get(variableName));
			commandsToDisplay.append("\n");
		}
		textArea.setText(commandsToDisplay.toString());

		variableComboBox.getItems().clear();
		for(String variableName : variableMap.keySet()){
			variableComboBox.getItems().add(variableName);
		}
		variableComboBox.getSelectionModel().selectFirst();
	}

	private void addButtonAndLabels(BorderPane borderPane){
		HBox topComponent = new HBox();
		clearButton = new Button(ResourceBundleManager.retrieveButtonLabel("CLEAR"));
		Label label = new Label(ResourceBundleManager.retrieveLabel("VARIABLE_LABEL_TEXT"));
		topComponent.getChildren().add(label);
		topComponent.getChildren().add(clearButton);
		borderPane.setTop(topComponent);
		HBox bottomComponent = new HBox();
		variableComboBox = new ComboBox<>();
		bottomComponent.getChildren().add(variableComboBox);
		editValueField = new TextField();
		editValueField.setMaxWidth(VALUEFIELD_WIDTH);
		bottomComponent.getChildren().add(editValueField);
		submitButton = new Button(ResourceBundleManager.retrieveButtonLabel("SUBMIT"));
		bottomComponent.getChildren().add(submitButton);
		borderPane.setBottom(bottomComponent);
	}


	private void addTextArea(BorderPane borderPane){
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setPrefRowCount(TEXTAREA_ROWS);
		textArea.setPrefColumnCount(VARIABLE_COLUMNS);
		borderPane.setCenter(textArea);
	}

	@Override
	public void notifyOfChanges() {
		this.fillBox(variableHistory.getVariableMapCopy());
	}
}
