package Experiment;

import parsers.Parser;
import view.GUI;
import view.screen_components.CommandBox;

import java.util.function.Consumer;

public class TheCommandBoxController extends TheController implements TheParserActionDelegate {
    private Parser parser;
    private CommandBox commandBox;
    public TheCommandBoxController(GUI gui, Parser parser){
        super(gui);
        this.parser = parser;
    }

    @Override
    protected void initializeScreenComponents() {
        commandBox = new CommandBox();
    }

    @Override
    protected void setUpConnections() {
        commandBox.setController(this);
    }

    @Override
    protected void addToGUI() {
        super.getGui().addToScreen(commandBox);
    }

    @Override
    public void performParserAction(Consumer<Parser> p) {
        p.accept(parser);
    }
}
