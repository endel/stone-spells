package com.stonespells.controllers.game.board;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.RenderMediator;
import com.stonespells.views.game.board.GameBoardMediator;
import com.stonespells.views.game.board.SpellViewerMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class CloseSpellDefinitionsCommand extends SimpleCommand implements ICommand {
	
	public void execute( INotification note ) {
		
		// Remove Spell Viewer definitions
		facade.removeMediator( SpellViewerMediator.NAME );
		facade.removeCommand( SpellViewerMediator.CLOSE );
		
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(GameBoardMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, facade.retrieveMediator(GameBoardMediator.NAME), null);
		
	}
	
}
