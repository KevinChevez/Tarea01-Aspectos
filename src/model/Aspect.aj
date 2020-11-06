package model;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import presentation.Observer;
import presentation.VistaConfirmacion;
import presentation.VistaObserver;
import javafx.scene.control.Label;

public aspect Aspect {
	String color;
	boolean pint;
	Label label;
	
	pointcut antes() : call (* cambiarColor*(..));
    before() : antes(){
    	String text = thisJoinPoint.toShortString();
    	VistaObserver pane = Observer.getPane();
    	if(text.contains("Cyan")) {
    		color = "Cyan";
    	}
    	else if(text.contains("LightGreen")) {
    		color = "LightGreen";
    	}
    	else if(text.contains("Yellow")) {
    		color = "Yellow";
    	}
    }
	
    pointcut entre() : call (* pintar*(..));
	before() : entre(){
		String firma = thisJoinPoint.toShortString();
		if(firma.contains("Si")) this.pint = true;
		else this.pint = false;
		//System.out.println("Entra al pointcut pintar");
	}
	
    
	pointcut success() : call (* cambiarColor*(..));
    after() : success(){
    	if (pint) {
	    	System.out.println("Cambio de color en pantalla");
	    	VistaObserver pane = Observer.getPane();
	    	if(color =="Cyan") {
	    		/*pane.getBoton2().setText("Boton 2");
	    		pane.getBoton3().setText("Boton 3");*/
	    		System.out.println("COLOR ACTUAL: CYAN\n");
	    	}
	    	else if(color=="LightGreen") {
	    		/*pane.getBoton1().setText("Boton 1");
	    		pane.getBoton3().setText("Boton 3");*/
	    		System.out.println("COLOR ACTUAL: LIGHTGREEN\n");
	    	}
	    	else if(color=="Yellow") {
	    		/*pane.getBoton1().setText("Boton 1");
	    		pane.getBoton2().setText("Boton 2");*/
	    		System.out.println("COLOR ACTUAL: YELLOW\n");
	    	}
	    }else {
	    	System.out.println("No se cambia el color\n");
	    }
   }
    
    pointcut post() : call (* cambiarComboBox*(..));
    before() : post(){
    	String cb = thisJoinPoint.toShortString();
    	VistaObserver pane = Observer.getPane();
    	if(cb.contains("saluda")) {
    		label="Hola";
    	}
    	else if(cb.contains("LightGreen")) {
    		label = "Adios";
    	}
    }

