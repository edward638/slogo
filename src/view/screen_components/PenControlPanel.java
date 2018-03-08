package view.screen_components;

import controller.PenPanelController;
import controller.TurtleControlPanelController;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PenControlPanel extends ScreenComponent{
    private static final double SMALL_PEN_SIZE = 50;
    private static final double MED_PEN_SIZE = 50;
    private static final double LARGE_PEN_SIZE = 50;
    private PenPanelController controller;
    private Button penUpButton;
    private Button penDownButton;
    private Button smallPenButton;
    private Button medPenButton;
    private Button largePenButton;

    public PenControlPanel(){
        super();
    }

    public void setController(PenPanelController controller){
        this.controller = controller;
    }

    @Override
    protected void mapUserActions() {
        penUpButton.setOnAction((event -> {
            controller.penUp();
        }));
        penDownButton.setOnAction((event -> {
            controller.penDown();
        }));
        smallPenButton.setOnAction((event -> {
            controller.setPenSize(SMALL_PEN_SIZE);
        }));
        medPenButton.setOnAction((event -> {
            controller.setPenSize(MED_PEN_SIZE);
        }));
        largePenButton.setOnAction((event -> {
            controller.setPenSize(LARGE_PEN_SIZE);
        }));
    }

    @Override
    protected void generateGUIComponent() {
        BorderPane borderPane = super.getBorderPane();
        penUpButton = new Button("Up");
        penDownButton = new Button("Down");
        smallPenButton = new Button("Small");
        medPenButton = new Button("Med");
        largePenButton = new Button("Large");
        VBox vbox = new VBox();
        vbox.getChildren().add(penUpButton);
        vbox.getChildren().add(penDownButton);
        vbox.getChildren().add(smallPenButton);
        vbox.getChildren().add(medPenButton);
        vbox.getChildren().add(largePenButton);
        borderPane.setCenter(vbox);
    }
}
