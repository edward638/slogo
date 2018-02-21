package view;

import javafx.scene.control.Button;

public class ButtonMaker {

    public Button button;

    public ButtonMaker(int xCoord, int yCoord, String buttonText){
        button = new Button(buttonText);
        button.setLayoutX(xCoord);
        button.setLayoutY(yCoord);
    }


}
