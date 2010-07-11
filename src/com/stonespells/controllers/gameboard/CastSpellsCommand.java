package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.core.Logger;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**Classe que sobrescreve o método execute de SimpleCommand e
 * trata de acionar o feitiço utilizado pelo jogador.
 */
public class CastSpellsCommand extends SimpleCommand implements ICommand {
	
	/**
	 * Método que inicializa um mediador para o jogo, seta seu estado para estado
	 * de espera, desabilita o menu e executa os efeitos dos feitiços acionados.
	 * Após isto, ele renderiza os gráficos atualizados.
	 */
	public void execute(INotification note) {
		Logger.instance.println("Vou dar cast!");
		
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		gameBoard.setGameState(GameBoardMediator.GAMESTATE_WAITING_OPONENT);

		// Disable options and enable game state indicator
		sendNotification(OptionsMenuMediator.DISABLE, null, null);
		
		// Do all spell effects
		PlayerProxy player = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME)).getPlayer();
		SpellListProxy spellList = player.getSpellList();
		spellList.castAllSelected();
		spellList.dispatchAllEvents(SpellProxy.ON_TURN_END);
		
		// Flush gameboard graphics...
		sendNotification(RenderMediator.FLUSH, gameBoard, null);
	}
	
}
