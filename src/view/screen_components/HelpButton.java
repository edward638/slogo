package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.constants.ButtonConstants;
import view.help_items.HelpPopup;

import javax.swing.border.Border;

public class HelpButton extends ScreenComponent{
    private Button commandHelpButton;


    public HelpButton(ControllerInterface controller) {
        super(controller);
    }

    @Override
    protected void mapUserActions() {
        commandHelpButton.setOnAction((event -> {
            displayHelpPopup();
        }));
    }

    public void generateGUIComponent() {
        BorderPane borderPane = super.getBorderPane();
        this.addHelpButton(borderPane);
    }

    private void addHelpButton(BorderPane borderPane){
        commandHelpButton = new Button(ButtonConstants.COMMAND_HELP_BUTTON_LABEL);
        borderPane.setCenter(commandHelpButton);
    }

    private void displayHelpPopup(){
        HelpPopup helpPopup = new HelpPopup();
    }
}
