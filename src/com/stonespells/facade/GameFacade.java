package com.stonespells.facade;
import org.puremvc.java.interfaces.IFacade;
import org.puremvc.java.patterns.facade.Facade;

import com.stonespells.controllers.CommandTranslator;
import com.stonespells.controllers.StartupCommand;
import com.stonespells.core.App;
import com.stonespells.core.Logger;

/**
 * Classe onde � criada a Facade do jogo, por onde � feita a comunica��o entre os
 * elementos do PureMVC com o restante dos elementos do jogo.
 *
 */
public class GameFacade extends Facade implements IFacade {
	
	public static final String STARTUP = "GameFacadeStartupNotification";
	public static final String PAUSE = "GameFacadePauseNotification";
	
	private App app;
	private CommandTranslator commandTranslator;
	
	/**
	 * M�todo utilizado para obter-se a inst�ncia da facade, ou, em caso dela n�o
	 * existiar, instanciar a classe.
	 */
	public static Facade getInstance() {
		if (instance == null) {
			try {
				instance = new GameFacade();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return (GameFacade) instance;
	}
	
	/**
	 * M�todo que inicializa a facade, e registra o comando de startup.
	 */
	protected void initializeFacade( ) {
		super.initializeFacade();
		registerCommand(STARTUP, StartupCommand.class);
	}
	
	/**
	 * M�todo que envia o comando j� registrado de inicializa��o para o aplicativo
	 * corrente.
	 * @param app O aplicativo corrente
	 */
	public void startup(App app) {
		Logger.instance.println("startup!");
		this.app = app;
		this.commandTranslator = new CommandTranslator();
		sendNotification(STARTUP, app, null);
	}
	
	/** 
	 * M�todo que envia o comando de pausa para o aplicativo
	 * corrente.
	 */
	public void pause(App app) {
		sendNotification(PAUSE, app, null);
	}
	/**
	 * M�todo que retorna a inst�ncia do aplicativo corrente.
	 * @return O aplicativo corrente.
	 */
	public App getApp() {
		return this.app;
	}
	
	/**
	 * M�todo que retorna o tradutor de comandos, que traduz os comandos de Canvas
	 * em comandos PureMVC.
	 * @return O tradutor de comandos
	 */
	public CommandTranslator getCommandTranslator() {
		return this.commandTranslator;
	}
	
}
