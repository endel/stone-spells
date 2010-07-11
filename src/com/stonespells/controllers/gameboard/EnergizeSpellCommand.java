package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.gameboard.GameBoardMediator;

/**
 * Classe que trata da energização propriamente dita dos feitiços.
 *
 */
public class EnergizeSpellCommand extends SimpleCommand implements ICommand {
	
	/**
	 * Método que testa a possibilidade da energização de um feitiço e, se possível
	 * converte um ponto de concentração do jogador e um ponto de concentração de um
	 * feitiço.
	 * Se o jogador não possuir mais pontos de concentração para distribuir, o jogo sai deste
	 * estado.
	 */
	public void execute(INotification note) {
		SpellProxy spell = (SpellProxy) note.getBody();
		
		// Skip if spell is locked or can't be energized
		if (spell.isLocked() || !spell.canEnergize())
			return;
		
		spell.addConcentration(1);
		
		PlayerProxy player = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME)).getPlayer();
		player.addConcentration(-1);
		
		if (player.getConcentration() == 0) {
			sendNotification(GameBoardMediator.ENERGIES_DISTRIBUTED, null, null);
		}
	}
	
}
