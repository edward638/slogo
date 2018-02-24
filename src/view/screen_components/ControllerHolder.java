package view.screen_components;

import controller.ControllerInterface;

public class ControllerHolder {
	private ControllerInterface controller;
	public ControllerHolder(ControllerInterface controller){
		this.controller = controller;
	}
	protected ControllerInterface getController(){
		return controller;
	}
}
