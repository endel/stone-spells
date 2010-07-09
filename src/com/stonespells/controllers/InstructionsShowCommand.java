package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.InstructionsMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que sobrescreve o método execute de SimpleCommand e inicializa
 * um mediador para fazer a comunicação entre os dados das instruções e
 * sua visualização.
 */
public class InstructionsShowCommand extends SimpleCommand implements ICommand {
	
	/**
	 * Método inicializa o mediador de instruções e associa uma notificação
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
