package presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.ManejadorBoton;
import model.ManejadorCB;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class VistaObserver {
	private VBox root;
	private Button boton1;
	private Button boton2;
	private Button boton3;
	
	private ComboBox<String> comboBox;
	private Label label;
	public static HBox sectMensaje;
	
	
	
	public VistaObserver() {
		root = new VBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		crearSeccionBotones();
		crearComboBox(); //
	}
	
	private void crearSeccionBotones() {
		HBox sectBtn = new HBox();
		sectBtn.setSpacing(10);
		sectBtn.setAlignment(Pos.CENTER);
		
		boton1 = new Button("Boton 1");
		boton1.setOnAction(new ManejadorBoton(boton1,"CYAN"));
		
		boton2 = new Button("Boton 2");
		boton2.setOnAction(new ManejadorBoton(boton2,"LIGHTGREEN"));
		
		boton3 = new Button("Boton 3");
		boton3.setOnAction(new ManejadorBoton(boton3,"YELLOW"));
		
	
		sectBtn.getChildren().addAll(boton1, boton2, boton3);
		root.getChildren().add(sectBtn);
		
		
	}
	//
	private void crearComboBox() {
		comboBox= new ComboBox<>();
		label= new Label();
		
		sectMensaje = new HBox();
		sectMensaje.setAlignment(Pos.CENTER);
		sectMensaje.setBackground(new Background(new BackgroundFill(Color.VIOLET,new CornerRadii(1),null)));
		sectMensaje.setBorder(new Border(new BorderStroke(Color.BLACK, null, null, BorderWidths.FULL)));
		
		label.setText("...");
		label.setPadding(new Insets(10, 10, 10, 10));		
		label.setBorder(new Border(new BorderStroke(Color.BLACK, null, null, BorderWidths.FULL)));
		
		sectMensaje.getChildren().add(label);
		
		comboBox.setPromptText("choose");
		comboBox.getItems().add("saluda");
		comboBox.getItems().add("despide");
		
		comboBox.setOnAction(new ManejadorCB(comboBox,label));
		
		root.getChildren().addAll(comboBox,sectMensaje);
		
	}

	
	//
	
	
	public VBox getRoot() {
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
