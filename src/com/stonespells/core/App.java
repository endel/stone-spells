package com.stonespells.core;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
 

/**
 * Classe que trata da inicializa��o da midlet
 *
 */
public class App extends MIDlet{
	
	private boolean started = false; 
	
	private GameFacade facade;
	
	public static final int WIDTH = 176;
	public static final int HEIGHT = 220;
	
	/**
	 * M�todo chamado quando a midlet deve ser destruida.
	 */
	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		
	}

	/**
	 * M�todo utilizado para pausar a inst�ncia da fa�ade.
	 */
	protected void pauseApp() {
		facade.pause(this);
	}
	
	/**
	 * Inicia o jogo. Se n�o � inst�ncia de fa�ade, ent�o fa�ado � instanciada.
	 */
	protected void startApp() throws MIDletStateChangeException {
		if (!started) {
			facade = (GameFacade) (GameFacade.getInstance());
			facade.startup(this);
			started = true;
		}
	}
}