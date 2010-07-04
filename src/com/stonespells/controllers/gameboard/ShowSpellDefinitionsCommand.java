package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.SpellViewerMediator;

public class ShowSpellDefinitionsCommand extends SimpleCommand implements ICommand {
	
	public void execute (INotification note) {
		PlayerProxy player = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME)).getPlayer();
		
		SpellViewerMediator spellViewer = new SpellViewerMediator();
		spellViewer.setSpellList( player.getSpellList() );
		facade.registerMediator( spellViewer );
		
		facade.registerCommand(SpellViewerMediator.CLOSE, CloseSpellDefinitionsCommand.class);
		
		sendNotification(RenderMediator.REGISTER_CANVAS, spellViewer, null);
		sendNotification(RenderMediator.FLUSH, null, null);
	}
	
}
