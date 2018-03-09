package view.screen_components;

import controller.ParserActionDelegate;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import propertiesFiles.ResourceBundleManager;

public class PenControlPanel extends ScreenComponent{
    private ParserActionDelegate parserActionDelegate;
    private Button penUpButton;
    private Button penDownButton;
    private Button smallPenButton;
    private Button medPenButton;
    private Button largePenButton;

    public PenControlPanel(){
        super();
    }

    public void setController(ParserActionDelegate parserActionDelegate){
        this.parserActionDelegate = parserActionDelegate;
    }

    @Override
    protected void mapUserActions() {
        penUpButton.setOnAction((event -> {
            parserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseActionCommand(ResourceBundleManager.retrieveOnScreenCommand("PENUP"))));
        }));
        penDownButton.setOnAction((event -> {
            parserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseActionCommand(ResourceBundleManager.retrieveOnScreenCommand("PENDOWN"))));
        }));
        smallPenButton.setOnAction((event -> {
            parserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseActionCommand(ResourceBundleManager.retrieveOnScreenCommand("SMALL_FONT"))));
        }));
        medPenButton.setOnAction((event -> {
            parserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseActionCommand(ResourceBundleManager.retrieveOnScreenCommand("MED_FONT"))));
        }));
        largePenButton.setOnAction((event -> {
            parserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseActionCommand(ResourceBundleManager.retrieveOnScreenCommand("LARGE_FONT"))));
        }));
    }

    @Override
    public void generateGUIComponent() {
        BorderPane borderPane = super.getBorderPane();
        penUpButton = new Button(ResourceBundleManager.retrieveOnScreenCommand("UP_BUTTON"));
        penDownButton = new Button(ResourceBundleManager.retrieveOnScreenCommand("DOWN_BUTTON"));
        smallPenButton = new Button(ResourceBundleManager.retrieveOnScreenCommand("SMALL_BUTTON"));
        medPenButton = new Button(ResourceBundleManager.retrieveOnScreenCommand("MED_BUTTON"));
        largePenButton = new Button(ResourceBundleManager.retrieveOnScreenCommand("LARGE_BUTTON"));
        VBox vbox = new VBox();
        vbox.getChildren().add(penUpButton);
        vbox.getChildren().add(penDownButton);
        vbox.getChildren().add(smallPenButton);
        vbox.getChildren().add(medPenButton);
        vbox.getChildren().add(largePenButton);
        borderPane.setCenter(vbox);
    }
}
