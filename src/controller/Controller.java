package controller;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;
import nodes.NodeI;
import parsers.Parser;
import view.GUI;
import view.screen_components.*;

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
	private HelpButton helpButton;
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
		turtle = new Turtle(Drawer.CANVAS_WIDTH, Drawer.CANVAS_HEIGHT, Drawer.INITIAL_PEN_COLOR);
        commandHistory = new CommandHistory();
        variableHistory = new VariableHistory();
		parser = new Parser(turtle, variableHistory, commandHistory);
	}

	private void setUpConnections(){
		turtle.addObserver(drawer);
		drawer.setTurtle(turtle);
		drawer.update();
		variableHistoryBox.setVariableHistory(variableHistory);
		commandHistoryBox.setCommandHistory(commandHistory);
		commandHistory.addObserver(commandHistoryBox);
		variableHistoryBox.setVariableHistory(variableHistory);
		variableHistory.addObserver(variableHistoryBox);
	}

	private void initializeScreenComponents(){
		drawer = new Drawer(this);
		commandBox = new CommandBox(this);
		commandHistoryBox = new CommandHistoryBox(this);
		variableHistoryBox = new VariableHistoryBox(this);
		helpButton = new HelpButton(this);

	}

	private void addToGUI(){
		gui.addCommandBoxBorderPane(commandBox.getGUIComponent());
		gui.addCommandHistoryBoxBorderPane(commandHistoryBox.getGUIComponent());
		gui.addDrawerBorderPane(drawer.getGUIComponent());
		gui.addVariableHistoryBoxBorderPane(variableHistoryBox.getGUIComponent());
		gui.addHelpButtonBorderPane(helpButton.getGUIComponent());
	}
	
    @Override
	public void passCommand(String command, String language){
        List<NodeI> newTree = parser.parseString(command, language);
        parser.makeTree(newTree);
    }

    @Override
    public void clearVariableBox(){
		variableHistory.clearHistory();
    }

    @Override
    public void clearCommandHistoryBox() {
		commandHistory.clearHistory();
    }

	@Override
	public void setPenColor(Color color) {
		turtle.setPenColor(color);
	}

}
