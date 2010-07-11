package com.stonespells.views.gameboard;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;

import com.stonespells.core.App;
import com.stonespells.core.IWithMenuMediator;
import com.stonespells.core.Logger;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.WithMenuMediator;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionMenuItemMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**Classe que faz a mediação entre o jogo e componentes de visualização,
 * de acordo com as notificações especificadas. 
 */
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
	public static final int GAMESTATE_VIEWING_OPONENT_SPELLS = 3;
	
	private static final int QTY_SLOTS = 9;
	
	private int gameState = GAMESTATE_ENERGIZE;
	
	/**
	 * Contrutor da classe. Instancia view passando como parâmetro a própria classe
	 * mediador e a quantidade de slots no jogo.
	 */
	public GameBoardMediator() {
		super(NAME, null);
		GameBoardUI view = new GameBoardUI(this, QTY_SLOTS);
		this.setViewComponent(view);
	}
	
	/**
	 * Método que configura o estado do jogo.
	 * @param state Estado do jogo.
	 */
	public void setGameState(int state) {
		this.gameState = state;
	}
	
	/**
	 * Método que retorna o estado do jogo.
	 * @return O estado do jogo.
	 */
	public int getGameState() {
		return this.gameState;
	}
	
	/**
	 * Método que retorna um array de notificações relevantes ao mediador presente.
	 */
	public String[] listNotificationInterests() {
		return new String[] { GameBoardMediator.SLOT_SELECTED, SpellViewerMediator.CLOSE };
	}
	
	/**
	 * Método que lida com determinada notificação. Obtém insformações do jogador e de
	 * sua lsita de spells.Renderiza as informações do jogador ou o contêiner de spells,
	 * ou faz o registro do canvas que possui as opções do jogador.
	 * @param A notificação especificada.
	 */
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
			for (int i=0;i<2;i++) {
				PlayerProxy player = (i==0) ? playContext.getPlayer() : playContext.getOpponent();
				RenderMediator.drawString( String.valueOf(player.getLife()) , gameBoard.getLifePositionX(i), gameBoard.getLifePositionY());
			}
			
			// Change option image if has spell selected or not
			OptionsMenuMediator optionsMenu = (OptionsMenuMediator) facade.retrieveMediator(OptionsMenuMediator.NAME);
			OptionMenuItemMediator optionMenu = optionsMenu.getOption(OptionsMenuMediator.SIDE_RIGHT);
			if (hand.hasSpellSelected()) {
				optionMenu.changeImage( ResourceLibrary.OPTION_CAST );
				optionMenu.getData().setLabel("Cast");
			} else {
				optionMenu.changeImage( ResourceLibrary.OPTION_END_TURN );
				optionMenu.getData().setLabel("End my turn");
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
					Logger.instance.println("Insuficient concentration points for '" + spell.getName() + "'");
				}
				
			}
			
		} else if (note.getName().equals(SpellViewerMediator.CLOSE)) {
			if (this.getGameState() == GAMESTATE_VIEWING_OPONENT_SPELLS) {
				this.setGameState(GAMESTATE_ENERGIZE);
				
				System.out.println("GameBoardMediator > ");
				System.out.println("GameState => " + this.getGameState());
			}
			
		} else if (note.getName().equals(RenderMediator.REGISTER_CANVAS)) {
			OptionsMenuMediator optionsMenu = (OptionsMenuMediator) facade.retrieveMediator( OptionsMenuMediator.NAME );
			optionsMenu.getOption(OptionsMenuMediator.SIDE_LEFT).changeImage(ResourceLibrary.OPTION_VIEW);
			optionsMenu.getOption(OptionsMenuMediator.SIDE_RIGHT).changeImage(ResourceLibrary.OPTION_END_TURN);
		}
	}

	/**
	 * Método que instancia um proxy para manipulação dos dados de um item do menu,
	 * e trata as opções de acordo com o parâmetro passado
	 * @side Especifica posição dos items deste menu.
	 */
	public OptionsMenuItemProxy getMenuOption(int side) {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.create();
		if (side == OptionsMenuMediator.SIDE_LEFT) {
			item.setImage(ResourceLibrary.OPTION_VIEW);
			item.setNotificationName( OPTION_VIEW );
			item.setLabel("View");
		} else {
			item.setImage( ResourceLibrary.OPTION_END_TURN );
			item.setLabel("End my turn");
			item.setNotificationName( END_TURN );
		}
		return item;
	}
	
}
