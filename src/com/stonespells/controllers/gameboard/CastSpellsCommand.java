package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.core.Logger;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Command que troca o estado do {@link GameBoardMediator} para
 * GAMESTATE_WAITING_OPONENT. É responsável por disparar o evento onCast() das
 * spells selecionadas.
 */
public class CastSpellsCommand extends SimpleCommand implements ICommand {

	public void execute(INotification note) {
		Logger.instance.println("Vou dar cast!");

		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		gameBoard.setGameState(GameBoardMediator.GAMESTATE_WAITING_OPONENT);

		// Disable options and enable game state indicator
		sendNotification(OptionsMenuMediator.DISABLE, null, null);
		
		// Do all spell effects
		PlayContextProxy playContext = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME));
		playContext.getPlayer().getSpellList().castAllSelected();
		playContext.getPlayer().getSpellList().dispatchAllEvents(SpellProxy.ON_TURN_END);
		
		// Flush gameboard graphics...
		sendNotification(RenderMediator.FLUSH, gameBoard, null);
	}

}
