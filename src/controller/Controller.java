package controller;

import javafx.stage.Stage;
import model.*;
import parsers.Parser;
import view.GUI;
import view.screen_components.CommandBox;
import view.screen_components.CommandHistoryBox;
import view.screen_components.Drawer;
import view.screen_components.VariableHistoryBox;

public class Controller implements ControllerInterface{
	private ModelInterface model;
	private GUI gui;
	private Turtle turtle;
	private Parser parser;
	private CommandHistory commandHistory;
	private VariableHistory variableHistory;
	private Drawer drawer;
	private CommandBox commandBox;
	private CommandHistoryBox commandHistoryBox;
	private VariableHistoryBox variableHistoryBox;
	public Controller(Stage stage){
//		this.model = model;
		gui = new GUI();
		gui.start(stage);
		this.initializeScreenComponents();
		this.initializeModelComponents();
		this.setUpConnections();
		this.addToGUI();
	}

	private void initializeModelComponents(){
		turtle = new Turtle(Drawer.TURTLE_START_X, Drawer.TURTLE_START_Y);
		//parser = new Parser(turtle, "English");
		commandHistory = new CommandHistory();
		variableHistory = new VariableHistory();
	}

	private void setUpConnections(){
		turtle.addTurtleObserver(drawer);
		drawer.setTurtle(turtle);
		variableHistoryBox.setVariableHistory(variableHistory);
		commandHistoryBox.setCommandHistory(commandHistory);
	}

	private void initializeScreenComponents(){
		drawer = new Drawer(this);
		commandBox = new CommandBox(this);
		commandHistoryBox = new CommandHistoryBox(this);
		variableHistoryBox = new VariableHistoryBox(this);
	}

	private void addToGUI(){
		gui.addCommandBoxBorderPane(commandBox.getGUIComponent());
		gui.addCommandHistoryBoxBorderPane(commandHistoryBox.getGUIComponent());
		gui.addDrawerBorderPane(drawer.getGUIComponent());
		gui.addVariableHistoryBoxBorderPane(variableHistoryBox.getGUIComponent());
	}
	
    @Override
	public void passCommand(String s){
        parser.parseString(s);
    }

    @Override
    public void clearVariableBox(){
        
    }

    @Override
    public void clearCommandHistoryBox() {

    }

}
