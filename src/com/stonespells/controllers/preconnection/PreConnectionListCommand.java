package com.stonespells.controllers.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.connection.ClientProxy;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;
import com.stonespells.views.preconnection.PreConnectionMediator;

/**
 * Classe que trata do comando de criação de conexão do cliente.
 */
public class PreConnectionListCommand extends SimpleCommand implements ICommand {
	
	/**
	 * Cria a conexão do cliente.
	 */
	public void execute(INotification note) {
		
		ClientProxy client = new ClientProxy();
		facade.registerProxy(client);
		
		OptionsMenuMediator optionMenu = (OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME);
		optionMenu.removeItemAtSide(OptionsMenuMediator.SIDE_RIGHT);
		
		PreConnectionMediator preConnection = (PreConnectionMediator) facade.retrieveMediator(PreConnectionMediator.NAME);
		preConnection.setBoxTitle("Buscando jogadores");
		
		PagedContentProxy pagedContent = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		
		try {
			client.connect();
			pagedContent.setContent("Aguarde...", 0);
		} catch (Exception e) {
			pagedContent.setContent("Erro ao criar o client.", 0);
			System.out.println("Erro ao criar o client.");
			e.printStackTrace();
		}
		((PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME)).setViewComponent(pagedContent.getData());
		
	}
	
}
