package view.factories;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TitleFactory {
	public static final int TITLE_Y = 25;
    public static final int TITLE_X = 525;
    public static final int TITLE_WIDTH = 200;
    public static final int TITLE_HEIGHT = 350;
    public static final String SLOGO_IMAGE = "SLogo.PNG";

	public static ImageView generateTitle(Image titleImage){
		ImageView title = new ImageView(titleImage);
        title.setX(TITLE_X);
        title.setY(TITLE_Y);
        title.setPreserveRatio(true);
        title.setFitWidth(TITLE_WIDTH);
        title.setFitHeight(TITLE_HEIGHT);
        return title;
	}
}
