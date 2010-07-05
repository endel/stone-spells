package com.stonespells.controllers.spells;

import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.core.ResourceLibrary;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.SpellProxy;

/**
 * Descreve o comportamento base para todas as Spells. 
 * Toda Spell deve estender esta classe e implementar {@link ISpellCommand}
 * @author Endel
 *
 */
public abstract class SpellCommand extends SimpleCommand implements ISpellCommand {
		
	/**
	 * Objeto de referência para esta spell.
	 */
	private Object spellData;

	public void execute(INotification note) {
		// Get this spell data
		this.spellData = note.getBody();
		SpellProxy spell = getSpell();
		
		if (note.getName().equals(SpellProxy.ON_CREATE)) {
			spell.setImage( ResourceLibrary.fromByteArray(this.getImageBytes()) );
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
		
		// Update spell data case it is changed by another event
		this.getSpell();
	}
	
	/**
	 * Retorna uma referência para a spell corrente.
	 * 
	 * @return SpellProxy
	 */
	public SpellProxy getSpell() {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		spell.setData(spellData);
		return spell;
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
	
	public boolean canCast() {
		return true;
	}
	
	public boolean canEnergize() {
		return true;
	}
	
}
