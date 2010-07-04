package com.stonespells.controllers.game.board;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.RenderMediator;
import com.stonespells.views.game.board.GameStateIndicatorMediator;
import com.stonespells.views.game.board.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class EnergiesDistributedCommand extends SimpleCommand implements ICommand {
	
	public void execute (INotification note) {
		System.out.println("EnergiesDistributedCommand");
		
		// Set game state
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		gameBoard.setGameState(GameBoardMediator.GAMESTATE_SELECT_SPELLS);
		
		// Enable menu and disable concentrate indicator
		sendNotification(OptionsMenuMediator.ENABLE, null, null);
		
		// Flush graphics
		sendNotification(RenderMediator.FLUSH, null, null);
	}
	
}
