package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import presentation.Observer;

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
		if(name == "CYAN") {
			cambiarColorCyan();
			boton.setText("CYAN Activated");
		}
		if(name == "LIGHTGREEN") {
			cambiarColorLightGreen();
			boton.setText("LIGHTGREEN Activated");
		}
		if(name == "YELLOW") {
			cambiarColorYellow();
			boton.setText("YELLOW Activated");
		}
		
	}
	
	
	public void cambiarColorCyan() {
		Observer.getPane().getRoot().setBackground(new Background(new BackgroundFill(Color.CYAN,new CornerRadii(1),null)));
	}
	
	public void cambiarColorLightGreen() {
		Observer.getPane().getRoot().setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN,new CornerRadii(1),null)));
	}
	
	public void cambiarColorYellow() {
		Observer.getPane().getRoot().setBackground(new Background(new BackgroundFill(Color.YELLOW,new CornerRadii(1),null)));
	}
	
}
