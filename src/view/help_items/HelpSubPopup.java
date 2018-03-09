package view.help_items;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelpSubPopup {
    Group popupRoot;
    Stage popupStage;

    public HelpSubPopup (Image image, String string){
        popupRoot = new Group();
        popupStage = new Stage();
        popupStage.setTitle(string);
        popupStage.setScene(new Scene(popupRoot, (int)image.getWidth(),(int)image.getHeight()));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        popupRoot.getChildren().add(imageView);
    }
    public void show(){
        popupStage.show();
    }
}
