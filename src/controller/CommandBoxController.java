package controller;

import parsers.Parser;
import view.GUI;
import view.screen_components.CommandBox;

import java.util.function.Consumer;

public class CommandBoxController extends Controller implements ParserActionDelegate {
    private Parser parser;
    private CommandBox commandBox;
    public CommandBoxController(GUI gui, Parser parser){
        super(gui);
        this.parser = parser;
    }

    @Override
    protected void initializeScreenComponents() {
        commandBox = new CommandBox(this);
    }

    @Override
    protected void setUpConnections() {
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
