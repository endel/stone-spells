package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.InstructionsMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class InstructionsShowCommand extends SimpleCommand implements ICommand {
	
	public void execute( INotification note ) {
		
		facade.registerMediator( new InstructionsMediator() );
		facade.registerCommand(InstructionsMediator.CLOSE, InstructionsCloseCommand.class);
		
		sendNotification(OptionsMenuMediator.ENABLE, null, null);
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(InstructionsMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}
	
}
