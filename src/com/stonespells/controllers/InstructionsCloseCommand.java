package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.InstructionsMediator;
import com.stonespells.views.MainMenuMediator;
import com.stonespells.views.RenderMediator;

public class InstructionsCloseCommand extends SimpleCommand implements ICommand {

	public void execute(INotification note) {
		
		facade.removeMediator( InstructionsMediator.NAME );
		facade.removeCommand( InstructionsMediator.CLOSE );
		
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(MainMenuMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}

}
