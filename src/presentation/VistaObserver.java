package presentation;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.ManejadorBoton;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class VistaObserver {
	private HBox root;
	private Button boton1;
	private Button boton2;
	private Button boton3;
	
	private ComboBox<String> comboBox;
	private Label label;
	
	
	
	public VistaObserver() {
		root = new HBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		crearSeccionBotones();
		crearComboBox(); //
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
	//
	private void crearComboBox() {
		comboBox= new ComboBox<>();
		label= new Label();
		
		comboBox.setPromptText("choose");
		comboBox.getItems().add("saluda");
		comboBox.getItems().add("despide");
		
		root.getChildren().addAll(comboBox,label);
		
	}
	public void cambiarComboBoxSaluda() {
		Observer.getPane().getLabel().setText("Hola");
	
	}
	public void cambiarComboBoxDespide() {
		Observer.getPane().getLabel().setText("Adios");
	
	}
	
	//
	
	
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
	
	public ComboBox<String> getComboBox() {
		return comboBox;
	}
	public Label getLabel() {
		return label;
	}
	
	
}
