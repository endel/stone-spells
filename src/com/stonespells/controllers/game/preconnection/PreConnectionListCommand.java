package com.stonespells.controllers.game.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.connection.ClientProxy;
import com.stonespells.models.connection.ConnectionProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.PlayerVO;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.game.board.GameBoardMediator;
import com.stonespells.views.game.connection.PreConnectionMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class PreConnectionListCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification note) {
		
		// Create client connection
		
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
