package Experiment;

import javafx.stage.Stage;
import model.CommandHistory;
import model.Model;
import model.VariablesHistory;
import parsers.Parser;
import view.GUI;
import view.screen_components.*;

import java.util.ArrayList;
import java.util.List;

public class TheWorkspace {
    private GUI gui;
    private Parser parser;
    private CommandHistory commandHistory;
    private VariablesHistory variableHistory;
    private Model model;
    private Stage stage;

    private List<TheController> controllerList;

    public TheWorkspace(Stage stage){
        gui = new GUI();
        this.initializeModelElements();
        this.createControllers();
        this.initializeControllers();
        this.stage = stage;
    }

    private void initializeModelElements(){
        this.model = new Model(TheDrawer.CANVAS_WIDTH, TheDrawer.CANVAS_HEIGHT);
        this.commandHistory = new CommandHistory();
        this.variableHistory = new VariablesHistory();
        this.parser = new Parser(model, variableHistory, commandHistory);
    }

    private void createControllers(){
        controllerList = new ArrayList<>();
        controllerList.add(new TheButtonCommandPanelController(gui, parser));
        controllerList.add(new TheVariableHistoryBoxController(gui, variableHistory));
        controllerList.add(new ThePaletteController(gui, model));
        controllerList.add(new TheDrawerController(gui, model,parser));
        controllerList.add(new TheCustomCommandBoxController(gui, variableHistory, parser));
        controllerList.add(new TheCommandHistoryBoxController(gui, commandHistory, parser));
        controllerList.add(new TheCommandBoxController(gui, parser));
    }

    private void initializeControllers(){
        for(TheController controller : controllerList){
            controller.initializeScreenComponents();
            controller.setUpConnections();
            controller.addToGUI();
        }
    }

    public void startUp(){
        gui.start(stage);
    }
}
