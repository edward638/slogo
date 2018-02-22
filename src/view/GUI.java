package view;

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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application {

	ModelControllerInterface modelController;
	ViewControllerInterface viewController;
    public static final int COMMAND_TEXT_Y = 530;
    public static final int COMMAND_TEXT_X = 70;
    public static final int COMMAND_COLUMNS = 30;
    public static final int COMMAND_ROWS = 4;
    public static final String COMMAND_START_TEXT = "FD 50";
    public static final int HBOX_Y = 200;
    public static final int HBOX_X = 525;
    public static final int HBOX_SPACING = 20;
    public static final int OTHER_COLUMNS = 12;
    public static final int OTHER_ROWS = 20;
    public static final int FONT_SIZE = 13;
    public static final int LABEL_OFFSET = 25;
    private static final String NAME = "SLogo";
    private static final int COMMAND_BUTTON_OFFSET = 25;
    private Group root = new Group();
    private static final int SIM_WIDTH = 900;
    private static final int SIM_HEIGHT = 650;
    private static final int COMMAND_BUTTON_X = 450;
    private static final int COMMAND_BUTTON_Y = 550;
    private static final int VARIABLE_BUTTON_X = 830;
    private static final int VARIABLE_BUTTON_Y = 170;
    private static final int HISTORY_BUTTON_X = 645;
    private static final int HISTORY_BUTTON_Y = 170;
    private static final int RECTANGLE_X = 50;
    private static final int RECTANGLE_Y = 50;
    private static final int RECTANGLE_WIDTH = 450;
    private static final int RECTANGLE_HEIGHT = 450;
    private final String SLOGO_IMAGE = "SLogo.PNG";
    private Image slogoImage = new Image(getClass().getClassLoader().getResourceAsStream("SLogo.PNG"));

    private HBox hbTextAreas;
    private VBox vbButtons;
    private Button commandClearButton;
    private Button commandRunButton;
    private Button variableClearButton;
    private Button historyClearButton;
    private TextArea commandTextArea;
    private TextArea historyTextArea;
    private TextArea variableTextArea;

    private Rectangle viewWindow;
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
        vbButtons = new VBox();
        vbButtons.setPrefWidth(50);
        vbButtons.setPadding(new Insets(COMMAND_BUTTON_Y, 0, 0, COMMAND_BUTTON_X));
        addCommandRunButton(vbButtons);
        addCommandClearButton(vbButtons);
        root.getChildren().add(vbButtons);

        addHistoryClearButton();
        addVariableClearButton();
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
        commandLabel = new Label("Enter a command:");
        commandLabel.setFont(new Font(FONT_SIZE));
        commandLabel.setLayoutY(COMMAND_TEXT_Y - LABEL_OFFSET);
        commandLabel.setLayoutX(COMMAND_TEXT_X);
        root.getChildren().add(commandLabel);

        historyLabel = new Label("Command History");
        historyLabel.setFont(new Font(FONT_SIZE));
        historyLabel.setLayoutY(HBOX_Y - LABEL_OFFSET);
        historyLabel.setLayoutX(HBOX_X);
        root.getChildren().add(historyLabel);

        variableLabel = new Label("Current Variables");
        variableLabel.setFont(new Font(FONT_SIZE));
        variableLabel.setLayoutY(HBOX_Y - LABEL_OFFSET);
        variableLabel.setLayoutX(HBOX_X + 185);
        root.getChildren().add(variableLabel);



    }

    private void addCommandRunButton(VBox box){
        commandRunButton = new Button("Run");
        commandRunButton.setMinWidth(box.getPrefWidth());
        box.getChildren().add(commandRunButton);
    }

    private void addCommandClearButton(VBox box){
        commandClearButton = new Button("Clear");
        commandClearButton.setMinWidth(box.getPrefWidth());
        box.getChildren().add(commandClearButton);
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

    private void addViewWindow(){
        viewWindow = new Rectangle(RECTANGLE_X, RECTANGLE_Y, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        viewWindow.setFill(Color.WHITE);
        viewWindow.setStroke(Color.BLACK);
        root.getChildren().add(viewWindow);
    }

    private void addCommandTextArea(){
        commandTextArea = new TextArea();
        commandTextArea.setLayoutY(COMMAND_TEXT_Y);
        commandTextArea.setLayoutX(COMMAND_TEXT_X);
        commandTextArea.setPrefColumnCount(COMMAND_COLUMNS);
        commandTextArea.setPrefRowCount(COMMAND_ROWS);
        commandTextArea.setText(COMMAND_START_TEXT);
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




    public static void main(String[] args){
        Application.launch(args);
    }

}
