package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.InstructionsMediator;
import com.stonespells.views.MainMenuMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Command para fechar a janela de instruções e retornar para o menu principal.
 */
public class InstructionsCloseCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification note) {
		
		facade.removeMediator( InstructionsMediator.NAME );
		facade.removeCommand( InstructionsMediator.CLOSE );
		((OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME)).removeInitiatedReference( InstructionsMediator.NAME );
		
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(MainMenuMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}

}
