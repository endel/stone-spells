package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.core.Logger;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class EnergiesDistributedCommand extends SimpleCommand implements ICommand {
	
	public void execute (INotification note) {
		Logger.instance.println("EnergiesDistributedCommand");
		
		// Set game state
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		gameBoard.setGameState(GameBoardMediator.GAMESTATE_SELECT_SPELLS);
		
		// Enable menu and disable concentrate indicator
		sendNotification(OptionsMenuMediator.ENABLE, null, null);
		
		// Flush graphics
		sendNotification(RenderMediator.FLUSH, null, null);
	}
	
}
