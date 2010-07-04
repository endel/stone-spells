package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.patterns.command.MacroCommand;

import com.stonespells.controllers.gameboard.communication.ReceiveBoardCommand;
import com.stonespells.controllers.gameboard.communication.SendBoardCommand;

public class EndTurnCommand extends MacroCommand implements ICommand {

	protected void initializeMacroCommand() {
		addSubCommand(CastSpellsCommand.class);
		addSubCommand(SendBoardCommand.class);
		addSubCommand(ReceiveBoardCommand.class);
	}
	
}