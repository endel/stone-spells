package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.controllers.gameboard.communication.ReceiveBoardCommand;
import com.stonespells.core.Logger;
import com.stonespells.models.filemanager.SpellListIOProxy;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.gameboard.GameStateIndicatorMediator;
import com.stonespells.views.gameboard.SpellHolderMediator;
import com.stonespells.views.preconnection.PreConnectionMediator;

public class PrepareGameCommand extends SimpleCommand implements ICommand {

	public void execute(INotification note) {
		Logger.instance.println("Prepare game!");

		// Configure concentration informer
		facade.registerMediator(new GameStateIndicatorMediator());
		facade.registerMediator(new SpellHolderMediator());

		// Remove commands and mediators from PrepareConnection's
		facade.removeMediator(PreConnectionMediator.NAME);
		facade.removeCommand(PreConnectionMediator.BACK);
		facade.removeCommand(PreConnectionMediator.LIST);
		facade.removeCommand(PreConnectionMediator.CREATE);
		facade.removeCommand(PreConnectionMediator.CONNECTION_ACCEPTED);

		// Set player's spell list
		SpellListIOProxy spellListIO = (SpellListIOProxy) facade.retrieveProxy(SpellListIOProxy.NAME);
		PlayerProxy player = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME)).getPlayer();
		player.setSpellList( spellListIO.getList() );

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
