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
	
	public ManejadorCB(ComboBox<String> comboBox, Label label) {
		super();
		this.comboBox=comboBox;
		this.label =  label;
	}

	@Override
	public void handle(ActionEvent ae) {
		System.out.println(comboBox.getValue());
		if(comboBox.getValue().equals("saluda")) {
			cambiarComboBoxSaluda();
		}
		if (comboBox.getValue().equals("despide")) {
			cambiarComboBoxDespide();
		}
		
	}
	
	public void cambiarComboBoxSaluda() {
		label.setText("Saludos cordiales estimado usuario");
	
	}
	public void cambiarComboBoxDespide() {
		label.setText("Hasta luego, esperamos volver a verlo pronto");
	
	}
	
}