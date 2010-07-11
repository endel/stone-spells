package com.stonespells.controllers.gameboard;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.gameboard.SpellViewerMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que sobrescreve o método execute de SimpleCommand a fim de 
 * apagar da tela as descrições dos feitiços.
 * 
 */
public class CloseSpellDefinitionsCommand extends SimpleCommand implements ICommand {
	/**
	 * Método que remove o mediador entre a visualização de feitiços e seus dados,
	 * apagando suas descrições e atualizando o contexto gráfico.
	 */
	public void execute( INotification note ) {
		
		GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		sendNotification(RenderMediator.REGISTER_CANVAS, gameBoard, null);
		
		// Remove Spell Viewer definitions
		facade.removeMediator( SpellViewerMediator.NAME );
		facade.removeCommand( SpellViewerMediator.CLOSE );
		((OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME)).removeInitiatedReference( SpellViewerMediator.NAME );
		
		sendNotification(RenderMediator.FLUSH, facade.retrieveMediator(GameBoardMediator.NAME), null);
	}
	
}
