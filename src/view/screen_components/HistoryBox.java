package view.screen_components;

import controller.ControllerInterface;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public abstract class HistoryBox extends ScreenComponent{
	public static final int HBOX_SPACING = 50;
	private String historyBoxLabel;
	private String buttonLabel;
	private int rows;
	private int cols;
	public HistoryBox(ControllerInterface controller) {
		super(controller);
	}
	
	protected void setUpLabels(String historyBoxLabel, String buttonLabel){
		this.historyBoxLabel = historyBoxLabel;
		this.buttonLabel = buttonLabel;
	}
	
	protected void setDimensions(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
	}
	
	public BorderPane generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		TextArea textArea = this.getTextArea();
		borderPane.setTop(this.getTopComponent());
		borderPane.setCenter(textArea);
		return borderPane;
	}
	
	private HBox getTopComponent(){
		HBox topComponent = new HBox();
		topComponent.setSpacing(HBOX_SPACING);
		Button button = new Button(buttonLabel);
		Label label = new Label(historyBoxLabel);
		topComponent.getChildren().add(label);
		topComponent.getChildren().add(button);
		return topComponent;
	}
	
	private TextArea getTextArea(){
		TextArea textArea = new TextArea();
		textArea.setPrefRowCount(rows);
		textArea.setPrefColumnCount(cols);
		return textArea;
	}
	
}
