package com.stonespells.controllers.game.board.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;

import javax.microedition.io.StreamConnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.connection.ClientProxy;
import com.stonespells.models.connection.ConnectionProxy;
import com.stonespells.models.filemanager.SpellListIOProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.views.game.board.GameBoardMediator;

public class SendAndRecordInitialGameDataCommand extends SimpleCommand implements
		ICommand {
	
	public void execute(INotification note) {
		System.out.println("Send and record initial game data!");
		
		ConnectionProxy connProxy = (ConnectionProxy) facade.retrieveProxy(ConnectionProxy.PROXY_NAME);
		boolean playerActive = (connProxy.getProxyName().equals(ClientProxy.NAME));
		
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		PlayerProxy player = gameBoard.getCurrentPlayer();
		player.setActive(playerActive);
		
		SpellListProxy spellList = player.getSpellList();
		SpellListIOProxy spellListIO = (SpellListIOProxy) facade.retrieveProxy(SpellListIOProxy.NAME);
		
		try {
			DataOutputStream dos = connProxy.getDataOutputStream();
			dos.writeInt( player.getLife() );
			spellList.writeToStream(dos);
			dos.flush();
			
			DataInputStream din = connProxy.getDataInputStream();
			
			// Keep original data
			Object originalData = spellList.getData();
			
			// Read data from opponent
			int opponentLife = din.readInt();
			spellList.create();
			spellList.readFromStream( din );
			spellListIO.write(SpellListIOProxy.ENEMY_HAND, spellList.toByteArray());
			
			player.create();
			player.setLife( opponentLife );
			player.setSpellList(spellList);
			player.setActive(!playerActive);
			gameBoard.addPlayer(player);
			
			// Return to original data
			spellList.setData(originalData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
