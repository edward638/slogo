package view.screen_components;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.w3c.dom.css.Rect;

public class Palette extends ScreenComponent {

    private Color[] colorList;
    private VBox vBox;
    public Palette(){
        super();
    }

    @Override
    protected void mapUserActions() {

    }

    @Override
    protected void generateGUIComponent() {
        BorderPane borderPane = super.getBorderPane();
        generateVBox(borderPane);
    }

    private void generateVBox(BorderPane borderPane){
        vBox = new VBox();
        vBox.setSpacing(10);
        Label title = new Label("Color Palette");
        vBox.getChildren().add(title);
        updatePalette();
        borderPane.setCenter(vBox);
    }

    public void updatePalette(){
        colorList = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW};
        for (int x = 0; x< colorList.length; x++){
            HBox temp = new HBox();
            Label number = new Label(Integer.toString(x));
            Rectangle r = new Rectangle();
            r.setWidth(60);
            r.setHeight(20);
            r.setFill(colorList[x]);
            temp.getChildren().addAll(number, r);
            vBox.getChildren().add(temp);
        }
    }


}
