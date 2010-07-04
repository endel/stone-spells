package com.stonespells.views.optionsmenu;

import java.util.Hashtable;
import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;
import org.puremvc.java.patterns.observer.Notification;

import com.stonespells.core.App;
import com.stonespells.core.GameView;
import com.stonespells.core.IWithMenuMediator;
import com.stonespells.facade.GameFacade;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.RenderableItemUI;
import com.stonespells.views.game.board.GameBoardMediator;
import com.stonespells.views.game.board.GameStateIndicatorMediator;

public class OptionsMenuMediator extends Mediator implements IMediator {
	
	public static final String NAME = "OptionsMenuMediator";
	
	// Notifications
	public static final String ENABLE = "OptionsMenuEnable";
	public static final String DISABLE = "OptionsMenuDisable";
	
	public static final int SIDE_LEFT = 0;
	public static final int SIDE_RIGHT = 1;
	
	// Used to render the side selected state
	private int sideSelected = -1;
	
	private IMediator mediator;
	
	private boolean hasMenu = false;
	private Vector hasCommand;
	
	public OptionsMenuMediator() {
		super(NAME, null);
		this.setViewComponent( new OptionsMenuUI(this) );
		hasCommand = new Vector();
	}
	
	public boolean isEnabled() {
		return this.hasMenu;
	}
	
	public OptionMenuItemMediator getOption(int side) {
		OptionMenuItemMediator menuItem = (OptionMenuItemMediator) facade.retrieveMediator(OptionMenuItemMediator.NAME);;
		menuItem.setViewComponent( ((OptionsMenuUI) this.viewComponent).getOption(side) );
		return menuItem;
	}
	
	public void addOption(OptionsMenuItemProxy item) {
		
		// Add command to current Canvas
		Command command = new Command(item.getNotificationName(), item.getLabel(), Command.SCREEN, item.getSide());
		((GameView) mediator.getViewComponent()).addCommand( command );
		
		((OptionsMenuUI) this.viewComponent).setOption( item.getSide(), item.getData());
		OptionMenuItemMediator menuItem = this.getOption( item.getSide() );
		menuItem.setData( item.getData() );
	}
	
	public void removeItemAtSide(int side) {
		this.getOption(side).setData(null);
	}
	
	public void clearOptions() {
		Object[] items = ((OptionsMenuUI) this.viewComponent).options;
		for (int i=0;i < items.length;i++) {
			items[i] = null;
		}
	}
	
	public String[] listNotificationInterests( )
	{
		return new String[] { RenderMediator.REGISTER_CANVAS, GameBoardMediator.SLOT_SELECTED, ENABLE, DISABLE };
	}
	
	public void handleNotification( INotification note )
	{
		if ( note.getName().equals(ENABLE) ) {
			this.hasMenu = true;
			
		} else if ( note.getName().equals(DISABLE) ) {
			this.hasMenu = false;
			
		} else if (note.getName().equals(GameBoardMediator.SLOT_SELECTED)) {
			int gameState = ((GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME)).getGameState();
			this.hasMenu = (gameState != GameBoardMediator.GAMESTATE_WAITING_OPONENT && gameState != GameBoardMediator.GAMESTATE_ENERGIZE);
		}
		
		// Do nothing if mediator are not IWithMenu instance
		mediator = ((RenderMediator) facade.retrieveMediator(RenderMediator.NAME)).getMediator();
		if (!(mediator instanceof IWithMenuMediator) || !this.hasMenu) {
			return;
		}
		
		// render partial items when rendering entire mediator
		// this notification is sent by RenderMediator
		if ( note.getName().equals(RenderMediator.FLUSH) ) {
			System.out.println("Flush OptionsMenuMediator");
			
			OptionsMenuUI viewComponent = (OptionsMenuUI) this.viewComponent;
			
			// render holder
			sendNotification(RenderMediator.RENDER_PARTIAL, OptionsMenuUI.holder.image, null);
			
			// render selected background
			if (sideSelected >= 0) {
				OptionsMenuUI.optionSelected.image.setPosition(
					(sideSelected == SIDE_LEFT) ? 0 : OptionsMenuUI.optionSelected.image.getWidth(),
					this.getBottomY(OptionsMenuUI.optionSelected.image)
				);
				sendNotification(RenderMediator.RENDER_PARTIAL, OptionsMenuUI.optionSelected.image, null);
				sideSelected = -1;
			}
			
			// render items
			int itemWidth = OptionsMenuUI.holder.image.getWidth();
			for (int side=0;side < viewComponent.options.length;side++) {
				OptionMenuItemMediator menuItem = this.getOption(side);
				if (menuItem.isValid()) {
					int marginX = 6;
					int posX = (side == SIDE_LEFT) ? marginX : itemWidth - (menuItem.getData().getImage().getWidth()) - marginX;
					
					// Manually center Y
					int posY = this.getBottomY(OptionsMenuUI.holder.image) + 3;
					
					menuItem.setPosition( posX, posY );
					menuItem.handleNotification(note);
				}
			}
		
		
		} else if (note.getName().equals(RenderMediator.REGISTER_CANVAS)) {
			
			this.clearOptions();
			
			// Add or update commands to the mediator
			if ( !((IWithMenuMediator) mediator).getMenuInitiated() ) {
				
				for (int i=0;i<2;i++) {
					OptionsMenuItemProxy item = ((IWithMenuMediator) mediator).getMenuOption( i );
					if (item != null) {
						item.setSide(i);
						this.addOption(item);
					}
				}
				
				// Register who already have commands added
				((IWithMenuMediator) mediator).setMenuInitiated(true);
				if (! hasCommand.contains(mediator.getMediatorName())) {
					hasCommand.addElement( mediator.getMediatorName() );
				}
				
			} else {
				
				for (int i=0;i<2;i++) {
					OptionMenuItemMediator item = this.getOption(i);
				}
				
			}
		}
	}
	
	private int getBottomY(Sprite relativeTo) {
		return App.HEIGHT - relativeTo.getHeight();
	}

	public void selectSide(int side) {
		this.sideSelected = side;
		// sendNotification(RenderMediator.FLUSH, null, null);
	}

}
