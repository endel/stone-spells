package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.core.ResourceLibrary;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
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
		
		boolean isPlayerActive = player.getActive();
		if (isPlayerActive) {
			gameBoard.setGameState(GameBoardMediator.GAMESTATE_ENERGIZE);
			
			player.addConcentration(2);
			SpellListProxy spellList = player.getSpellList();
			spellList.dispatchAllEvents(SpellProxy.ON_TURN_BEGIN);
			
		} else {			
			
			gameBoard.setGameState(GameBoardMediator.GAMESTATE_WAITING_OPONENT);
		}
		
		// flush game board graphics
		sendNotification(RenderMediator.FLUSH, gameBoard, null);
		
		// TODO: refractor essa gambi nojenta
		if (!isPlayerActive) {
			sendNotification(GameBoardMediator.WAIT_FOR_OPPONENT, null, null);
		}
	}
	
	
}
