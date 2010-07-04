package com.stonespells.facade;
import org.puremvc.java.interfaces.IFacade;
import org.puremvc.java.patterns.facade.Facade;

import com.stonespells.controllers.CommandTranslator;
import com.stonespells.controllers.StartupCommand;
import com.stonespells.core.App;

public class GameFacade extends Facade implements IFacade {
	
	public static final String STARTUP = "GameFacadeStartupNotification";
	public static final String PAUSE = "GameFacadePauseNotification";
	
	private App app;
	private CommandTranslator commandTranslator;
	
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
	
	protected void initializeFacade( ) {
		super.initializeFacade();
		registerCommand(STARTUP, StartupCommand.class);
	}
	
	public void startup(App app) {
		System.out.println("startup!");
		this.app = app;
		this.commandTranslator = new CommandTranslator();
		sendNotification(STARTUP, app, null);
	}
	
	public void pause(App app) {
		sendNotification(PAUSE, app, null);
	}
	
	public App getApp() {
		return this.app;
	}
	
	public CommandTranslator getCommandTranslator() {
		return this.commandTranslator;
	}
	
}
