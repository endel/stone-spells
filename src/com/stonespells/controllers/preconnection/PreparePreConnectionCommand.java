package com.stonespells.controllers.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.filemanager.SpellListIOProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;
import com.stonespells.views.preconnection.PreConnectionMediator;

public class PreparePreConnectionCommand extends SimpleCommand implements ICommand {

	public void execute(INotification notification) {
		
		PreConnectionMediator preConnection = new PreConnectionMediator();
		facade.registerMediator( preConnection );
		sendNotification(OptionsMenuMediator.ENABLE, null, null);
		
		// Prepare player current player
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		
		SpellListIOProxy spellListIO = (SpellListIOProxy) facade.retrieveProxy(SpellListIOProxy.NAME);
		spellListIO.read();
		try {
			spellListIO.dummyCreate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PlayerProxy player = (PlayerProxy) facade.retrieveProxy(PlayerProxy.NAME); 
		player.create();
		player.setLife(30);
		player.setSpellList( spellListIO.getList() );
		gameBoard.addPlayer( player );
		
		facade.registerCommand(PreConnectionMediator.BACK, PreConnectionBackToMenuCommand.class);
		facade.registerCommand(PreConnectionMediator.LIST, PreConnectionListCommand.class);
		facade.registerCommand(PreConnectionMediator.CREATE, PreConnectionCreateCommand.class);
		facade.registerCommand(PreConnectionMediator.CONNECTION_ACCEPTED, ConnectionAcceptedCommand.class);
		
		sendNotification(RenderMediator.REGISTER_CANVAS, preConnection, null);
		sendNotification(RenderMediator.FLUSH, null, null);
		
	}
	
	
	
}
