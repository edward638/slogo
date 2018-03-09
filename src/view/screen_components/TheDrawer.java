package view.screen_components;

import Experiment.ThePaletteDelegate;
import controller.DrawerController;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import model.ModelInterface;
import model.TurtleObservable;
import model.TurtlesFetcher;
import view.Observer;
import view.constants.CanvasConstants;
import view.constants.ComboBoxConstants;
import view.factories.ComboBoxFactory;

import java.util.ArrayList;
import java.util.List;

public class TheDrawer extends ScreenComponent implements Observer{
    public static final double CANVAS_WIDTH = 450;
    public static final double CANVAS_HEIGHT = 450;
    private static final int VERTICAL_INSET = 10;
    private static final int HORIZONTAL_INSET = 20;

    //other turtle images taken from:
    // https://pixabay.com/en/turtle-animal-reptile-water-green-294522/
    // https://pixabay.com/en/sea-turtle-floral-flowers-2952470/

    private ComboBox<String> backgroundColorBox;
    private ComboBox<String> penColorBox;
    private ComboBox<String> turtleImageBox;

    private TurtlesFetcher turtlesFetcher;
    private List<TheDrawerTurtleComponent> turtlesOnScreen;
    private List<TurtleObservable> linkedTurtles;
    private TheDrawerBackgroundComponent backgroundComponent;

    private ThePaletteDelegate thePaletteDelegate;

    private StackPane drawingScreen;
    private Canvas linesLayer;
    private Canvas backgroundLayer;

    public TheDrawer(){
        super();
        linkedTurtles = new ArrayList<>();
        turtlesOnScreen = new ArrayList<>();
    }

    public void setTurtlesFetcher(TurtlesFetcher turtlesFetcher){
        this.turtlesFetcher = turtlesFetcher;
        this.update();
    }

    public void setThePaletteDelegate(ThePaletteDelegate thePaletteDelegate){
        this.thePaletteDelegate = thePaletteDelegate;
    }

    @Override
    protected void mapUserActions() {
        backgroundColorBox.valueProperty().addListener((observable, oldValue, newValue) -> changeBackgroundColor());
        turtleImageBox.valueProperty().addListener((observable, oldValue, newValue) -> changeTurtleImage());
        penColorBox.valueProperty().addListener((observable, oldValue, newValue) -> changePenColor());
    }

    public void generateGUIComponent(){
        BorderPane borderPane = super.getBorderPane();
        borderPane.setPadding(new Insets(VERTICAL_INSET, HORIZONTAL_INSET, VERTICAL_INSET, HORIZONTAL_INSET));
        generateListOptions(borderPane);
        generateDrawingScreen(borderPane);
    }

    private void generateDrawingScreen(BorderPane borderPane){
        drawingScreen = new StackPane();
        linesLayer = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        backgroundLayer = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        backgroundComponent = new TheDrawerBackgroundComponent(backgroundLayer);
        backgroundComponent.changeBackgroundColor(Color.WHITE);
        drawingScreen.getChildren().add(backgroundLayer);
        drawingScreen.getChildren().add(linesLayer);
        borderPane.setCenter(drawingScreen);
    }

    private void generateListOptions(BorderPane borderPane){
        HBox hbox = new HBox();
        backgroundColorBox = ComboBoxFactory.generateComboBox(ComboBoxFactory.BACKGROUND_COLOR_LIST);
        penColorBox = ComboBoxFactory.generateComboBox(ComboBoxFactory.PEN_COLOR_LIST);
        turtleImageBox = ComboBoxFactory.generateComboBox(ComboBoxFactory.TURTLE_IMAGE_LIST);
        hbox.getChildren().addAll(backgroundColorBox,penColorBox,turtleImageBox);
        borderPane.setBottom(hbox);
    }

    private void changeBackgroundColor(){
        String color = backgroundColorBox.getValue();
        switch (color){
            case "White": thePaletteDelegate.changeBackgroundColor(Color.WHITE);
            case "Blue": thePaletteDelegate.changeBackgroundColor(Color.BLUE);
        }
    }

    private void changePenColor(){
        String color = backgroundColorBox.getValue();
        switch (color){
            case "Black": thePaletteDelegate.changeBackgroundColor(Color.BLACK);
            case "Red": thePaletteDelegate.changeBackgroundColor(Color.RED);
            case "Green": thePaletteDelegate.changeBackgroundColor(Color.GREEN);
        }
    }

    private void changeTurtleImage(){
        thePaletteDelegate.changeTurtleImage(turtleImageBox.getValue());
    }

    private void addFrontEndTurtle(TurtleObservable turtleObservable){
        linkedTurtles.add(turtleObservable);
        turtlesOnScreen.add(new TheDrawerTurtleComponent(turtleObservable, drawingScreen, linesLayer));
    }

    public void update(){
        for(TurtleObservable turt : turtlesFetcher.getTurtleObservables()){
            if(!linkedTurtles.contains(turt)){
                this.addFrontEndTurtle(turt);
            }
        }
    }

    @Override
    public void notifyOfChanges() {
        update();
    }
}
