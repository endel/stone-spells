package com.stonespells.core;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
 

/**
 * Classe que trata da inicialização da midlet
 *
 */
public class App extends MIDlet{
	
	private boolean started = false; 
	
	private GameFacade facade;
	
	public static final int WIDTH = 176;
	public static final int HEIGHT = 220;
	
	/**
	 * Método chamado quando a midlet deve ser destruida.
	 */
	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		
	}

	/**
	 * Método utilizado para pausar a instância da façade.
	 */
	protected void pauseApp() {
		facade.pause(this);
	}
	
	/**
	 * Inicia o jogo. Se não é instância de façade, então façado é instanciada.
	 */
	protected void startApp() throws MIDletStateChangeException {
		if (!started) {
			facade = (GameFacade) (GameFacade.getInstance());
			facade.startup(this);
			started = true;
		}
	}
}