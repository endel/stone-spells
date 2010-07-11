package com.stonespells.views.optionsmenu;

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.core.App;
import com.stonespells.core.GameView;
import com.stonespells.core.IWithMenuMediator;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.gameboard.GameBoardMediator;
import com.stonespells.views.gameboard.SpellViewerMediator;

/**
 * Classe que faz a comunica��o entre a parte visual do menu de op��es
 * e seus comportamentos.
 *
 */
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
	
	/**
	 * Construtor da classe. Chama o construtor da classe pai, passando
	 * como par�metro um novo objeto OptionsMenuUI com a pr�pria classe
	 * OptionsMenuMediator como par�metro, e instancia o vetor de comandos
	 * do menu.
	 */
	public OptionsMenuMediator() {
		super(NAME, null);
		this.setViewComponent( new OptionsMenuUI(this) );
		hasCommand = new Vector();
	}
	
	/**
	 * M�todo que retorna a booleana que indica se o atual jogador
	 * possui um menu habilitado ou n�o.
	 * @return Booleana que indica se o atual jogador
	 * possui um menu habilitado ou n�o.
	 */
	public boolean isEnabled() {
		return this.hasMenu;
	}
	
	/**
	 * M�todo que obt�m as op��es dispon�veis para cada jogador, instanciando-as
	 * em forma de menuItem e ligando-as a seus respectivos componentes de visualiza��o.
	 * @param side Indica qual jogador est� ativo
	 * @return Inst�ncia de um item do menu.
	 */
	public OptionMenuItemMediator getOption(int side) {
		OptionMenuItemMediator menuItem = (OptionMenuItemMediator) facade.retrieveMediator(OptionMenuItemMediator.NAME);;
		menuItem.setViewComponent( ((OptionsMenuUI) this.viewComponent).getOption(side) );
		return menuItem;
	}
	
	/**
	 * M�todo utilizado para adicionar op��es ao menu. Se o vetor de comandos possui
	 * elementos, instancia e adiciona comandos ao mediador para fazer a conex�o com
	 * seu comportamento, de acordo com o jogador ativo.
	 * @param item Um proxy que cont�m dados de um item do menu.
	 */
	public void addOption(OptionsMenuItemProxy item) {		
		// Add command to current Canvas
		if (! hasCommand.contains(mediator.getMediatorName())) {
			Command command = new Command(item.getNotificationName(), item.getLabel(), Command.SCREEN, item.getSide());
			((GameView) mediator.getViewComponent()).addCommand( command );
		}
		
		((OptionsMenuUI) this.viewComponent).setOption( item.getSide(), item.getData());
		OptionMenuItemMediator menuItem = this.getOption( item.getSide() );
		menuItem.setData( item.getData() );
	}
	
	/**
	 * M�todo que remove um item do menu do jogador especificado pelo par�metro
	 * side
	 * @param side Especifica o jogador a ter a op��o retornada
	 * removida de seu menu.
	 */
	public void removeItemAtSide(int side) {
		this.getOption(side).setData(null);
	}
	
	/**
	 * M�todo que limpa o array de options dos jogadores.
	 */
	public void clearOptions() {
		Object[] items = ((OptionsMenuUI) this.viewComponent).options;
		for (int i=0;i < items.length;i++) {
			items[i] = null;
		}
	}
	
	/**
	 * M�todo que retorna a lista de notifica��es relevantes a este mediador.
	 */
	public String[] listNotificationInterests( )
	{
		return new String[] { RenderMediator.REGISTER_CANVAS, GameBoardMediator.SLOT_SELECTED, SpellViewerMediator.CLOSE, ENABLE, DISABLE };
	}
	
	/**
	 * M�todo que trata determinada notifica��o. Compara o nome da notifica��o
	 * com os nomes das notifica��es existentes. N�o faz nada se o mediador n�o for
	 * uma inst�ncia de IWithmenu. Renderiza os items aos poucos se a notifica��o
	 * tiver o nome FLUSH, e adiciona items ao menu se a notifica��o for chamada de 
	 * REGISTER_CANVAS.
	 * 
	 * @param A notifica��o a ser tratada
	 */
	public void handleNotification( INotification note )
	{
		
		if ( note.getName().equals(ENABLE) ) {
			this.hasMenu = true;
			
		} else if ( note.getName().equals(DISABLE)) {
			this.hasMenu = false;
		} else if ( note.getName().equals(SpellViewerMediator.CLOSE) ) {
			GameBoardMediator gameBoard = (GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME);
			if (gameBoard.getGameState() == GameBoardMediator.GAMESTATE_ENERGIZE) {
				this.hasMenu = false;
			}
			
		} else if (note.getName().equals(GameBoardMediator.SLOT_SELECTED)) {
			int gameState = ((GameBoardMediator) facade.retrieveMediator(GameBoardMediator.NAME)).getGameState();
			this.hasMenu = (gameState != GameBoardMediator.GAMESTATE_WAITING_OPONENT && gameState != GameBoardMediator.GAMESTATE_ENERGIZE);
		}
		
		mediator = ((RenderMediator) facade.retrieveMediator(RenderMediator.NAME)).getMediator();
		if (!(mediator instanceof IWithMenuMediator)) {
			return;
		}
		
		// render partial items when rendering entire mediator
		// this notification is sent by RenderMediator
		if ( note.getName().equals(RenderMediator.FLUSH) ) {
			
			if (!this.hasMenu) {
				return;
			}
			
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
		}
	}
	
	/**
	 * M�todo que obtem o tamanho em Y do sprite especificado.
	 * @param relativeTo Sprite a ser utilizado para obten��o de tamanho
	 * @return o tamanho da tela menos o tamanho do sprite.
	 */
	private int getBottomY(Sprite relativeTo) {
		return App.HEIGHT - relativeTo.getHeight();
	}

	/**
	 * M�todo que seleciona o jogador ativo.
	 * @param side
	 */
	public void selectSide(int side) {
		this.sideSelected = side;
	}
	
	/**
	 * M�todo que remove um elemento do vetor hasCommand.
	 * @param name Nome do elemento a ser removido do vetor.
	 */
	public void removeInitiatedReference(Object name) {
		hasCommand.removeElement(name);
	}

}
