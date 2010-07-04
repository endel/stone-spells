package com.stonespells.controllers.gameboard.communication;

import java.io.DataOutputStream;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.connection.ConnectionProxy;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;

public class SendBoardCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification note) {
		System.out.println("Sending board...");
		ConnectionProxy connProxy = (ConnectionProxy) facade.retrieveProxy(ConnectionProxy.PROXY_NAME);
		
		PlayContextProxy playContext = (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
		try {
			DataOutputStream dos = connProxy.getDataOutputStream();
			dos.writeInt(ConnectionProxy.GAME_BOARD_CONFIG);
			
			// Player
			PlayerProxy player = playContext.getPlayer();
			dos.writeInt( player.getLife() );
			player.getSpellList().writeToStream(dos);
			
			// Opponent
			player = playContext.getOpponent();
			dos.writeInt( player.getLife() );
			player.getSpellList().writeToStream(dos);
			dos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sendNotification(RenderMediator.FLUSH, facade.retrieveMediator(GameBoardMediator.NAME), null);
		System.out.println("Board sent successfully!");
	}
	
}
