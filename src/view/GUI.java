package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.ModelControllerInterface;
import controller.ViewControllerInterface;
	


import controller.ModelControllerInterface;
import controller.ViewControllerInterface;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import view.factories.*;

public class GUI{
	private static final String NAME = "SLogo";
	private static final int SIM_WIDTH = 950;
    private static final int SIM_HEIGHT = 650;
    
	ModelControllerInterface modelController;
	ViewControllerInterface viewController;

    private Group root = new Group();
    
    private Button commandClearButton;
    private Button commandRunButton;
    private Button variableClearButton;
    private Button historyClearButton;
    private Button commandHelpButton;
    
    private TextArea commandTextArea;
    private TextArea historyTextArea;
    private TextArea variableTextArea;

    private Canvas canvas;
    private Label commandLabel;
    private Label historyLabel;
    private Label variableLabel;
    private ComboBox languageBox;
    private ComboBox colorBox;
    
    /**
     * Begins GUI
     *
     * @param stage window holding simulation
     */
    public GUI(ModelControllerInterface controller){
        this.modelController = controller;
    }


    public void start(Stage stage) {
        this.setStage(stage);
        this.addTextAreas();
        this.addCanvas();
        this.addButtons();
        this.addLabels();
        this.addTitle();
        this.addComboBoxes();
        this.attachEventHandlers();
    }
    
    /**
     * Initializes beginning JavaFX Stage
     *
     * @param stage window holding simulation
     */
    private void setStage(Stage stage) {
        stage.setTitle(NAME);
        Scene startScene = new Scene(root, SIM_WIDTH, SIM_HEIGHT);
        stage.setScene(startScene);
        stage.show();
    }

    private void addTitle() {
    	Image titleImage = new Image(getClass().getClassLoader().getResourceAsStream(TitleFactory.SLOGO_IMAGE));
        ImageView title = TitleFactory.generateTitle(titleImage);
        root.getChildren().add(title);
    }

    private void addButtons(){
    	this.commandClearButton = ButtonFactory.generateButtonOfType(ButtonFactory.COMMAND_CLEAR);
    	this.commandRunButton = ButtonFactory.generateButtonOfType(ButtonFactory.COMMAND_RUN);
    	this.historyClearButton = ButtonFactory.generateButtonOfType(ButtonFactory.HISTORY);
    	this.variableClearButton = ButtonFactory.generateButtonOfType(ButtonFactory.VARIABLE);
    	this.commandHelpButton = ButtonFactory.generateButtonOfType(ButtonFactory.HELP);
        root.getChildren().add(commandClearButton);
        root.getChildren().add(commandRunButton);
        root.getChildren().add(historyClearButton);
        root.getChildren().add(variableClearButton);
        root.getChildren().add(commandHelpButton);
    }
    
    private void addTextAreas(){
    	this.commandTextArea = TextAreaFactory.generateTextAreaOfType(TextAreaFactory.COMMAND);
    	this.historyTextArea = TextAreaFactory.generateTextAreaOfType(TextAreaFactory.HISTORY);
    	this.variableTextArea = TextAreaFactory.generateTextAreaOfType(TextAreaFactory.VARIABLE);
    	root.getChildren().add(commandTextArea);
    	root.getChildren().add(historyTextArea);
    	root.getChildren().add(variableTextArea);
    }

    private void addLabels(){
    	this.commandLabel = LabelFactory.getLabelOfType(LabelFactory.COMMAND);
    	this.historyLabel = LabelFactory.getLabelOfType(LabelFactory.HISTORY);
    	this.variableLabel = LabelFactory.getLabelOfType(LabelFactory.VARIABLE);
        root.getChildren().add(commandLabel);
        root.getChildren().add(historyLabel);
        root.getChildren().add(variableLabel);
    }

    private void addCanvas(){
        this.canvas = CanvasFactory.generateCanvas();
        root.getChildren().add(canvas);
    }

    private void addComboBoxes(){
       this.languageBox = ComboBoxFactory.generateComboBoxOfType(ComboBoxFactory.LANGUAGE);
       this.colorBox = ComboBoxFactory.generateComboBoxOfType(ComboBoxFactory.COLOR);
       root.getChildren().add(languageBox);
       root.getChildren().add(colorBox);
    }


    private String getCommandAndClear(){
    	String command = commandTextArea.getText();
    	commandTextArea.clear();
    	return command;
    }

    public void clearCommandTextArea() {
        commandTextArea.clear();
    }

    private void attachEventHandlers(){
    	commandClearButton.setOnAction((e) -> {
    		//TODO: initialize view controller, will crash right now
    		modelController.clearCommandBox();
		});
    	commandHelpButton.setOnAction((e) -> {
    		//TODO: initialize view controller, will crash right now
    		modelController.showCommandHelp();
		});
    	commandRunButton.setOnAction((e) -> {
    		//TODO: initialize model controller, will crash right now
    		modelController.passCommand(this.getCommandAndClear());
		});
    	variableClearButton.setOnAction((e) -> {
    		//TODO: initialize model controller, will crash right now
    		modelController.clearVariableBox();
		});
    	historyClearButton.setOnAction((e) -> {
    		//TODO: initialize model controller, will crash right now
    		modelController.clearConsoleBox();
		});
    }
    
    
    

}
