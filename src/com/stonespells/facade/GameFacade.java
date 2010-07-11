package com.stonespells.facade;
import org.puremvc.java.interfaces.IFacade;
import org.puremvc.java.patterns.facade.Facade;

import com.stonespells.controllers.CommandTranslator;
import com.stonespells.controllers.StartupCommand;
import com.stonespells.core.App;
import com.stonespells.core.Logger;

/**
 * Classe onde é criada a Facade do jogo, por onde é feita a comunicação entre os
 * elementos do PureMVC com o restante dos elementos do jogo.
 *
 */
public class GameFacade extends Facade implements IFacade {
	
	public static final String STARTUP = "GameFacadeStartupNotification";
	public static final String PAUSE = "GameFacadePauseNotification";
	
	private App app;
	private CommandTranslator commandTranslator;
	
	/**
	 * Método utilizado para obter-se a instância da facade, ou, em caso dela não
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
	 * Método que inicializa a facade, e registra o comando de startup.
	 */
	protected void initializeFacade( ) {
		super.initializeFacade();
		registerCommand(STARTUP, StartupCommand.class);
	}
	
	/**
	 * Método que envia o comando já registrado de inicialização para o aplicativo
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
	 * Método que envia o comando de pausa para o aplicativo
	 * corrente.
	 */
	public void pause(App app) {
		sendNotification(PAUSE, app, null);
	}
	/**
	 * Método que retorna a instância do aplicativo corrente.
	 * @return O aplicativo corrente.
	 */
	public App getApp() {
		return this.app;
	}
	
	/**
	 * Método que retorna o tradutor de comandos, que traduz os comandos de Canvas
	 * em comandos PureMVC.
	 * @return O tradutor de comandos
	 */
	public CommandTranslator getCommandTranslator() {
		return this.commandTranslator;
	}
	
}
