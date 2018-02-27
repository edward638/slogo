package controller;

import javafx.scene.paint.Color;

public interface ControllerInterface {
	public void passCommand(String command, String language);
    public void clearVariableBox();
    public void clearCommandHistoryBox();
    public void setPenColor(Color color);
}
