package com.stonespells.controllers;

import java.io.DataInputStream;
import java.io.OutputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.patterns.command.SimpleCommand;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;

import com.stonespells.controllers.gameboard.PrepareGameCommand;
import com.stonespells.controllers.preconnection.PreparePreConnectionCommand;
import com.stonespells.controllers.spells.TemplateSpellCommand;
import com.stonespells.core.ImageLibrary;
import com.stonespells.facade.GameFacade;
import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.filemanager.SpellListIOProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.gameboard.communication.PlayContextProxy;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.InstructionsMediator;
import com.stonespells.views.MainMenuMediator;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.optionsmenu.OptionMenuItemMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class StartupCommand extends SimpleCommand implements ICommand {

	public void execute(INotification notification) {
		// Initial mediators startup
		facade.registerMediator( new MainMenuMediator() );
		facade.registerMediator( new RenderMediator() );
		
		// Options menu startup
		facade.registerMediator( new OptionsMenuMediator() );
		facade.registerMediator( new OptionMenuItemMediator() );
		facade.registerProxy( new OptionsMenuItemProxy() );
		
		// Paged content startup
		facade.registerProxy( new PagedContentProxy() );
		facade.registerMediator( new PagedContentMediator() );
		
		// Spell and game basic info
		facade.registerProxy( new PlayerProxy() );
		facade.registerProxy( new SpellProxy() );
		facade.registerProxy( new SpellListProxy() );
		facade.registerProxy( new SpellListIOProxy() );
		facade.registerProxy( new PlayContextProxy() );
		facade.registerMediator( new GameBoardMediator() );
		
		/*try {
			System.out.println("\n");
			for (int i=17;i<=23;i++) {
				byte[] byteArray = ImageLibrary.toByteArray(Image.createImage("/stones/" + String.valueOf(i) + ".png"));
				System.out.println(byteArray);
				
				for (int j=0;j<byteArray.length;j++) {
					System.out.println(byteArray[j]);
				}
				System.out.println("\n");
			}
			
		} catch (Exception e) { e.printStackTrace(); }*/
		
		
		
		// Main menu commands
		facade.registerCommand( MainMenuMediator.PLAY_SELECTED , PreparePreConnectionCommand.class);
		facade.registerCommand( MainMenuMediator.INSTRUCTIONS_SELECTED, InstructionsShowCommand.class);
		facade.registerCommand( MainMenuMediator.EXIT_SELECTED , ExitCommand.class);
		
		sendNotification(RenderMediator.REGISTER_CANVAS, facade.retrieveMediator(MainMenuMediator.NAME), null);
		sendNotification(RenderMediator.FLUSH, null, null);
	}

}