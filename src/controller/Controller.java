package controller;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.*;
import nodes.NodeInterface;
import parsers.Parser;
import view.GUI;
import view.screen_components.*;

public class Controller implements CommandController, DrawerController, CommandHistoryController, VariableHistoryController{
	private GUI gui;
	private Turtle turtle;
	private Parser parser;
	private CommandHistory commandHistory;
	private VariablesHistory variableHistory;
	private Drawer drawer;
	private CommandBox commandBox;
	private CommandHistoryBox commandHistoryBox;
	private VariableHistoryBox variableHistoryBox;
	private HelpButton helpButton;
	private Model model;
	
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
		//turtle = new Turtle(Drawer.CANVAS_WIDTH, Drawer.CANVAS_HEIGHT, Drawer.INITIAL_PEN_COLOR);
		model = new Model(Drawer.CANVAS_WIDTH, Drawer.CANVAS_HEIGHT);
        commandHistory = new CommandHistory();
        variableHistory = new VariablesHistory();
		parser = new Parser(model, variableHistory, commandHistory);
	}

	private void setUpConnections(){
		for (Turtle turtle: model.getActiveTurtles())
		{
			turtle.addObserver(drawer);
			drawer.setTurtle(turtle);
			drawer.update();
		}
		variableHistoryBox.setVariableHistory(variableHistory);
		commandHistoryBox.setCommandHistory(commandHistory);
		commandHistory.addObserver(commandHistoryBox);
		variableHistoryBox.setVariableHistory(variableHistory);
		variableHistory.addObserver(variableHistoryBox);
	}

	private void initializeScreenComponents(){
		drawer = new Drawer();
		drawer.setController(this);
		commandBox = new CommandBox();
		commandBox.setController(this);
		commandHistoryBox = new CommandHistoryBox();
		commandHistoryBox.setCommandHistoryController(this);
		commandHistoryBox.setCommandController(this);
		variableHistoryBox = new VariableHistoryBox();
		variableHistoryBox.setController(this);
		helpButton = new HelpButton();
	}

	private void addToGUI(){
		gui.addCommandBoxBorderPane(commandBox.getGUIComponent());
		gui.addCommandHistoryBoxBorderPane(commandHistoryBox.getGUIComponent());
		gui.addDrawerBorderPane(drawer.getGUIComponent());
		gui.addVariableHistoryBoxBorderPane(variableHistoryBox.getGUIComponent());
		gui.addHelpButtonBorderPane(helpButton.getGUIComponent());
	}
	
    @Override
	public void passCommand(String command){
        List<NodeInterface> newTree = parser.parseString(command);
        parser.makeTree(newTree);
    }

    @Override
    public void clearVariableBox(){
		variableHistory.clearHistory();
    }

	@Override
	public void changeVariableValue(String variableName, String value) {
		System.out.println(variableName);
		variableHistory.changeValue(variableName, value);
	}

	@Override
    public void clearCommandHistoryBox() {
		commandHistory.clearHistory();
    }

	@Override
	public void setPenColor(Color color) {
		//turtle.setPenColor(color);
	}

	public void toggleActive(int ID) {
		//TODO: find a turtle with specific ID in backend, make it active/inactive
	}
}
