package controller;

import javafx.stage.Stage;
import model.ModelInterface;
import view.GUI;

public class Controller implements ControllerInterface{
	private ModelInterface model;
	private GUI gui;
	public Controller(Stage stage){
//		this.model = model;
		gui = new GUI(this);
		gui.start(stage);
	}
    @Override
	public void passCommand(String s){
        
    }
    @Override
    public void clearConsoleBox(){
        
    }
    @Override
    public void clearVariableBox(){
        
    }

    @Override
    public void showCommandHelp() {

    }

    @Override
    public void clearCommandBox() {
	        gui.clearCommandTextArea();
    }

}
