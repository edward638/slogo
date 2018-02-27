package controller;

import javafx.stage.Stage;
import model.CommandHistory;
import model.ModelInterface;
import model.Turtle;
import model.VariableHistory;
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
	public Controller(Stage stage){
//		this.model = model;
		turtle = new Turtle(Drawer.TURTLE_START_X, Drawer.TURTLE_START_Y);
		parser = new Parser(turtle, "English");
		commandHistory = new CommandHistory();
		variableHistory = new VariableHistory();
		gui = new GUI();
		gui.start(stage);
		this.initializeGUIComponents();
	}
	
	private void initializeGUIComponents(){
		CommandBox commandBox = new CommandBox(this);
		CommandHistoryBox commandHistoryBox = new CommandHistoryBox(this);
		commandHistoryBox.setCommandHistory(commandHistory);
		Drawer drawer = new Drawer(this);
		drawer.setTurtle(turtle);
		VariableHistoryBox variableHistoryBox = new VariableHistoryBox(this);
		variableHistoryBox.setVariableHistory(variableHistory);
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
