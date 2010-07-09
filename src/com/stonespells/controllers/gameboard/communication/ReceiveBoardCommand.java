package com.stonespells.controllers.gameboard.communication;

import java.io.DataInputStream;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.controllers.gameboard.ShowSpellDefinitionsCommand;
import com.stonespells.core.Logger;
import com.stonespells.models.connection.ConnectionProxy;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class ReceiveBoardCommand extends SimpleCommand implements
		ICommand {
	
	public void execute(INotification note) {
		Logger.instance.println("Waiting to receive opponent board...");
		ConnectionProxy connProxy = (ConnectionProxy) facade.retrieveProxy(ConnectionProxy.PROXY_NAME);
		PlayContextProxy playContext = (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
		
		try {
			DataInputStream dis = connProxy.getDataInputStream();
			
			while (dis.available() == 0) {
			}
			
			int actionType = dis.readInt();
			
			// Read Game Board Configurations
			if (actionType == ConnectionProxy.GAME_BOARD_CONFIG) {
				PlayerProxy player;
				SpellListProxy spellList;
				
				// Opponent
				player = playContext.getOpponent();
				player.setActive(false);
				player.setLife( dis.readInt() );
				spellList = player.getSpellList();
				spellList.readFromStream(dis);
				
				// Player
				player = playContext.getPlayer();
				player.setActive(true);
				player.setLife( dis.readInt() );
				spellList = player.getSpellList();
				spellList.readFromStream(dis);
				
			} else if (actionType == ConnectionProxy.END_GAME) {
				Logger.instance.println("Fim de jogo...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Logger.instance.println("Received successfully!");
		
		sendNotification(GameBoardMediator.TURN_BEGIN, null, null);
		
		// Show oponent spells if he casted something
		if ( playContext.getOpponent().getSpellList().hasCastSpell() ) {
			GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
			gameBoard.setGameState(GameBoardMediator.GAMESTATE_VIEWING_OPONENT_SPELLS);
			
			sendNotification(OptionsMenuMediator.ENABLE, null, null);
			sendNotification(GameBoardMediator.OPTION_VIEW, null, ShowSpellDefinitionsCommand.CAST_LIST);
		}
	}
	
}
