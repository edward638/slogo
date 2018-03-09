package view.screen_components;

import controller.ParserActionDelegate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import propertiesFiles.ResourceBundleManager;
import view.factories.ComboBoxFactory;

public class CommandBox extends ScreenComponent{
	private static final String[] LANGUAGE_LIST = {"English", "Chinese"};
	private Button commandClearButton;
    private Button commandRunButton;
    private TextArea commandTextArea;
    private Label commandLabel;
    private ComboBox<String> languageBox;
    private ParserActionDelegate parserActionDelegate;
	private final int COMMAND_ROWS = 4;
	private final int COMMAND_COLUMNS = 30;

	public CommandBox() {
		super();
	}

	public void setController(ParserActionDelegate parserActionDelegate){
		this.parserActionDelegate = parserActionDelegate;
	}

	@Override
	protected void mapUserActions() {
		commandClearButton.setOnAction((event -> {
			commandTextArea.clear();
		}));
		commandRunButton.setOnAction((event -> {
			parserActionDelegate.performParserAction(parser -> parser.makeTree(parser.parseString(commandTextArea.getText().trim())));
			commandTextArea.clear();
		}));
		languageBox.valueProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				changeLanguage();
			}
		});
	}

	public void generateGUIComponent(){
		BorderPane borderPane = super.getBorderPane();
		this.addInputMenu(borderPane);
		this.addConsoleWindow(borderPane);
		commandLabel = new Label(ResourceBundleManager.retrieveLabel("COMMAND_LABEL_TEXT"));
		borderPane.setTop(commandLabel);
	}
	
	private void addConsoleWindow(BorderPane borderPane){
		commandTextArea = new TextArea();
		commandTextArea.setPrefRowCount(COMMAND_ROWS);
		commandTextArea.setPrefColumnCount(COMMAND_COLUMNS);
		borderPane.setCenter(commandTextArea);
	}
	
	private void addInputMenu(BorderPane borderPane){
		VBox rightComponent = new VBox();
		commandRunButton = new Button(ResourceBundleManager.retrieveButtonLabel("COMMAND_RUN_BUTTON_LABEL"));
		commandClearButton = new Button(ResourceBundleManager.retrieveButtonLabel("COMMAND_CLEAR_BUTTON_LABEL"));
		languageBox = ComboBoxFactory.generateStringComboBox(LANGUAGE_LIST);
		rightComponent.getChildren().add(commandRunButton);
		rightComponent.getChildren().add(commandClearButton);
		rightComponent.getChildren().add(languageBox);
		borderPane.setRight(rightComponent);
	}

	private void changeLanguage(){
    	parserActionDelegate.performParserAction(parser -> parser.setLanguage(languageBox.getValue()));
	}
}
