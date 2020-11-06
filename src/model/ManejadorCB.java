package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import presentation.Observer;

public class ManejadorCB implements EventHandler<ActionEvent>{
	private ComboBox<String> comboBox;
	private Label label;
	
	public ManejadorCB(ComboBox<String> comboBox) {
		super();
		this.comboBox=comboBox;
	}

	@Override
	public void handle(ActionEvent ae) {
		if(comboBox.getItems().equals("saluda")) {
			label.setText("Hola");
		}
		if (comboBox.getItems().equals("despide")) {
			label.setText("Adios");
		}
		

}
	
}