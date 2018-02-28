package view.help_items;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.constants.HelpPopupConstants;

public class HelpPopup {
    private Stage helpStage;
    private Group helpRoot;
    private Button basicSyntaxButton;
    private Button turtleCommandsButton;
    private Button turtleQueriesButton;
    private Button mathOperationsButton;
    private Button booleanOperationsButton;
    private Button variablesButton;
    private HBox hBox1;
    private HBox hBox2;


    public HelpPopup(){
        helpRoot = new Group();
        helpStage = new Stage();
        helpStage.setTitle("Help for SLogo");
        helpStage.setScene(new Scene(helpRoot, 450, 450));
        addFirstButtonRow();
        addSecondButtonRow();
    }

    public void show(){
        helpStage.show();
    }

    public void addFirstButtonRow(){
        hBox1 = new HBox();
        basicSyntaxButton = new Button(HelpPopupConstants.BASIC_SYNTAX);
        turtleCommandsButton = new Button(HelpPopupConstants.TURTLE_COMMANDS);
        turtleQueriesButton = new Button(HelpPopupConstants.TURTLE_QUERIES);
        hBox1.getChildren().add(basicSyntaxButton);
        hBox1.getChildren().add(turtleCommandsButton);
        hBox1.getChildren().add(turtleQueriesButton);
        hBox1.setLayoutX(100);
        hBox1.setLayoutY(100);
    }
    public void addSecondButtonRow(){
        hBox2 = new HBox();
        mathOperationsButton = new Button(HelpPopupConstants.MATH_OPERATIONS);
        booleanOperationsButton = new Button(HelpPopupConstants.BOOLEAN_OPERATIONS);
        variablesButton = new Button(HelpPopupConstants.VARIABLES);
        hBox2.getChildren().add(mathOperationsButton);
        hBox2.getChildren().add(booleanOperationsButton);
        hBox2.getChildren().add(variablesButton);
        hBox2.setLayoutX(100);
        hBox2.setLayoutY(200);
    }

}
