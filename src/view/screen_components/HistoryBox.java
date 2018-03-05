package view.screen_components;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.List;

public abstract class HistoryBox extends ScreenComponent{
	private String historyBoxLabel;
	private String buttonLabel;
	private int rows;
	private int cols;
	private Button button;
	private TextArea textArea;
	public HistoryBox() {
		super();
	}
	
	protected void setUpLabels(String historyBoxLabel, String buttonLabel){
		this.historyBoxLabel = historyBoxLabel;
		this.buttonLabel = buttonLabel;
	}
	
	protected void setDimensions(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
	}
	
	protected Button getButton(){
		return button;
	}
	protected TextArea getTextArea(){
		return textArea;
	}
	
	public void generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		this.addButtonAndLabels(borderPane);
		this.addTextArea(borderPane);
	}
	
	private void addButtonAndLabels(BorderPane borderPane){
		HBox topComponent = new HBox();
		//topComponent.setSpacing(HBOX_SPACING);
		button = new Button(buttonLabel);
		Label label = new Label(historyBoxLabel);
		topComponent.getChildren().add(label);
		topComponent.getChildren().add(button);
		borderPane.setTop(topComponent);
	}
	
	private void addTextArea(BorderPane borderPane){
		textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setPrefRowCount(rows);
		textArea.setPrefColumnCount(cols);
		borderPane.setCenter(textArea);
	}

	protected void fillBox(List<String> commands){
		StringBuilder commandsToDisplay = new StringBuilder();
		for(String s: commands){
			commandsToDisplay.append(s);
			commandsToDisplay.append("\n");
		}
		textArea.setText(commandsToDisplay.toString());
	}
	
}
