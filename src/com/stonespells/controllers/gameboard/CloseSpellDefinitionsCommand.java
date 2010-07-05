package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.gameboard.SpellViewerMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class CloseSpellDefinitionsCommand extends SimpleCommand implements ICommand {
	
	public void execute( INotification note ) {
		
		// Remove Spell Viewer definitions
		facade.removeMediator( SpellViewerMediator.NAME );
		facade.removeCommand( SpellViewerMediator.CLOSE );
		((OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME)).removeInitiatedReference( SpellViewerMediator.NAME );
		
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(GameBoardMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, facade.retrieveMediator(GameBoardMediator.NAME), null);
		
	}
	
}
