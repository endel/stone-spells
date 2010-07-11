package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.InstructionsMediator;
import com.stonespells.views.MainMenuMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que fecha os mediadores de comando da instância de facade.
 */
public class InstructionsCloseCommand extends SimpleCommand implements ICommand {

	/**
	 * Método que sobrescreve execute de SimpleCommand.
	 * O mediador, o comando previamente mapeado à instrução e 
	 * os dados especificados do vetor hasCommand de OptionsMenuMediator
	 * são removidos da memória.
	 * O canvas é atualizado e renderizado novamente.
	 */
	public void execute(INotification note) {
		
		facade.removeMediator( InstructionsMediator.NAME );
		facade.removeCommand( InstructionsMediator.CLOSE );
		((OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME)).removeInitiatedReference( InstructionsMediator.NAME );
		
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(MainMenuMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}

}
