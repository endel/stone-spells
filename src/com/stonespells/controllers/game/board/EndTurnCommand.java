package com.stonespells.controllers.game.board;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.MacroCommand;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.controllers.game.board.communication.ReceiveBoardCommand;
import com.stonespells.controllers.game.board.communication.SendBoardCommand;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.game.board.GameBoardMediator;
import com.stonespells.views.game.board.GameStateIndicatorMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class EndTurnCommand extends MacroCommand implements ICommand {

	protected void initializeMacroCommand() {
		addSubCommand(CastSpellsCommand.class);
		addSubCommand(SendBoardCommand.class);
		addSubCommand(ReceiveBoardCommand.class);
	}
	
}