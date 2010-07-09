package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.InstructionsMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que sobrescreve o m�todo execute de SimpleCommand e inicializa
 * um mediador para fazer a comunica��o entre os dados das instru��es e
 * sua visualiza��o.
 */
public class InstructionsShowCommand extends SimpleCommand implements ICommand {
	
	/**
	 * M�todo inicializa o mediador de instru��es e associa uma notifica��o
	 * a um comando a ser executado pelo mediador.
	 *
	 */
	public void execute( INotification note ) {
		
		facade.registerMediator( new InstructionsMediator() );
		facade.registerCommand(InstructionsMediator.CLOSE, InstructionsCloseCommand.class);
		
		sendNotification(OptionsMenuMediator.ENABLE, null, null);
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(InstructionsMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}
	
}
