package com.stonespells.controllers.game.board;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.gameboard.communication.PlayContextProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.game.board.GameStateIndicatorMediator;
import com.stonespells.views.game.board.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class TurnBeginCommand extends SimpleCommand implements ICommand {
	
	
	public void execute(INotification note) {
		System.out.println("Turn begin!");
		
		// Register the Canvas to draw
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(GameBoardMediator.NAME), null);
		
		// Disable options
		sendNotification(OptionsMenuMediator.DISABLE, null, null);
		
		// Enable energize
		PlayContextProxy playContext = (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		PlayerProxy player = playContext.getPlayer();
		
		System.out.println("O player tá ativo? " +  player.getActive());
		
		if (player.getActive()) {
			gameBoard.setGameState(GameBoardMediator.GAMESTATE_ENERGIZE);
			
			player.addConcentration(2);
			SpellListProxy spellList = player.getSpellList();
			spellList.dispatchAllEvents(SpellProxy.ON_TURN_BEGIN);
		} else {
			gameBoard.setGameState(GameBoardMediator.GAMESTATE_WAITING_OPONENT);
		}
		
		// Flush screen
		sendNotification(RenderMediator.FLUSH, gameBoard, null);
		
		// TODO: refractor essa gambi nojenta
		if (!player.getActive()) {
			sendNotification(GameBoardMediator.WAIT_FOR_OPPONENT, null, null);
		}
	}
	
	
}
