package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import presentation.Observer;
import presentation.VistaConfirmacion;

public class ManejadorBoton implements EventHandler<ActionEvent>{
	private Button boton;
	private String name;
	
	public ManejadorBoton(Button boton, String name) {
		super();
		this.boton=boton;
		this.name = name;
	}
	
	
	@Override
	public void handle(ActionEvent ae) {
		VistaConfirmacion view = new VistaConfirmacion(name);
    	view.cambiarPantalla();
	}
	
	
	
	
}