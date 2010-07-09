package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;
/**
 * Classe que sobrescreve o método execute de SimpleCommand para indicar que
 * é hora de energizar os feitiços.
 */
public class EnergiesDistributedCommand extends SimpleCommand implements ICommand {
	
	/**
	 * Método que configura o estado da instância de GameBoardMediator para
	 * GAMESTATE_SELECT_SPELLS e atualiza o contexto gráfico.
	 */
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
