package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import model.Turtle;

public class TurtleInformationTable extends ScreenComponent{

    private TableView table;

    public TurtleInformationTable(ControllerInterface controller) {
        super(controller);
    }


    @Override
    protected void mapUserActions() {

    }

    @Override
    protected void generateGUIComponent() {
        BorderPane borderPane = super.getBorderPane();
    }

    private void addTableView(BorderPane borderPane){

    }


}
