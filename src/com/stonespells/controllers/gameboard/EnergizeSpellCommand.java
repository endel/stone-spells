package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.gameboard.GameBoardMediator;

public class EnergizeSpellCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification note) {
		SpellProxy spell = (SpellProxy) note.getBody();
		
		// Skip if spell is locked
		if (spell.isLocked())
			return;
		
		spell.addConcentration(1);
		
		PlayerProxy player = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME)).getPlayer();
		player.addConcentration(-1);
		
		if (player.getConcentration() == 0) {
			sendNotification(GameBoardMediator.ENERGIES_DISTRIBUTED, null, null);
		}
	}
	
}
