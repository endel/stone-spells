package com.stonespells.controllers.game.board;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.controllers.game.board.communication.ReceiveBoardCommand;
import com.stonespells.core.ImageLibrary;
import com.stonespells.models.filemanager.SpellListIOProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.PlayerVO;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellListVO;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.MainMenuMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.game.board.GameStateIndicatorMediator;
import com.stonespells.views.game.board.GameBoardMediator;
import com.stonespells.views.game.board.SpellHolderMediator;
import com.stonespells.views.game.connection.PreConnectionMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class PrepareGameCommand extends SimpleCommand implements ICommand {
	
	public void execute( INotification note )
	{
		System.out.println("Prepare game!");
		
		// Remove commands and mediators from PrepareConnection's 
		facade.removeMediator(PreConnectionMediator.NAME);
		facade.removeCommand(PreConnectionMediator.BACK);
		facade.removeCommand(PreConnectionMediator.LIST);
		facade.removeCommand(PreConnectionMediator.CREATE);
		facade.removeCommand(PreConnectionMediator.CONNECTION_ACCEPTED);
		
		// Setup gameboard
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		
		SpellListIOProxy spellListIO = (SpellListIOProxy) facade.retrieveProxy(SpellListIOProxy.NAME);
		gameBoard.getCurrentPlayer().setSpellList( spellListIO.getList() );
		
		facade.registerMediator( new SpellHolderMediator() );
		
		// Configure concentration informer
		facade.registerMediator(new GameStateIndicatorMediator());
		
		// Register in-game commands
		facade.registerCommand(GameBoardMediator.ENERGIZE_SPELL, EnergizeSpellCommand.class);
		facade.registerCommand(GameBoardMediator.ENERGIES_DISTRIBUTED, EnergiesDistributedCommand.class);
		facade.registerCommand(GameBoardMediator.TURN_BEGIN, TurnBeginCommand.class);
		facade.registerCommand(GameBoardMediator.END_TURN, EndTurnCommand.class);
		facade.registerCommand(GameBoardMediator.OPTION_VIEW, ShowSpellDefinitionsCommand.class);
		
		// Communication commands
		facade.registerCommand(GameBoardMediator.WAIT_FOR_OPPONENT, ReceiveBoardCommand.class);
		
		sendNotification(GameBoardMediator.TURN_BEGIN, null, null);
	}

}
