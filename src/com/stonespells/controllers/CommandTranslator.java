package com.stonespells.controllers;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

import com.stonespells.facade.GameFacade;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Traduz comandos de Canvas para comandos PureMVC
 */
public class CommandTranslator implements CommandListener {

	/**
	 * Método que obtém o singleton de facade e realiza chamadas para renderização
	 * de acordo com as opções disponíveis a determinado jogador.
	 */
	public void commandAction(Command c, Displayable d) {
		// c.getLabel() = notificationName
		// c.getPriority() = side [gambi bonita]
		
		GameFacade facade = (GameFacade) GameFacade.getInstance();
		
		facade.sendNotification(RenderMediator.FLUSH, null, null);
		
		OptionsMenuMediator optionsMenu = (OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME);
		optionsMenu.selectSide( c.getPriority() );
		
		facade.sendNotification(RenderMediator.FLUSH, null, null);
		
		System.out.println( "Tranlating command: " + c.getLabel() );
		facade.sendNotification( c.getLabel(), d, null);
	}

}
