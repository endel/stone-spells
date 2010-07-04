package com.stonespells.views.gameboard;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.core.App;
import com.stonespells.core.IGameView;
import com.stonespells.core.IWithMenuMediator;
import com.stonespells.core.ImageLibrary;
import com.stonespells.core.WithMenuMediator;
import com.stonespells.facade.GameFacade;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.PlayerVO;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellListVO;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.gameboard.communication.PlayContextProxy;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionMenuItemMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class GameBoardMediator extends WithMenuMediator implements IMediator, IWithMenuMediator {
	
	public static final String NAME = "GameBoardMediator";
	
	// Notifications
	public static final String SLOT_SELECTED = "GameBoardSwapSlotSelected";
	public static final String TURN_BEGIN = "GameBoardTurnBegin";
	public static final String END_TURN = "GameBoardEndTurn";
	public static final String ENERGIZE_SPELL = "GameBoardEnergizeSpell";
	public static final String ENERGIES_DISTRIBUTED = "GameBoardEnergiesDistributed";
	public static final String PREPARE_VIEW = "GameBoardPrepareView";
	
	// Communication commands
	public static final String WAIT_FOR_OPPONENT = "GameBoardWaitForOpponent";
	
	// Menu options
	public static final String OPTION_VIEW = "GameBoardOptionView";
	
	// Game states
	public static final int GAMESTATE_ENERGIZE = 0;
	public static final int GAMESTATE_SELECT_SPELLS = 1;
	public static final int GAMESTATE_WAITING_OPONENT = 2;
	
	private static final int QTY_SLOTS = 9;
	
	private PlayerVO players[];
	private int numPlayers = 0;
	
	private int gameState = GAMESTATE_ENERGIZE;
	
	public GameBoardMediator() {
		super(NAME, null);
		GameBoardUI view = new GameBoardUI(this, QTY_SLOTS);
		
		this.setViewComponent(view);
		this.players = new PlayerVO[2];
	}
	
	public void setGameState(int state) {
		this.gameState = state;
	}
	
	public int getGameState() {
		return this.gameState;
	}
	
	public void addPlayer(PlayerProxy player) {
		this.players[numPlayers] = (PlayerVO) player.getData();
		
		PlayContextProxy playContext = (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
		if (numPlayers == 0) {
			playContext.setPlayer(player);
		} else {
			playContext.setOpponent(player);
		}
		numPlayers++;
	}
	
	public PlayerProxy getCurrentPlayer() {
		PlayerProxy player = (PlayerProxy) facade.retrieveProxy(PlayerProxy.NAME);
		player.setData(this.players[0]);
		return player;
	}
	
	public String[] listNotificationInterests() {
		return new String[] { GameBoardMediator.SLOT_SELECTED };
	}
	
	public void handleNotification( INotification note ) {
		PlayContextProxy playContext = (PlayContextProxy) facade.retrieveProxy(PlayContextProxy.NAME);
		SpellListProxy hand = playContext.getPlayer().getSpellList();
		
		if (note.getName().equals(RenderMediator.FLUSH)) {
			
			// render background and window
			GameBoardUI gameBoard = ((GameBoardUI) this.viewComponent);
			gameBoard.render();
			
			// render spell holders
			SpellHolderMediator spellHolder = (SpellHolderMediator) facade.retrieveMediator(SpellHolderMediator.NAME);
			int windowX = (App.WIDTH/2 - gameBoard.getBoxWidth()/2) - 1;
			int windowY = (App.HEIGHT/2 - gameBoard.getBoxHeight()/2) - 1;
			for (int i=0; i<QTY_SLOTS; i++) {
				SpellProxy spell = hand.getSpellAt(i);
				int position = spell.getPosition();
				
				int line = position / 3;
				int column = position % 3;
				int holderSize = spellHolder.getSize();
				
				spellHolder.setViewComponent( ((GameBoardUI) this.viewComponent).getHolderAt( position ) );
				spellHolder.setPosition(windowX + 21 + (column * (holderSize + 4)), windowY + 8 + (line * (holderSize + 3)));
				spellHolder.setSpell( spell );
				spellHolder.handleNotification( note );
			}
			
			// draw player's lifebar
			for (int i=0;i<this.players.length;i++) {
				RenderMediator.drawString( String.valueOf(this.players[i].life) , gameBoard.getLifePositionX(i), gameBoard.getLifePositionY());
			}
			
		} else if (note.getName().equals(SLOT_SELECTED)) {
			
			SpellHolderMediator spellHolder = (SpellHolderMediator) facade.retrieveMediator(SpellHolderMediator.NAME);
			spellHolder.setViewComponent( note.getBody() );
			
			if (gameState == GAMESTATE_ENERGIZE) {
				sendNotification(ENERGIZE_SPELL, spellHolder.getSpell(), null);
				
			} else if (gameState == GAMESTATE_SELECT_SPELLS) {
				SpellProxy spell = spellHolder.getSpell();
				
				if (spell.canCast()) {
					spellHolder.swapSelect();
				} else {
					// TODO: play error sound
					System.out.println("Insuficient concentration points for '" + spell.getName() + "'");
				}
				
				// Change option image if has spell selected or not
				OptionsMenuMediator optionsMenu = (OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME);
				OptionMenuItemMediator optionMenu = optionsMenu.getOption(OptionsMenuMediator.SIDE_RIGHT);
				if (hand.hasSpellSelected()) {
					optionMenu.changeImage( ImageLibrary.OPTION_CAST );
					optionMenu.getData().setLabel("Cast");
				} else {
					optionMenu.changeImage( ImageLibrary.OPTION_END_TURN );
					optionMenu.getData().setLabel("End my turn");
				}
			}
			
		} else if (note.getName().equals(RenderMediator.REGISTER_CANVAS)) {
			OptionsMenuMediator optionsMenu = (OptionsMenuMediator) facade.retrieveMediator( OptionsMenuMediator.NAME );
			optionsMenu.getOption(OptionsMenuMediator.SIDE_LEFT).changeImage(ImageLibrary.OPTION_VIEW);
			optionsMenu.getOption(OptionsMenuMediator.SIDE_RIGHT).changeImage(ImageLibrary.OPTION_END_TURN);
		}
	}

	public OptionsMenuItemProxy getMenuOption(int side) {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.create();
		if (side == OptionsMenuMediator.SIDE_LEFT) {
			item.setImage(ImageLibrary.OPTION_VIEW);
			item.setNotificationName( OPTION_VIEW );
			item.setLabel("View");
		} else {
			item.setImage( ImageLibrary.OPTION_END_TURN );
			item.setNotificationName( END_TURN );
			item.setLabel("End my turn");
		}
		return item;
	}
	
}
