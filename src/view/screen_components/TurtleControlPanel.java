package view.screen_components;

import Experiment.TheParserActionDelegate;
import controller.TurtleControlPanelController;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class TurtleControlPanel extends ScreenComponent {
    private static final double STEP_SIZE = 50;
    private static final double TURN_SIZE = 20;
    private TheParserActionDelegate theParserActionDelegate;
    private Button forwardButton;
    private Button backwardButton;
    private Button leftTurnButton;
    private Button rightTurnButton;

    public TurtleControlPanel(){
        super();
    }

    @Override
    protected void mapUserActions() {
        forwardButton.setOnAction((event -> {
            theParserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseString("fd 50")));
        }));
        backwardButton.setOnAction((event -> {
            theParserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseString("bk 50")));
        }));
        rightTurnButton.setOnAction((event -> {
            theParserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseString("rt 50")));
        }));
        leftTurnButton.setOnAction((event -> {
            theParserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseString("lt 50")));
        }));
    }

    @Override
    protected void generateGUIComponent() {
        BorderPane borderPane = super.getBorderPane();
        forwardButton = new Button();
        forwardButton.getStyleClass().add("fdButton");
        backwardButton = new Button();
        backwardButton.getStyleClass().add("bkButton");
        leftTurnButton = new Button();
        leftTurnButton.getStyleClass().add("ltButton");
        rightTurnButton = new Button();
        rightTurnButton.getStyleClass().add("rtButton");
        VBox vbox = new VBox();
        HBox topPanel = new HBox();
        topPanel.getChildren().add(backwardButton);
        topPanel.getChildren().add(forwardButton);
        HBox bottomPanel = new HBox();
        bottomPanel.getChildren().add(leftTurnButton);
        bottomPanel.getChildren().add(rightTurnButton);
        vbox.getChildren().add(topPanel);
        vbox.getChildren().add(bottomPanel);
        borderPane.setCenter(vbox);
    }

    public void setController(TheParserActionDelegate theParserActionDelegate){
        this.theParserActionDelegate = theParserActionDelegate;
    }
}
