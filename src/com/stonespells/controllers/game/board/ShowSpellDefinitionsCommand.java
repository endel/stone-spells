package com.stonespells.controllers.game.board;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.core.ImageLibrary;
import com.stonespells.models.PagedContentProxy;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.game.board.GameBoardMediator;
import com.stonespells.views.game.board.SpellViewerMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class ShowSpellDefinitionsCommand extends SimpleCommand implements ICommand {
	
	public void execute (INotification note) {
		
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		
		SpellViewerMediator spellViewer = new SpellViewerMediator();
		spellViewer.setSpellList( gameBoard.getCurrentPlayer().getSpellList() );
		facade.registerMediator( spellViewer );
		
		facade.registerCommand(SpellViewerMediator.CLOSE, CloseSpellDefinitionsCommand.class);
		
		sendNotification(RenderMediator.REGISTER_CANVAS, spellViewer, null);
		sendNotification(RenderMediator.FLUSH, null, null);
	}
	
}
