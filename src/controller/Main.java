package controller;

import Experiment.TheWorkspace;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ModelInterface;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Controller controller = new Controller(primaryStage);
		TheWorkspace theWorkspace = new TheWorkspace(primaryStage);
		theWorkspace.startUp();
	}

	public static void main(String[] args){
		Application.launch(args);
	}
}
