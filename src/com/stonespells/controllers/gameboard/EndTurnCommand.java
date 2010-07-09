package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.patterns.command.MacroCommand;

import com.stonespells.controllers.gameboard.communication.ReceiveBoardCommand;
import com.stonespells.controllers.gameboard.communication.SendBoardCommand;

/**
 * Classe que trata da finalização de um turno por um jogador.
 *
 */
public class EndTurnCommand extends MacroCommand implements ICommand {
/**
 * Método que finaliza um turno, adicionando subcomandos ao comando de macro.
 * Lança o feitiço, envia as informações do jogo, e recebe as mudanças feitas
 * nos dados do jogo, nesta ordem.
 */
	protected void initializeMacroCommand() {
		addSubCommand(CastSpellsCommand.class);
		addSubCommand(SendBoardCommand.class);
		addSubCommand(ReceiveBoardCommand.class);
	}
	
}