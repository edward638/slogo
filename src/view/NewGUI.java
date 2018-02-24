package view;

import controller.ControllerInterface;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import view.constants.BorderPaneConstants;

public class NewGUI {

    private Group root = new Group();

    public void addDrawerBorderPane(BorderPane borderPane){
        borderPane.setLayoutX(BorderPaneConstants.DRAWER_X);
        borderPane.setLayoutY(BorderPaneConstants.DRAWER_Y);
        root.getChildren().add(borderPane);
    }

    public void addCommandHistoryBoxBorderPane(BorderPane borderPane){
        borderPane.setLayoutX(BorderPaneConstants.COMMAND_HISTORY_BOX_X);
        borderPane.setLayoutY(BorderPaneConstants.COMMAND_HISTORY_BOX_Y);
        root.getChildren().add(borderPane);
    }

    public void addCommandBoxBorderPane(BorderPane borderPane){
        borderPane.setLayoutX(BorderPaneConstants.COMMAND_BOX_X);
        borderPane.setLayoutY(BorderPaneConstants.COMMAND_BOX_Y);
        root.getChildren().add(borderPane);
    }
    public void addVariableHistoryBoxBorderPane(BorderPane borderPane){
        borderPane.setLayoutX(BorderPaneConstants.VARIABLE_HISTORY_BOX_X);
        borderPane.setLayoutY(BorderPaneConstants.VARIABLE_HISTORY_BOX_Y);
        root.getChildren().add(borderPane);
    }

}
