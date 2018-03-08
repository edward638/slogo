package view.screen_components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.w3c.dom.css.Rect;

public class Palette extends ScreenComponent {

    public static final int RECT_WIDTH = 60;
    public static final int RECT_HEIGHT = 20;
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
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setSpacing(10);
        Label title = new Label("Color Palette");
        vBox.getChildren().add(title);
        updatePalette();
        borderPane.setCenter(vBox);
    }

    public void updatePalette(){
        colorList = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                                Color.BLUE, Color.INDIGO, Color.VIOLET};
        for (int x = 0; x< colorList.length; x++){
            HBox temp = new HBox();
            Label number = new Label(Integer.toString(x));
            Rectangle r = new Rectangle();
            r.setWidth(RECT_WIDTH);
            r.setHeight(RECT_HEIGHT);
            r.setFill(colorList[x]);
            temp.getChildren().addAll(number, r);
            vBox.getChildren().add(temp);
        }
    }


}
