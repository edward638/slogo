package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.ModelInterface;
import view.OutdatedGUI;


public class ModelController implements ModelControllerInterface{
	
	private ModelInterface model;
	private OutdatedGUI gui;
	public ModelController(Stage stage){
//		this.model = model;
//		gui = new GUI(this);
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
