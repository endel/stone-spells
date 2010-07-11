package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.facade.GameFacade;

/**
 * Classe que executa a notificação de que a aplicação foi destruida.
 */
public class ExitCommand extends SimpleCommand implements ICommand {
	/**
	 * Método que notifica a instância do aplicativo de sua destruição.
	 */
	public void execute(INotification notification) {
		((GameFacade) facade).getApp().notifyDestroyed();
		
	}

}
