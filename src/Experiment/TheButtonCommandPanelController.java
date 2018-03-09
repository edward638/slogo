package Experiment;

import parsers.Parser;
import view.GUI;
import view.screen_components.PenControlPanel;
import view.screen_components.TurtleControlPanel;

import java.util.function.Consumer;

public class TheButtonCommandPanelController extends TheController implements TheParserActionDelegate {
    private Parser parser;
    private TurtleControlPanel turtleControlPanel;
    private PenControlPanel penControlPanel;
    public TheButtonCommandPanelController(GUI gui, Parser parser){
        super(gui);
        this.parser = parser;
    }

    @Override
    protected void initializeScreenComponents() {
        turtleControlPanel = new TurtleControlPanel();
        penControlPanel = new PenControlPanel();
    }

    @Override
    protected void setUpConnections() {
        turtleControlPanel.setController(this);
        penControlPanel.setController(this);
    }

    @Override
    protected void addToGUI() {
        super.getGui().addToScreen(turtleControlPanel);
        super.getGui().addToScreen(penControlPanel);
    }

    @Override
    public void performParserAction(Consumer<Parser> p){
        p.accept(parser);
    }
}
