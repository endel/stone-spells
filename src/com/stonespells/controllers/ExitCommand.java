package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.facade.GameFacade;

/**
 * Classe que executa a notifica��o de que a aplica��o foi destruida.
 */
public class ExitCommand extends SimpleCommand implements ICommand {
	/**
	 * M�todo que notifica a inst�ncia do aplicativo de sua destrui��o.
	 */
	public void execute(INotification notification) {
		((GameFacade) facade).getApp().notifyDestroyed();
		
	}

}
