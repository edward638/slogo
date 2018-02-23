package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import controller.ModelControllerInterface;
import controller.ViewControllerInterface;
	


import controller.ModelControllerInterface;
import controller.ViewControllerInterface;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import view.constants.ButtonConstants;
import view.constants.CanvasConstants;
import view.constants.LabelConstants;
import view.constants.TextAreaConstants;
import view.factories.ButtonFactory;
import view.factories.LabelFactory;

public class GUI extends Application implements ActionListener{
	ModelControllerInterface modelController;
	ViewControllerInterface viewController;
    
    public static final int HBOX_Y = 200;
    public static final int HBOX_X = 525;
    public static final int HBOX_SPACING = 20;
    public static final int OTHER_COLUMNS = 12;
    public static final int OTHER_ROWS = 20;
    public static final int FONT_SIZE = 13;
    public static final int LABEL_OFFSET = 25;
    private static final String NAME = "SLogo";
    private static final int COMMAND_BUTTON_OFFSET = 25;
    private static final int SIM_WIDTH = 950;
    private static final int SIM_HEIGHT = 650;
    private final String SLOGO_IMAGE = "SLogo.PNG";
    
    private final Image slogoImage = new Image(getClass().getClassLoader().getResourceAsStream("SLogo.PNG"));

    private Group root = new Group();
    private HBox hbTextAreas;
    
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
<<<<<<< HEAD
=======
     * Begins GUI
     *
     * @param stage window holding simulation
     */
    @Override
    public void start(Stage stage) {
        setStage(stage);
        addDisplays();
        addButtons();
        addCommandTextArea();
        addLabels();
        addTitle();
    }
    
    /**
>>>>>>> 7ab264ca6ceeb6712d783e91f83af1bcf1a98d7b
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
        ImageView slogo = new ImageView(slogoImage);
        slogo.setX(HBOX_X);
        slogo.setY(LABEL_OFFSET);
        slogo.setPreserveRatio(true);
        slogo.setFitHeight(200);
        slogo.setFitWidth(350);
        root.getChildren().add(slogo);
    }

    private void addButtons(){
    	this.commandClearButton = ButtonFactory.getButtonOfType(ButtonFactory.COMMAND_CLEAR);
    	this.commandRunButton = ButtonFactory.getButtonOfType(ButtonFactory.COMMAND_RUN);
    	this.historyClearButton = ButtonFactory.getButtonOfType(ButtonFactory.HISTORY);
    	this.variableClearButton = ButtonFactory.getButtonOfType(ButtonFactory.VARIABLE);
        root.getChildren().add(commandClearButton);
        root.getChildren().add(commandRunButton);
        root.getChildren().add(historyClearButton);
        root.getChildren().add(variableClearButton);
    	
    	addCommandTextArea();
    }

    private void addDisplays(){
        addViewWindow();
        hbTextAreas = new HBox();
        hbTextAreas.setSpacing(HBOX_SPACING);
        hbTextAreas.setPadding(new Insets(HBOX_Y, 0, 0,HBOX_X));
        addHistoryTextArea(hbTextAreas);
        addVariableTextArea(hbTextAreas);
        root.getChildren().add(hbTextAreas);
    }

    private void addLabels(){
    	this.commandLabel = LabelFactory.getLabelOfType(LabelFactory.COMMAND);
    	this.historyLabel = LabelFactory.getLabelOfType(LabelFactory.HISTORY);
    	this.variableLabel = LabelFactory.getLabelOfType(LabelFactory.VARIABLE);
        root.getChildren().add(commandLabel);
        root.getChildren().add(historyLabel);
        root.getChildren().add(variableLabel);
    }

    private void addViewWindow(){
        canvas = new Canvas(CanvasConstants.RECTANGLE_WIDTH, CanvasConstants.RECTANGLE_HEIGHT);
        canvas.setLayoutX(CanvasConstants.RECTANGLE_X);
        canvas.setLayoutY(CanvasConstants.RECTANGLE_Y);
        canvas.getGraphicsContext2D().setFill(Color.GREEN);
        canvas.getGraphicsContext2D().setStroke(Color.BLACK);
        root.getChildren().add(canvas);
    }

    private void addCommandTextArea(){
        commandTextArea = new TextArea();
        commandTextArea.setLayoutY(TextAreaConstants.COMMAND_TEXT_Y);
        commandTextArea.setLayoutX(TextAreaConstants.COMMAND_TEXT_X);
        commandTextArea.setPrefColumnCount(TextAreaConstants.COMMAND_COLUMNS);
        commandTextArea.setPrefRowCount(TextAreaConstants.COMMAND_ROWS);
        root.getChildren().add(commandTextArea);
    }

    private void addHistoryTextArea(HBox box){
        historyTextArea = new TextArea();
        historyTextArea.setPrefColumnCount(OTHER_COLUMNS);
        historyTextArea.setPrefRowCount(OTHER_ROWS);
        historyTextArea.setEditable(false);
        box.getChildren().add(historyTextArea);
    }

    private void addVariableTextArea(HBox box){
        variableTextArea = new TextArea();
        variableTextArea.setPrefColumnCount(OTHER_COLUMNS);
        variableTextArea.setPrefRowCount(OTHER_ROWS);
        variableTextArea.setEditable(false);
        box.getChildren().add(variableTextArea);
    }


    private String getCommandAndClear(){
    	String command = commandTextArea.getText();
    	commandTextArea.clear();
    	return command;
    }

    @Override
	public void actionPerformed(ActionEvent event) {
        if(event.getSource() == commandClearButton){
        	viewController.clearCommandBox();
        }else if(event.getSource() == commandHelpButton){
        	viewController.showCommandHelp();
        }else if(event.getSource() == commandRunButton){
        	modelController.passCommand(this.getCommandAndClear());
        }else if(event.getSource() == variableClearButton){
        	modelController.clearVariableBox();
        }else if(event.getSource() == historyClearButton){
        	modelController.clearConsoleBox();
        }
	}
    public static void main(String[] args){
        Application.launch(args);
    }
}
