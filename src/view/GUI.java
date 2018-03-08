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
import view.screen_components.*;
import view.view_exceptions.ImproperScreenComponentException;

public class GUI{
	private static final String NAME = "Slogo Programming Environment";
	private static final int WIDTH = 1100;
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
        this.addTitle();
        stage.show();

    }

    public void addToScreen(ScreenComponent screenComponent){
        if(screenComponent instanceof CommandBox){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.COMMAND_BOX_X, BorderPaneConstants.COMMAND_BOX_Y);
        }else if(screenComponent instanceof CustomCommandsBox){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.CUSTOM_COMMANDS_X, BorderPaneConstants.CUSTOM_COMMANDS_Y);
        }else if(screenComponent instanceof CommandHistoryBox){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.COMMAND_HISTORY_BOX_X, BorderPaneConstants.COMMAND_HISTORY_BOX_Y);
        }else if(screenComponent instanceof Drawer){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.DRAWER_X, BorderPaneConstants.DRAWER_Y);
        }else if(screenComponent instanceof HelpButton){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.HELP_BUTTON_X, BorderPaneConstants.HELP_BUTTON_Y);
        }else if(screenComponent instanceof Palette){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.PALLETE_X, BorderPaneConstants.PALETTE_Y);
        }else if(screenComponent instanceof PenControlPanel){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.PEN_CONTROL_PANEL_X, BorderPaneConstants.PEN_CONTROL_PANEL_Y);
        }else if(screenComponent instanceof TurtleControlPanel){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.TURTLE_CONTROL_PANEL_X, BorderPaneConstants.TURTLE_CONTROL_PANEL_Y);
        }else if(screenComponent instanceof VariableHistoryBox){
            this.positionBorderPane(screenComponent.getGUIComponent(), BorderPaneConstants.VARIABLE_HISTORY_BOX_X, BorderPaneConstants.VARIABLE_HISTORY_BOX_Y);
        }else{
            throw new ImproperScreenComponentException("Trying to position an improper screen component onto the GUI");
        }
    }

    private void positionBorderPane(BorderPane borderPane, double x, double y){
        borderPane.setLayoutX(x);
        borderPane.setLayoutY(y);
        root.getChildren().add(borderPane);
    }

    private void addTitle() {
        BorderPane titlePane = new BorderPane();
        titlePane.getStyleClass().add("titlePane");
        titlePane.setLayoutX(BorderPaneConstants.TITLE_PANEL_X);
        titlePane.setLayoutY(BorderPaneConstants.TITLE_PANEL_Y);
        root.getChildren().add(titlePane);
    }
}
