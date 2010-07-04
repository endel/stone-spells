package com.stonespells.controllers.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.patterns.command.MacroCommand;

import com.stonespells.controllers.gameboard.PrepareGameCommand;
import com.stonespells.controllers.gameboard.communication.SendAndRecordInitialGameDataCommand;

public class ConnectionAcceptedCommand extends MacroCommand implements ICommand {
	
	public void initializeMacroCommand( ) {
		
		addSubCommand(SendAndRecordInitialGameDataCommand.class);
		addSubCommand(PrepareGameCommand.class);
		
	}
	
}
