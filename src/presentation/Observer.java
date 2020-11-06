package presentation;

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;


public class Observer extends Application{
	public static Scene escena;
	private static VistaObserver pane;

	@Override
	public void start(Stage primaryStage) {
		pane = new VistaObserver();
		
		escena = new Scene(pane.getRoot(), 400, 350);		
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("Tarea01 - Aspectos");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static VistaObserver getPane() {
		return pane;
	}
	
}
