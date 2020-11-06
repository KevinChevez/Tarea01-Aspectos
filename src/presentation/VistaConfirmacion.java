package presentation;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.ManejadorBoton;
import presentation.Observer;

public class VistaConfirmacion {
	private VBox root;
	private Label mensaje;
	private Button btnConfirmar;
	private Button btnDenegar;
	private String color;
	
	public static boolean pintar;
	
	public VistaConfirmacion(String color) {
		this.color=color;
		
		root = new VBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);		
				
		crearVentana();
	}
	
	private HBox crearSeccionBotones() {
		HBox sectionBtn = new HBox();
		
		btnConfirmar = new Button("Si");
		btnConfirmar.setOnMouseClicked((MouseEvent e)->{
				//System.out.println("Aplasta SI");
				pintarSi();
				changeColor();
				regresarPantalla();
			}
		);
		
		btnDenegar = new Button("No");
		btnDenegar.setOnMouseClicked((MouseEvent e)->{
				//System.out.println("APLASTA NO");
				pintarNo();
				changeColor();
				regresarPantalla();				
			}
		);
		
		sectionBtn.setSpacing(10);		
		sectionBtn.getChildren().addAll(btnConfirmar,btnDenegar);
		sectionBtn.setAlignment(Pos.CENTER);
		return sectionBtn;
	}
	
	private void crearVentana() {
		HBox sectionBtn = crearSeccionBotones();
		mensaje = new Label("¿Está seguro que desea cambiar el color de la pantalla a color "+color+"?");
		mensaje.setAlignment(Pos.CENTER);
		root.getChildren().addAll(mensaje,sectionBtn);
	}
	
	public VBox getRoot() {
		return this.root;
	}
	
	public Button getBtnConfirmar() {
		return this.btnConfirmar;
	}
	
	public Button getBtnDenegar() {
		return this.btnDenegar;
	}
	
	public void cambiarPantalla() {
		Observer.getPane().getRoot().getChildren().clear();
		Observer.getPane().getRoot().getChildren().add(root); //Cambio de root en la escena a nueva interfaz grafica
	}
	
	public void regresarPantalla() {
		VistaObserver vO=  new VistaObserver();
		//VistaObserver vO = Observer.getPane();
		Observer.getPane().getRoot().getChildren().clear();
		Observer.getPane().getRoot().getChildren().add(vO.getRoot());
	}
	
	private void pintarSi() {
		pintar=true;
	}
	private void pintarNo() {
		pintar=false;
	}
	
	private void changeColor() {
		if(pintar) {
			if(color == "CYAN") {
				cambiarColorCyan();
				//boton.setText("CYAN Activated");
			}
			if(color == "LIGHTGREEN") {
				cambiarColorLightGreen();
				//boton.setText("LIGHTGREEN Activated");
			}
			if(color == "YELLOW") {
				cambiarColorYellow();
				//boton.setText("YELLOW Activated");
			}
		}else {
			System.out.println("No se pinta la pantalla\n");
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
