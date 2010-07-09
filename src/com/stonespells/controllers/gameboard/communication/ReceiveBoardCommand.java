package com.stonespells.controllers.gameboard.communication;

import java.io.DataInputStream;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.controllers.gameboard.ShowSpellDefinitionsCommand;
import com.stonespells.models.connection.ConnectionProxy;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
/**
 * Classe que trata o recebimento de mensagens do jogo.
 */
public class ReceiveBoardCommand extends SimpleCommand implements
		ICommand {
	
	/**
	 * Método que cria um proxy de conexão e um proxy com o contexto do jogo.
	 * Os dados do jogador e do adversário são então tratados, ou o jogo
	 * é finalizado se necessário.
	 */
	public void execute(INotification note) {
		System.out.println("Waiting to receive opponent board...");
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
				System.out.println("Fim de jogo...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Received successfully!");
		
		// Verifica se precisa mostrar a lista de
		
		sendNotification(GameBoardMediator.TURN_BEGIN, null, null);
		
		System.out.println("Oponent cast spells? " + playContext.getOpponent().getSpellList().hasCastSpell() );
		if ( playContext.getOpponent().getSpellList().hasCastSpell() ) {

			sendNotification(GameBoardMediator.OPTION_VIEW, null, ShowSpellDefinitionsCommand.CAST_LIST);
		}
	}
	
}
