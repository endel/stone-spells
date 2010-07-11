package com.stonespells.controllers.preconnection;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.patterns.command.MacroCommand;

import com.stonespells.controllers.gameboard.PrepareGameCommand;
import com.stonespells.controllers.gameboard.communication.SendAndRecordInitialGameDataCommand;

/**
 * Classe que trata a lista de subcomandos referentes ao inicio de uma
 * conexão entre os jogadores.
 */
public class ConnectionAcceptedCommand extends MacroCommand implements ICommand {
	
	/**
	 * Adiciona subcomandos à MacroCommand.
	 */
	public void initializeMacroCommand( ) {
		
		addSubCommand(SendAndRecordInitialGameDataCommand.class);
		addSubCommand(PrepareGameCommand.class);
		
	}
	
}
