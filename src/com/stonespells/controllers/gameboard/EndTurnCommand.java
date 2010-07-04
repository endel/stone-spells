package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.MacroCommand;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.controllers.gameboard.communication.ReceiveBoardCommand;
import com.stonespells.controllers.gameboard.communication.SendBoardCommand;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.gameboard.GameStateIndicatorMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class EndTurnCommand extends MacroCommand implements ICommand {

	protected void initializeMacroCommand() {
		addSubCommand(CastSpellsCommand.class);
		addSubCommand(SendBoardCommand.class);
		addSubCommand(ReceiveBoardCommand.class);
	}
	
}