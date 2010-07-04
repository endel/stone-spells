package com.stonespells.controllers.gameboard.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.microedition.io.StreamConnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.connection.ConnectionProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.communication.PlayContextProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;

public class ReceiveBoardCommand extends SimpleCommand implements
		ICommand {
	
	public void execute(INotification note) {
		
		ConnectionProxy connProxy = (ConnectionProxy) facade.retrieveProxy(ConnectionProxy.PROXY_NAME);
		PlayContextProxy playContext = (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
		try {
			DataInputStream dis = connProxy.getDataInputStream();
			
			while (dis.available() == 0) {
			}
			
			System.out.println("Comecei a ler! ");
			
			int actionType = dis.readInt();
			
			// Read Game Board Configurations
			if (actionType == ConnectionProxy.GAME_BOARD_CONFIG) {
				PlayerProxy player;
				SpellListProxy spellList;
				
				// Opponent
				player = playContext.getOpponent();
				player.setActive(false);
				spellList = player.getSpellList();
				player.setLife( dis.readInt() );
				spellList.readFromStream(dis);
				
				// Player
				player = playContext.getPlayer();
				player.setActive(true);
				spellList = player.getSpellList();
				
				player.setLife( dis.readInt() );
				spellList.readFromStream(dis);
				
			} else if (actionType == ConnectionProxy.END_GAME) {
				System.out.println("Fim de jogo...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sendNotification(RenderMediator.FLUSH, facade.retrieveMediator(GameBoardMediator.NAME), null);
		sendNotification(GameBoardMediator.TURN_BEGIN, null, null);
	}
	
}
