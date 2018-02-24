package view;

import controller.ControllerInterface;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.constants.BorderPaneConstants;
import view.factories.TitleFactory;

public class GUI{

    private Group root = new Group();

    public GUI(){
    	
    }
    
    public void start(Stage stage) {
        this.setStage(stage);
    }
    
    /**
     * Initializes beginning JavaFX Stage
     *
     * @param stage window holding simulation
     */
    private void setStage(Stage stage) {
        stage.setTitle("NAME");
        Scene startScene = new Scene(root, 950, 650);
        stage.setScene(startScene);
        addTitle();
        stage.show();
    }

    private void addTitle() {
        Image titleImage = new Image(getClass().getClassLoader().getResourceAsStream(TitleFactory.SLOGO_IMAGE));
        ImageView title = TitleFactory.generateTitle(titleImage);
        root.getChildren().add(title);
    }

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
