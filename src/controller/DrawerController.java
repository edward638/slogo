package controller;

import javafx.scene.paint.Color;

public interface DrawerController {
    public void setPenColor(Color color);
    public void passCommand(String command, String language);
}
