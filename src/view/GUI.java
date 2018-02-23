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
import view.factories.ButtonFactory;
import view.factories.CanvasFactory;
import view.factories.LabelFactory;
import view.factories.TextAreaFactory;
import view.factories.TitleFactory;

public class GUI extends Application{
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
    
    /**
     * Begins GUI
     *
     * @param stage window holding simulation
     */
    @Override
    public void start(Stage stage) {
        this.setStage(stage);
        this.addTextAreas();
        this.addCanvas();
        this.addButtons();
        this.addLabels();
        this.addTitle();
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


    private String getCommandAndClear(){
    	String command = commandTextArea.getText();
    	commandTextArea.clear();
    	return command;
    }

    private void attachEventHandlers(){
    	commandClearButton.setOnAction((e) -> {
    		//TODO: initialize view controller, will crash right now
    		viewController.clearCommandBox();
		});
    	commandHelpButton.setOnAction((e) -> {
    		//TODO: initialize view controller, will crash right now
    		viewController.showCommandHelp();
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
    
    
    
    public static void main(String[] args){
        Application.launch(args);
    }
}
