package com.stonespells.controllers.game.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.patterns.command.MacroCommand;

import com.stonespells.controllers.game.board.PrepareGameCommand;
import com.stonespells.controllers.game.board.communication.SendAndRecordInitialGameDataCommand;

public class ConnectionAcceptedCommand extends MacroCommand implements ICommand {
	
	public void initializeMacroCommand( ) {
		
		addSubCommand(SendAndRecordInitialGameDataCommand.class);
		addSubCommand(PrepareGameCommand.class);
		
	}
	
}
