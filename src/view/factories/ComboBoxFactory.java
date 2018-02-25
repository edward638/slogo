package view.factories;


import javafx.scene.control.ComboBox;
import view.constants.ComboBoxConstants;
import view.view_exceptions.BadResourceNameException;

public class ComboBoxFactory {
	/*
    public static final String LANGUAGE = "Language";
    public static final String COLOR = "Color";

    public static ComboBox generateComboBoxOfType(String comboBoxType) {
        switch (comboBoxType) {
            case "Language":
                return getSpecifiedComboBox(ComboBoxConstants.LANGUAGE_BOX_X, ComboBoxConstants.LANGUAGE_BOX_Y, ComboBoxConstants.LANGUAGE_LIST);
            case "Color":
                return getSpecifiedComboBox(ComboBoxConstants.BACKGROUND_COLOR_BOX_X, ComboBoxConstants.BACKGROUND_COLOR_BOX_Y, ComboBoxConstants.COLOR_LIST);

                default:
                throw new BadResourceNameException();
        }
    }
        private static ComboBox getSpecifiedComboBox(int x, int y, String[] choices){
            ComboBox comboBox = new ComboBox();
            comboBox.setLayoutX(x);
            comboBox.setLayoutY(y);

            for (int i = 0 ; i < choices.length; i++) {
                comboBox.getItems().add(choices[i]);
                comboBox.getSelectionModel().selectFirst();
            }
            return comboBox;
        }
        */
}

