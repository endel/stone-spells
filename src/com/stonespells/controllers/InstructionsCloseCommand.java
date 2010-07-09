package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.InstructionsMediator;
import com.stonespells.views.MainMenuMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que fecha os mediadores de comando da inst�ncia de facade.
 */
public class InstructionsCloseCommand extends SimpleCommand implements ICommand {

	/**
	 * M�todo que sobrescreve execute de SimpleCommand.
	 * O mediador, o comando previamente mapeado � instru��o e 
	 * os dados especificados do vetor hasCommand de OptionsMenuMediator
	 * s�o removidos da mem�ria.
	 * O canvas � atualizado e renderizado novamente.
	 */
	public void execute(INotification note) {
		
		facade.removeMediator( InstructionsMediator.NAME );
		facade.removeCommand( InstructionsMediator.CLOSE );
		((OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME)).removeInitiatedReference( InstructionsMediator.NAME );
		
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(MainMenuMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}

}
