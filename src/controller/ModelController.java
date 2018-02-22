package controller;

import model.ModelInterface;

public class ModelController extends Controller implements ModelControllerInterface{
	public ModelController(ModelInterface model){
		super(model);
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
