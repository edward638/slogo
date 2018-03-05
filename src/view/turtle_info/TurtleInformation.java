package view.turtle_info;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Turtle;


public class TurtleInformation {
    public static final int STAGE_WIDTH = 350;
    public static final int STAGE_HEIGHT = 350;
    private Stage helpStage;
    private Group helpRoot;
    private TableView table;

    public TurtleInformation(){
        helpRoot = new Group();
        helpStage = new Stage();
        helpStage.setTitle("Turtle Information");
        Scene startScene = new Scene(helpRoot, STAGE_WIDTH, STAGE_HEIGHT);
        addTable();
        helpStage.setScene(startScene);
        helpStage.show();
    };

    private void addTable(){
        table = new TableView();
        TableColumn propertyColumn = new TableColumn("Property");
        TableColumn valueColumn = new TableColumn("Value");
        propertyColumn.setMinWidth(175);
        valueColumn.setMinWidth(175);
        table.getColumns().addAll(propertyColumn, valueColumn);
        helpRoot.getChildren().add(table);
    }
}
