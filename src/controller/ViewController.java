package controller;

import model.ModelInterface;

public class ViewController extends Controller implements ViewControllerInterface{
	public ViewController(ModelInterface model){
		super(model);
	}
	@Override
	public void showCommandHelp(){
    	
    }
	@Override
    public void clearCommandBox(){
    	
    }
}
