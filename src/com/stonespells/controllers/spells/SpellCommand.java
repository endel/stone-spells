package com.stonespells.controllers.spells;

import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.core.ImageLibrary;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.gameboard.communication.PlayContextProxy;

/**
 * Descreve o comportamento base para todas as Spells. 
 * Toda Spell deve estender esta classe e implementar {@link ISpellCommand}
 * @author Endel
 *
 */
public abstract class SpellCommand extends SimpleCommand implements ISpellCommand {
		
	/**
	 * SpellProxy spell
	 * Reference to this spell definition.
	 */
	protected SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);

	public void execute(INotification note) {
		// Get this spell data
		spell.setData(note.getBody());
		
		if (note.getName().equals(SpellProxy.ON_CREATE)) {
			spell.setImage( ImageLibrary.fromByteArray(this.getImageBytes()) );
			this.onCreate();
			
		} else if (note.getName().equals(SpellProxy.ON_TURN_BEGIN)) {
			spell.setCasting(false);
			this.onTurnBegin();
			
		} else if (note.getName().equals(SpellProxy.ON_TURN_END)) {
			this.onTurnEnd();
			
		} else if (note.getName().equals(SpellProxy.ON_SWAP_POSITION)) {
			this.onSwapPosition();
			
		} else if (note.getName().equals(SpellProxy.ON_ENERGIZE)) {
			this.onEnergize();
			
		} else if (note.getName().equals(SpellProxy.ON_CAST)) {
			this.onCast();
			
		}
	}
	
	/**
	 * Retorna o contexto do jogo. Onde é possível resgatar os 
	 * dados para interação com o Oponente e Jogador, e suas respectivas listas de spells.
	 * 
	 * @see PlayContextProxy
	 */
	public PlayContextProxy getPlayContext() {
		return (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
	}
	
}
