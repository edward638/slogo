package controller;

import view.ViewInterface;

public class ViewController implements ViewControllerInterface{
	private ViewInterface view;
	public ViewController(ViewInterface view){
		this.view = view;
	}
	@Override
	public void showCommandHelp(){
    	
    }
	@Override
    public void clearCommandBox(){
    	
    }
}
