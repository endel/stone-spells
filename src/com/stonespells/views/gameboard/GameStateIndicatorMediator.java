package com.stonespells.views.gameboard;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.core.ResourceLibrary;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuUI;

public class GameStateIndicatorMediator extends Mediator implements IMediator {
	public static final String NAME = "ConcentrateIndicatorMediator";
	
	// Notifications
	public static final String ENABLE = "ConcentrateIndicatorEnable";
	public static final String DISABLE = "ConcentrateIndicatorDisable";
	
	public GameStateIndicatorMediator() {
		super(NAME, null);
	}
	
	public String[] listNotificationInterests() {
		return new String[] { ENABLE, DISABLE };
	}
	
	public boolean isEnabled() {
		int gameState = this.getGameBoard().getGameState();
		return (gameState == GameBoardMediator.GAMESTATE_WAITING_OPONENT || gameState == GameBoardMediator.GAMESTATE_ENERGIZE);
	}
	
	public void handleNotification( INotification note ) {
		
		// this notification is sent by RenderMediator
		if (note.getName().equals(RenderMediator.FLUSH)) {
			
			// Render game state indicator only if needed
			if (!this.isEnabled())
				return;
			
			int gameState = this.getGameBoard().getGameState();
			
			// Render backgrounds
			sendNotification(RenderMediator.RENDER_PARTIAL, OptionsMenuUI.holder.image, null);
			for (int i=0; i<2; i++) {
				OptionsMenuUI.optionSelected.image.setPosition((i==0) ? 0 : OptionsMenuUI.optionSelected.image.getWidth(), OptionsMenuUI.holder.image.getY());
				sendNotification(RenderMediator.RENDER_PARTIAL, OptionsMenuUI.optionSelected.image, null);
			}
			
			int labelX = 4;
			int labelY = OptionsMenuUI.holder.image.getY() + 4;
			
			if (gameState == GameBoardMediator.GAMESTATE_ENERGIZE)
			{
				Sprite concentrationLabel = new Sprite(ResourceLibrary.ENERGIZE_TITLE);
				Sprite concentrationIndicator = new Sprite(ResourceLibrary.ENERGY_ICON);
				
				// Energize label
				concentrationLabel.setPosition(labelX, labelY);
				sendNotification(RenderMediator.RENDER_PARTIAL, concentrationLabel, null);

				// Render indicators
				int concentrationX = OptionsMenuUI.holder.image.getWidth();
				int concentrationY = OptionsMenuUI.holder.image.getY();
				concentrationIndicator.setPosition(concentrationX - 32, concentrationY + 9);
				sendNotification(RenderMediator.RENDER_PARTIAL, concentrationIndicator, null);
				
				PlayerProxy player = ((PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME)).getPlayer();
				RenderMediator.drawString( String.valueOf(player.getConcentration()), concentrationX - 16, concentrationY + 7);
				
			} else if (gameState == GameBoardMediator.GAMESTATE_WAITING_OPONENT)
			{
				Sprite waitingOponentLabel = null;
				try {
					waitingOponentLabel = new Sprite(Image.createImage("/menu-options/awaiting-your-turn.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				waitingOponentLabel.setPosition(labelX, labelY);
				sendNotification(RenderMediator.RENDER_PARTIAL, waitingOponentLabel, null);
				
			}
			
		}
	}
	
	private GameBoardMediator getGameBoard() {
		return (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
		
	}
	
}
