package com.stonespells.controllers.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.connection.ClientProxy;
import com.stonespells.models.connection.ServerProxy;
import com.stonespells.views.MainMenuMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.preconnection.PreConnectionMediator;

public class PreConnectionBackToMenuCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification note) {
		
		// Remove all PreConnection references
		facade.removeMediator( PreConnectionMediator.NAME );
		facade.removeCommand( PreConnectionMediator.BACK );
		facade.removeCommand( PreConnectionMediator.CREATE );
		facade.removeCommand( PreConnectionMediator.LIST );
		
		// Remove connection proxies
		facade.removeProxy( ServerProxy.NAME );
		facade.removeProxy( ClientProxy.NAME );
		
		// Back to menu
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(MainMenuMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}

}
