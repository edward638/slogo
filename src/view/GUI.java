package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import view.constants.BorderPaneConstants;
import view.factories.TitleFactory;

public class GUI{
	private static final String NAME = "Slogo Programming Environment";
	private static final int WIDTH = 950;
	private static final int HEIGHT = 650;
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
        stage.setTitle(NAME);
        Scene startScene = new Scene(root, WIDTH, HEIGHT);
        startScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
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

    public void addHelpButtonBorderPane(BorderPane borderPane){
        borderPane.setLayoutX(BorderPaneConstants.HELP_BUTTON_X);
        borderPane.setLayoutY(BorderPaneConstants.HELP_BUTTON_Y);
        root.getChildren().add(borderPane);
    }

    public void addTurtleControlPanelBorderPane(BorderPane borderPane){
        borderPane.setLayoutX(BorderPaneConstants.TURTLE_CONTROL_PANEL_X);
        borderPane.setLayoutY(BorderPaneConstants.TURTLE_CONTROL_PANEL_Y);
        root.getChildren().add(borderPane);
    }
}
