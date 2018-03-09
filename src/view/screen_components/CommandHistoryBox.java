package view.screen_components;

import Experiment.TheClearValueDelegate;
import Experiment.TheParserActionDelegate;
import controller.CommandBoxController;
import controller.CommandHistoryBoxController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CommandHistory;
import model.CommandHistoryObservable;
import propertiesFiles.ResourceBundleManager;
import view.Observer;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;

import java.util.List;

public class CommandHistoryBox extends ScreenComponent implements Observer {
	private CommandHistoryObservable commandHistory;
	private Button clearButton;
	private VBox commandList;
	public CommandHistoryBox(){
		super();
	}

	private TheParserActionDelegate theParserActionDelegate;
	private TheClearValueDelegate theClearValueDelegate;

	public void setTheParserActionDelegate(TheParserActionDelegate theParserActionDelegate){
		this.theParserActionDelegate = theParserActionDelegate;
	}

	public void setTheClearValueDelegate(TheClearValueDelegate theClearValueDelegate){
		this.theClearValueDelegate = theClearValueDelegate;
	}

	public void setCommandHistory(CommandHistory commandHistory){
		this.commandHistory = commandHistory;
	}

	@Override
	protected void mapUserActions() {
		clearButton.setOnAction((event -> {
			theClearValueDelegate.clear();
		}));
	}

	public void generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		this.addButtonAndLabels(borderPane);
	}

	private void addButtonAndLabels(BorderPane borderPane){
		HBox topComponent = new HBox();
		clearButton = new Button(ResourceBundleManager.retrieveButtonLabel("HISTORY_BUTTON_LABEL"));
		Label label = new Label(ResourceBundleManager.retrieveLabel("HISTORY_LABEL_TEXT"));
		topComponent.getChildren().add(label);
		topComponent.getChildren().add(clearButton);
		borderPane.setTop(topComponent);
		commandList = new VBox();
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setMaxWidth(200);
		scrollPane.setPrefHeight(300);
		scrollPane.setContent(commandList);
		borderPane.setCenter(scrollPane);
	}

	@Override
	public void notifyOfChanges() {
		List<String> commands = commandHistory.getCommands();
		commandList.getChildren().clear();
		for(String command: commands){
			Button commandButton = new Button(command);
			commandButton.getStyleClass().add("runnableCommandButton");
			commandButton.setOnAction((event -> {
				theParserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseString(commandButton.getText())));
			}));
			commandList.getChildren().add(commandButton);
		}
	}
}
