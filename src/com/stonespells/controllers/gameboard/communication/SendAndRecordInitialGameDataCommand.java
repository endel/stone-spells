package com.stonespells.controllers.gameboard.communication;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.connection.ClientProxy;
import com.stonespells.models.connection.ConnectionProxy;
import com.stonespells.models.filemanager.SpellListIOProxy;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;

public class SendAndRecordInitialGameDataCommand extends SimpleCommand implements
		ICommand {
	
	public void execute(INotification note) {
		ConnectionProxy connProxy = (ConnectionProxy) facade.retrieveProxy(ConnectionProxy.PROXY_NAME);
		boolean playerActive = (connProxy.getProxyName().equals(ClientProxy.NAME));
		
		PlayContextProxy playContext = (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
		PlayerProxy player = playContext.getPlayer();
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
			playContext.setOpponent(player);
			
			// Return to original data
			spellList.setData(originalData);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
