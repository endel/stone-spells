package com.stonespells.controllers.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.connection.ServerProxy;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.preconnection.PreConnectionMediator;

public class PreConnectionCreateCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification note) {
		
		// Create server connection
		
		ServerProxy server = new ServerProxy();
		facade.registerProxy(server);
		try {
			server.create();
		} catch (Exception e) {
			System.out.println("Erro ao criar o server.");
			e.printStackTrace();
		}
		
		PreConnectionMediator preConnection = (PreConnectionMediator) facade.retrieveMediator(PreConnectionMediator.NAME);
		preConnection.setBoxTitle("Aguardando oponente...");
		
		PagedContentProxy pagedContent = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContent.setContent("Jogo criado. Seu        oponente devera se      conectar a este jogo.", 0);
		((PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME)).setViewComponent(pagedContent.getData());
		
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}
	
}
