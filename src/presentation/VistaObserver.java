package presentation;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.ManejadorBoton;

public class VistaObserver {
	private HBox root;
	private Button boton1;
	private Button boton2;
	private Button boton3;
	
	public VistaObserver() {
		root = new HBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		crearSeccionBotones();
	}
	
	private void crearSeccionBotones() {
		boton1 = new Button("Boton 1");
		boton1.setOnAction(new ManejadorBoton(boton1,"CYAN"));
		
		boton2 = new Button("Boton 2");
		boton2.setOnAction(new ManejadorBoton(boton2,"LIGHTGREEN"));
		
		boton3 = new Button("Boton 3");
		boton3.setOnAction(new ManejadorBoton(boton3,"YELLOW"));
				
		root.getChildren().addAll(boton1, boton2, boton3);
	}
	
	
	public HBox getRoot() {
		return root;
	}

	public Button getBoton1() {
		return boton1;
	}

	public Button getBoton2() {
		return boton2;
	}

	public Button getBoton3() {
		return boton3;
	}
	
}
