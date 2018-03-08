package view.screen_components;

import controller.CommandBoxController;
import controller.CommandHistoryBoxController;
import controller.CustomCommandController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CommandHistoryObservable;
import model.CustomCommandObservable;
import view.Observer;
import view.constants.ButtonConstants;
import view.constants.LabelConstants;

import java.util.List;

public class CustomCommandsBox extends ScreenComponent implements Observer {
    private CustomCommandObservable customCommandHolder;
    private Button clearButton;
    private VBox commandList;

    private CustomCommandController controller;

    public void setController(CustomCommandController controller){
        this.controller = controller;
    }

    private void addButtonAndLabels(BorderPane borderPane) {
        HBox topComponent = new HBox();
        clearButton = new Button("Clear");
        Label label = new Label("Custom Commands");
        topComponent.getChildren().add(label);
        topComponent.getChildren().add(clearButton);
        borderPane.setTop(topComponent);
        commandList = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxWidth(200);
        scrollPane.setPrefHeight(100);
        scrollPane.setContent(commandList);
        borderPane.setCenter(scrollPane);
    }

    public void setCustomCommandHolder(CustomCommandObservable holder){
        this.customCommandHolder = holder;
    }

    @Override
    public void notifyOfChanges() {
        List<String> commands = customCommandHolder.getCommands();
        commandList.getChildren().clear();
        for(String command: commands){
            Button commandButton = new Button(command);
            commandButton.getStyleClass().add("commandHistoryBoxButton");
            commandButton.setOnAction((event -> {
                controller.passCommand(commandButton.getText());
            }));
            commandList.getChildren().add(commandButton);
        }
    }

    @Override
    protected void mapUserActions() {
        clearButton.setOnAction((event -> {
            controller.clearCustomCommands();
        }));
    }

    @Override
    protected void generateGUIComponent() {
        BorderPane borderPane = super.getBorderPane();
        this.addButtonAndLabels(borderPane);
    }
}
