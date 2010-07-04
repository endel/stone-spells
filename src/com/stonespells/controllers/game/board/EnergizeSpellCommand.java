package com.stonespells.controllers.game.board;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.game.board.GameBoardMediator;

public class EnergizeSpellCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification note) {
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		
		SpellProxy spell = (SpellProxy) note.getBody();
		
		// Skip if spell is locked
		if (spell.isLocked())
			return;
		
		spell.addConcentration(1);
		
		PlayerProxy player = gameBoard.getCurrentPlayer();
		player.addConcentration(-1);
		
		if (player.getConcentration() == 0) {
			sendNotification(GameBoardMediator.ENERGIES_DISTRIBUTED, null, null);
		}
	}
	
}
