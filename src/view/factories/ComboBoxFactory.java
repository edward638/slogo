package view.factories;

import javafx.scene.control.ComboBox;

public class ComboBoxFactory {
    public static final String[] LANGUAGE_LIST = {"English", "Chinese"};


    //TODO: duplication
    public static ComboBox<String> generateStringComboBox(String prompt, String[] options){
        ComboBox<String> comboBox = new ComboBox<>();
        for (int x = 0 ; x < options.length; x++) {
            comboBox.getItems().add(options[x]);
        }
        comboBox.setPromptText(prompt);
        comboBox.getSelectionModel().selectFirst();
        return comboBox;
    }

    public static ComboBox<Integer> generateIntegerComboBox(String prompt, int numOptions){
        ComboBox<Integer> comboBox = new ComboBox<>();
        for (int x = 0 ; x < numOptions; x++) {
            comboBox.getItems().add(x);
        }
        comboBox.setPromptText(prompt);
        comboBox.getSelectionModel().selectFirst();
        return comboBox;
    }
}
