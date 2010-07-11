package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.core.Logger;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que indica o come�o de um turno.
 *
 */
public class TurnBeginCommand extends SimpleCommand implements ICommand {
	
	/**
	 * M�todo que inicia um turno. O canvas a ser utilizado � registrado.
	 * As op��es desabilitadas. A energiza��o de pedras � habilitada.
	 * O jogador ativo � habilitado a jogar.
	 */
	public void execute(INotification note) {
		Logger.instance.println("Turn begin!");
		
		// Register the Canvas to draw
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(GameBoardMediator.NAME), null);
		
		// Disable options
		sendNotification(OptionsMenuMediator.DISABLE, null, null);
		
		// Enable energize
		PlayContextProxy playContext = (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		PlayerProxy player = playContext.getPlayer();
		
		boolean isPlayerActive = player.getActive();
		if (isPlayerActive) {
			gameBoard.setGameState(GameBoardMediator.GAMESTATE_ENERGIZE);
			
			player.addConcentration(2);
			player.getSpellList().dispatchAllEvents(SpellProxy.ON_TURN_BEGIN);
			
		} else {			
			gameBoard.setGameState(GameBoardMediator.GAMESTATE_WAITING_OPONENT);
		}
		
		// flush game board graphics
		sendNotification(RenderMediator.FLUSH, gameBoard, null);
		
		// TODO: refractor essa gambi nojenta
		if (!isPlayerActive) {
			sendNotification(GameBoardMediator.WAIT_FOR_OPPONENT, null, null);
		}
	}
	
	
}
