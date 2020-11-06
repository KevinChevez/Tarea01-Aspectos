package model;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import presentation.Observer;
import presentation.VistaConfirmacion;
import presentation.VistaObserver;
import javafx.scene.control.Label;

public aspect Aspect {
	String color;
	boolean pint;
	
	pointcut antes() : call (* cambiarColor*(..));
    before() : antes(){
    	System.out.println("*Ejecución del pointcut* - Entra al pointcut (before) que \nencuentra a cambiarColor y establece el color selecionado\n");
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
		System.out.println("*Ejecución del pointcut* - Entra al pointcut pintar y modifica el boolean pint\n");
	}
	
    
	pointcut success() : call (* cambiarColor*(..));
    after() : success(){
    	if (pint) {
	    	System.out.println("*Ejecución del pointcut* - Cambio de color en pantalla");
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
	    	System.out.println("*Ejecución del pointcut* - No se cambia el color\n");
	    }
   }
    
    pointcut post() : call (* cambiarComboBox*(..));
    after() : post(){
    	String cb = thisJoinPoint.toShortString();
    	VistaObserver pane = Observer.getPane();
    	pane.getLabel().setTextFill(Color.WHITE);
    	pane.getLabel().setBorder(new Border(new BorderStroke(Color.BLACK, null, null, BorderWidths.FULL)));
    	if(cb.contains("Saluda")) {
    		VistaObserver.sectMensaje.setBackground(new Background(new BackgroundFill(Color.GREEN,new CornerRadii(1),null)));
    		//pane.getLabel().setBackground(new Background(new BackgroundFill(Color.GREEN,new CornerRadii(1),null)));;
    		System.out.println("*Ejecución del pointcut* - Se cambia el color del mensaje saludando\n");
    	}
    	else if(cb.contains("Despide")) {
    		VistaObserver.sectMensaje.setBackground(new Background(new BackgroundFill(Color.RED,new CornerRadii(1),null)));
    		//pane.getLabel().setBackground(new Background(new BackgroundFill(Color.RED,new CornerRadii(1),null)));;
    		System.out.println("*Ejecución del pointcut* - Se cambia el color del mensaje despidiendo\n");
    	}
    }
}

