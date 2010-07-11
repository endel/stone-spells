package com.stonespells.controllers.gameboard;

import java.util.Vector;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellListVO;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.gameboard.SpellVO;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.SpellViewerMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe exibe ao jogador uma lsita de feitiços.
 */
public class ShowSpellDefinitionsCommand extends SimpleCommand implements ICommand {
	
	public static final String CAST_LIST = "cast_list";
	/**
	 * Método onde uma lista de spells é alocada. 
	 * Todas as spells que estão sendo lançadas contra o jogador
	 * são colocadas em um vetor temporário, e logo em seguida 
	 * o vetor é transformado em uma SpellListProxy 
	 */
	public void execute (INotification note) {
		SpellListProxy spellList = (SpellListProxy) facade.retrieveProxy(SpellListProxy.NAME);
		
		if (note.getType() != null && note.getType().equals(CAST_LIST)) {
			spellList = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME)).getOpponent().getSpellList();
			SpellProxy spell = null;
			
			 /*
			 * coloca todas as spells que estão sendo lançadas contra o jogador
			 * em um vetor temporário, e logo em seguida transforma o vetor em uma
			 * SpellListProxy 
			 */
			Vector spells = new Vector();
			for (int i=0;i<spellList.getQty();i++) {
				spell = spellList.getSpellAt(i);
				if (spell.isCasting()) {
					spells.addElement(spell.getData());
				}
			}
			
			spellList.create(spells.size());
			for (int i=0;i<spells.size();i++) {
				spell.create();
				spell.setData(spells.elementAt(i));
				spellList.addSpellAt(spell, i);
			}
			
		} else {
			
			spellList = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME)).getPlayer().getSpellList();
		}
		
		SpellViewerMediator spellViewer = new SpellViewerMediator();
		spellViewer.setSpellList( spellList );
		facade.registerMediator( spellViewer );
		
		facade.registerCommand(SpellViewerMediator.CLOSE, CloseSpellDefinitionsCommand.class);
		
		sendNotification(OptionsMenuMediator.ENABLE, null, null);
		
		sendNotification(RenderMediator.REGISTER_CANVAS, spellViewer, null);
		sendNotification(RenderMediator.FLUSH, null, null);
	}
	
}
