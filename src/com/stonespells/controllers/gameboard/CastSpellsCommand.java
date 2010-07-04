package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.gameboard.GameStateIndicatorMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class CastSpellsCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification note) {
		System.out.println("Vou dar cast!");
		
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		gameBoard.setGameState(GameBoardMediator.GAMESTATE_WAITING_OPONENT);

		// Disable options and enable game state indicator
		sendNotification(OptionsMenuMediator.DISABLE, null, null);
		
		PlayerProxy player = gameBoard.getCurrentPlayer();
		
		// Do all spell effects
		SpellListProxy spellList = player.getSpellList();
		spellList.castAllSelected();
		spellList.dispatchAllEvents(SpellProxy.ON_TURN_END);
		
		sendNotification(RenderMediator.FLUSH, gameBoard, null);
	}
	
}