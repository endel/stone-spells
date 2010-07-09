package com.stonespells.views.gameboard;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.core.IGameView;
import com.stonespells.core.WindowView;

/**
 * Classe que trata da pintura em tela de elementos relativos somente
 * à interface do jogo.
 */
public class GameBoardUI extends WindowView implements IGameView {

	private int lifePositionX[] = new int[2];
	private Sprite playerNames[] = new Sprite[2];
	private Sprite lifeIcon;
	private SpellHolderUI spellHolders[];
	private int qtySlots;
	
	
	/**
	 * Construtor da classe que especifica um mediator para a comunicação entre dados
	 * e elementos de visualização e o número de slots portadores de feitiços.
	 * Também efetua o carregamento da imagem do coração que representa a vida do jogador,
	 * e da imagem que indica a quem pertence a quantia de vida.
	 * @param mediator O mediador especificado.
	 * @param qtySlots O número de slots de feitiços
	 */
	public GameBoardUI(IMediator mediator, int qtySlots) {
		super(false, mediator);
		this.qtySlots = qtySlots;
		this.spellHolders = new SpellHolderUI[this.qtySlots];
		for (int i = 0;i < this.qtySlots; i++) {
			this.spellHolders[i] = new SpellHolderUI();
			this.spellHolders[i].image = SpellHolderUI.holderSprite;
		}
		
		// Load header graphics and icons;
		try {
			this.lifeIcon = new Sprite(Image.createImage("/icons/heart.png"));
			this.playerNames[0] = new Sprite(Image.createImage("/titles/you.png"));
			this.playerNames[1] = new Sprite(Image.createImage("/titles/other.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initializeView() throws Exception {
		
	}
	
	/**
	 * Obtém o slot que se encontra na posição especificada.
	 * @param i Posição do slot desejado.
	 * @return O slot em questão.
	 */
	public SpellHolderUI getHolderAt(int i) {
		return this.spellHolders[i];
	}
	
	/**
	 * Método que indica o botão pressionado e o trata de acordo com sua conexão
	 * a determinado slot.
	 */
	protected void keyPressed(int keyCode) {
		// int gameAction = getGameAction(keyCode);
		
		int slotSelected = keyCode - 49;
		// check valid position of slot
		if (slotSelected >= 0 && slotSelected < this.qtySlots) {
			sendNotification(GameBoardMediator.SLOT_SELECTED, this.spellHolders[slotSelected], null);
			//mediator.handleNotification( new Notification(GameBoardMediator.SLOT_SELECTED, this.spellHolders[slotSelected], null) );
		}
		flush();
	}

	/**
	 * Método que adiciona os elementos da interface do jogo ao contexto gráfico.
	 */
	public void render() {
		super.render();
		
		Graphics g = getGraphics();
		// render player names and heart icon
		int margin = 4;
		int lifeIconWidth = this.lifeIcon.getWidth();
		for (int i=0;i<2;i++) {
			int x = (i==0) ? margin : this.getTotalWidth() - this.playerNames[i].getWidth() - margin;
			
			this.playerNames[i].setPosition(x, 5);
			this.lifeIcon.setPosition((i==0) ? x + this.playerNames[i].getWidth() + margin : x - lifeIconWidth - margin, getLifePositionY());
			this.lifePositionX[i] = this.lifeIcon.getX() + ( (i==0) ? lifeIconWidth + margin :  - lifeIconWidth - margin );
			this.playerNames[i].paint(g);
			this.lifeIcon.paint(g);
		}
	}
	
	/**
	 * Método que obtém a posição x do indicador de vida de determinado jogador.
	 */
	public int getLifePositionX(int player) {
		return this.lifePositionX[player];
	}
	
	/**
	 * Método que obtém a posição y do indicador de vida dos jogadores.
	 */
	public int getLifePositionY() {
		return 12;
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
