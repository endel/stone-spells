package com.stonespells.core;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
 
import com.stonespells.facade.GameFacade;

public class App extends MIDlet{
	
	private boolean started = false; 
	
	private GameFacade facade;
	
	public static final int WIDTH = 176;
	public static final int HEIGHT = 220;
	
	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		
	}

	protected void pauseApp() {
		facade.pause(this);
	}
	
	/**
	 * Inicia o jogo
	 */
	protected void startApp() throws MIDletStateChangeException {
		if (!started) {
			facade = (GameFacade) (GameFacade.getInstance());
			facade.startup(this);
			started = true;
		}
	}
}