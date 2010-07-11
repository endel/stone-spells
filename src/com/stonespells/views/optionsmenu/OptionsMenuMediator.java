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
 * Classe que faz a comunicação entre a parte visual do menu de opções
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
	 * como parâmetro um novo objeto OptionsMenuUI com a própria classe
	 * OptionsMenuMediator como parâmetro, e instancia o vetor de comandos
	 * do menu.
	 */
	public OptionsMenuMediator() {
		super(NAME, null);
		this.setViewComponent( new OptionsMenuUI(this) );
		hasCommand = new Vector();
	}
	
	/**
	 * Método que retorna a booleana que indica se o atual jogador
	 * possui um menu habilitado ou não.
	 * @return Booleana que indica se o atual jogador
	 * possui um menu habilitado ou não.
	 */
	public boolean isEnabled() {
		return this.hasMenu;
	}
	
	/**
	 * Método que obtém as opções disponíveis para cada jogador, instanciando-as
	 * em forma de menuItem e ligando-as a seus respectivos componentes de visualização.
	 * @param side Indica qual jogador está ativo
	 * @return Instância de um item do menu.
	 */
	public OptionMenuItemMediator getOption(int side) {
		OptionMenuItemMediator menuItem = (OptionMenuItemMediator) facade.retrieveMediator(OptionMenuItemMediator.NAME);;
		menuItem.setViewComponent( ((OptionsMenuUI) this.viewComponent).getOption(side) );
		return menuItem;
	}
	
	/**
	 * Método utilizado para adicionar opções ao menu. Se o vetor de comandos possui
	 * elementos, instancia e adiciona comandos ao mediador para fazer a conexão com
	 * seu comportamento, de acordo com o jogador ativo.
	 * @param item Um proxy que contém dados de um item do menu.
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
	 * Método que remove um item do menu do jogador especificado pelo parâmetro
	 * side
	 * @param side Especifica o jogador a ter a opção retornada
	 * removida de seu menu.
	 */
	public void removeItemAtSide(int side) {
		this.getOption(side).setData(null);
	}
	
	/**
	 * Método que limpa o array de options dos jogadores.
	 */
	public void clearOptions() {
		Object[] items = ((OptionsMenuUI) this.viewComponent).options;
		for (int i=0;i < items.length;i++) {
			items[i] = null;
		}
	}
	
	/**
	 * Método que retorna a lista de notificações relevantes a este mediador.
	 */
	public String[] listNotificationInterests( )
	{
		return new String[] { RenderMediator.REGISTER_CANVAS, GameBoardMediator.SLOT_SELECTED, SpellViewerMediator.CLOSE, ENABLE, DISABLE };
	}
	
	/**
	 * Método que trata determinada notificação. Compara o nome da notificação
	 * com os nomes das notificações existentes. Não faz nada se o mediador não for
	 * uma instância de IWithmenu. Renderiza os items aos poucos se a notificação
	 * tiver o nome FLUSH, e adiciona items ao menu se a notificação for chamada de 
	 * REGISTER_CANVAS.
	 * 
	 * @param A notificação a ser tratada
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
	 * Método que obtem o tamanho em Y do sprite especificado.
	 * @param relativeTo Sprite a ser utilizado para obtenção de tamanho
	 * @return o tamanho da tela menos o tamanho do sprite.
	 */
	private int getBottomY(Sprite relativeTo) {
		return App.HEIGHT - relativeTo.getHeight();
	}

	/**
	 * Método que seleciona o jogador ativo.
	 * @param side
	 */
	public void selectSide(int side) {
		this.sideSelected = side;
	}
	
	/**
	 * Método que remove um elemento do vetor hasCommand.
	 * @param name Nome do elemento a ser removido do vetor.
	 */
	public void removeInitiatedReference(Object name) {
		hasCommand.removeElement(name);
	}

}
