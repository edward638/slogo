package controller;

import model.ModelInterface;
import view.GUI;

public class ModelController implements ModelControllerInterface{
	private ModelInterface model;
	public ModelController(ModelInterface model){
		this.model = model;
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
}
