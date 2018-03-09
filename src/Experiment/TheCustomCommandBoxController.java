package Experiment;

import model.VariablesHistory;
import parsers.Parser;
import view.GUI;
import view.screen_components.CustomCommandsBox;

import java.util.function.Consumer;

public class TheCustomCommandBoxController extends TheController implements TheParserActionDelegate, TheClearValueDelegate{
    private VariablesHistory variablesHistory;
    private CustomCommandsBox customCommandsBox;
    private Parser parser;
    public TheCustomCommandBoxController(GUI gui, VariablesHistory variablesHistory, Parser parser){
        super(gui);
        this.variablesHistory = variablesHistory;
        this.parser = parser;
    }

    @Override
    protected void initializeScreenComponents() {
        customCommandsBox = new CustomCommandsBox();
    }

    @Override
    protected void setUpConnections() {
        customCommandsBox.setTheClearValueDelegate(this);
        customCommandsBox.setTheParserActionDelegate(this);
        customCommandsBox.setCustomCommandHolder(variablesHistory);
        variablesHistory.addCustomCommandObserver(customCommandsBox);
    }

    @Override
    protected void addToGUI() {
        super.getGui().addToScreen(customCommandsBox);
    }


    @Override
    public void performParserAction(Consumer<Parser> p) {
        p.accept(parser);
    }

    @Override
    public void clear() {
        variablesHistory.clearHistory();
    }
}
