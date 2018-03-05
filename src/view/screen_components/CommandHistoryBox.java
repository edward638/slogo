package view.screen_components;

import controller.CommandController;
import controller.CommandHistoryController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditorSkin;
import model.CommandHistory;
import model.CommandHistoryObservable;
import view.Observer;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;

import java.util.List;

public class CommandHistoryBox extends ScreenComponent implements Observer {
	private CommandHistoryObservable commandHistory;
	private Button clearButton;
	private VBox commandList;
	public CommandHistoryBox(){
		super();
	}

	private CommandHistoryController commandHistoryController;
	private CommandController commandController;

	public void setCommandHistoryController(CommandHistoryController controller){
		this.commandHistoryController = controller;
	}

	public void setCommandController(CommandController controller){
		this.commandController = controller;
	}

	public void setCommandHistory(CommandHistory commandHistory){
		this.commandHistory = commandHistory;
	}

	@Override
	protected void mapUserActions() {
		clearButton.setOnAction((event -> {
			commandHistoryController.clearCommandHistoryBox();
		}));
	}

	public void generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		this.addButtonAndLabels(borderPane);
	}

	private void addButtonAndLabels(BorderPane borderPane){
		HBox topComponent = new HBox();
		clearButton = new Button(ButtonConstants.HISTORY_BUTTON_LABEL);
		Label label = new Label(LabelConstants.HISTORY_LABEL_TEXT);
		topComponent.getChildren().add(label);
		topComponent.getChildren().add(clearButton);
		borderPane.setTop(topComponent);
		commandList = new VBox();
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setMaxWidth(100);
		scrollPane.setPrefHeight(100);
		scrollPane.setContent(commandList);
		borderPane.setCenter(scrollPane);
	}

	@Override
	public void notifyOfChanges() {
		List<String> commands = commandHistory.getCommands();
		commandList.getChildren().clear();
		for(String command: commands){
			Button commandButton = new Button(command);
			commandButton.setOnAction((event -> {
				//TODO: discuss with Belanie
				commandController.passCommand(commandButton.getText(),"English");
			}));
			commandList.getChildren().add(commandButton);
		}
	}
}
