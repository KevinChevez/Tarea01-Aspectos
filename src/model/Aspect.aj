package model;

import presentation.Observer;
import presentation.VistaObserver;

public aspect Aspect {
	
	pointcut success() : call (* cambiarColor*(..));
    after() : success(){
    	System.out.println("Cambio de color en pantalla");
    	String text = thisJoinPoint.toShortString();
    	VistaObserver pane = Observer.getPane();
    	if(text.contains("Cyan")) {
    		pane.getBoton2().setText("Boton 2");
    		pane.getBoton3().setText("Boton 3");
    		System.out.println("COLOR ACTUAL: CYAN\n");
    	}
    	if(text.contains("LightGreen")) {
    		pane.getBoton1().setText("Boton 1");
    		pane.getBoton3().setText("Boton 3");
    		System.out.println("COLOR ACTUAL: LIGHTGREEN\n");
    	}
    	if(text.contains("Yellow")) {
    		pane.getBoton1().setText("Boton 1");
    		pane.getBoton2().setText("Boton 2");
    		System.out.println("COLOR ACTUAL: YELLOW\n");
    	}
    }
}
