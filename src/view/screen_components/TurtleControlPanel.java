package view.screen_components;

import controller.TurtleControlPanelController;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class TurtleControlPanel extends ScreenComponent {
    private static final double STEP_SIZE = 50;
    private static final double TURN_SIZE = 20;
    private TurtleControlPanelController controller;
    private Button forwardButton;
    private Button backwardButton;
    private Button leftTurnButton;
    private Button rightTurnButton;

    @Override
    protected void mapUserActions() {
        forwardButton.setOnAction((event -> {
            controller.forward(STEP_SIZE);
        }));
        backwardButton.setOnAction((event -> {
            controller.backward(STEP_SIZE);
        }));
        rightTurnButton.setOnAction((event -> {
            controller.rightTurn(TURN_SIZE);
        }));
        leftTurnButton.setOnAction((event -> {
            controller.leftTurn(TURN_SIZE);
        }));
    }

    @Override
    protected void generateGUIComponent() {
        BorderPane borderPane = super.getBorderPane();
        forwardButton = new Button("FD");
        backwardButton = new Button("BK");
        leftTurnButton = new Button("LT");
        rightTurnButton = new Button("RT");
        VBox vbox = new VBox();
        vbox.getChildren().add(forwardButton);
        vbox.getChildren().add(backwardButton);
        vbox.getChildren().add(leftTurnButton);
        vbox.getChildren().add(rightTurnButton);
        borderPane.setCenter(vbox);
    }

    public void setController(TurtleControlPanelController controller){
        this.controller = controller;
    }
}
