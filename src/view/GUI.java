package view;


import controller.ModelControllerInterface;
import controller.ViewControllerInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GUI extends Application {
    
    ModelControllerInterface modelController;
	ViewControllerInterface viewController;
    private static final String NAME = "SLogo";
    public static final int COMMAND_BUTTON_OFFSET = 25;
    private Group root = new Group();
    private static final int SIM_WIDTH = 800;
    private static final int SIM_HEIGHT = 600;
    private static final int COMMAND_BUTTON_X = 300;
    private static final int COMMAND_BUTTON_Y = 450;
    private static final int VARIABLE_BUTTON_X = 500;
    private static final int VARIABLE_BUTTON_Y = 200;
    private static final int HISTORY_BUTTON_X = 700;
    private static final int HISTORY_BUTTON_Y = 200;



    private Button commandClearButton;
    private Button commandRunButton;
    private Button variableClearButton;
    private Button historyClearButton;

    /**
     * Begins GUI
     *
     * @param stage window holding simulation
     */
    @Override
    public void start(Stage stage) {
        setStage(stage);
        addButtons();
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

    
    private void addButtons(){
        addCommandRunButton();
        addCommandClearButton();
        addHistoryClearButton();
        addVariableClearButton();
    }

    private void addCommandRunButton(){
        commandRunButton = new Button("Run");
        commandRunButton.setLayoutY(COMMAND_BUTTON_Y);
        commandRunButton.setLayoutX(COMMAND_BUTTON_X);
        root.getChildren().add(commandRunButton);
    }

    private void addCommandClearButton(){
        commandClearButton = new Button("Clear");
        commandClearButton.setLayoutY(COMMAND_BUTTON_Y + COMMAND_BUTTON_OFFSET);
        commandClearButton.setLayoutX(COMMAND_BUTTON_X);
        root.getChildren().add(commandClearButton);
    }

    private void addHistoryClearButton(){
        historyClearButton = new Button("Clear");
        historyClearButton.setLayoutY(HISTORY_BUTTON_Y);
        historyClearButton.setLayoutX(HISTORY_BUTTON_X);
        root.getChildren().add(historyClearButton);
    }

    private void addVariableClearButton(){
        variableClearButton = new Button("Clear");
        variableClearButton.setLayoutY(VARIABLE_BUTTON_Y);
        variableClearButton.setLayoutX(VARIABLE_BUTTON_X);
        root.getChildren().add(variableClearButton);
    }



    public static void main(String[] args){
        Application.launch(args);
    }

}
