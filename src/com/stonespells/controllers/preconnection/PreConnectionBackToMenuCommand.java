package com.stonespells.controllers.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.connection.ClientProxy;
import com.stonespells.models.connection.ServerProxy;
import com.stonespells.views.MainMenuMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;
import com.stonespells.views.preconnection.PreConnectionMediator;
/**
 * Classe que trata do retorno do fluxo do jogo ao menu.
 */
public class PreConnectionBackToMenuCommand extends SimpleCommand implements ICommand {
	/**
	 * Método que remove todoas as referências pré-conexão, todos os
	 * proxies de conexão, e retorna o fluxo do jogo ao menu.
	 */
	public void execute(INotification note) {
		
		facade.removeMediator( PreConnectionMediator.NAME );
		facade.removeCommand( PreConnectionMediator.BACK );
		facade.removeCommand( PreConnectionMediator.CREATE );
		facade.removeCommand( PreConnectionMediator.LIST );
		((OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME)).removeInitiatedReference( PreConnectionMediator.NAME );
		
		facade.removeProxy( ServerProxy.NAME );
		facade.removeProxy( ClientProxy.NAME );
		
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(MainMenuMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);		
	}

}
