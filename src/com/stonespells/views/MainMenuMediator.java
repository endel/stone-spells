package com.stonespells.views;

import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.controllers.spells.TemplateSpellCommand;
import com.stonespells.core.IRenderable;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;

public class MainMenuMediator extends Mediator implements IMediator {
	
	public static final String NAME = "MainMenuMediator";
	
	public static final String ITEM_SELECT = "MainMenuMediatorItemSelectNotification";
	public static final String ITEM_CHANGE = "MainMenuMediatorItemChangeNotification";
	
	public static final String PLAY_SELECTED = "MainMenuMediatorPlaySelectedNotification";
	public static final String INVENTORY_SELECTED = "MainMenuMediatorInventorySelectedNotification";
	public static final String INSTRUCTIONS_SELECTED = "MainMenuMediatorInstructionsSelectedNotification";
	public static final String BUY_SELECTED = "MainMenuMediatorBuySelectedNotification";
	public static final String EXIT_SELECTED = "MainMenuMediatorExitSelectedNotification";
	
	private static final int PLAY_SELECTION = 0;
	private static final int INVENTORY_SELECTION = 1;
	private static final int INSTRUCTIONS_SELECTION = 2;
	private static final int BUY_SELECTION = 3;
	private static final int EXIT_SELECTION = 4;
	
	public MainMenuMediator() {
		super(NAME, null);
		this.setViewComponent( new MainMenuUI(this) );
	}
	
	public String[] listNotificationInterests() {
		return new String[] {};
	}
	
	public void handleNotification( INotification note )
	{
		if (note.getName().equals(RenderMediator.FLUSH)) {
			((IRenderable) this.viewComponent).render();
			
		} else if (note.getName().equals(ITEM_SELECT)) {
			
			int selectedItem = ((MainMenuUI) this.viewComponent).getSelectedItem();
			switch (selectedItem) {
			
				case PLAY_SELECTION:
					sendNotification(PLAY_SELECTED, this, null);
				break;
				
				case INVENTORY_SELECTION:
					sendNotification(INVENTORY_SELECTED, this, null);
				break;
				
				case INSTRUCTIONS_SELECTION:
					sendNotification(INSTRUCTIONS_SELECTED, this, null);
				break;
				
				case BUY_SELECTION:
					sendNotification(BUY_SELECTED, this, null);
				break;
				
				case EXIT_SELECTION:
					sendNotification(EXIT_SELECTED, this, null);
				break;
			}
			
		} else if (note.getName().equals(ITEM_CHANGE)) {
			// navigate on items
		}
	}
	
}
