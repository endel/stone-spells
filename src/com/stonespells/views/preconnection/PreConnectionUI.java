package com.stonespells.views.preconnection;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.core.IGameView;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.WindowView;

/**
 * Classe que possui e trata os componentes de visualização referentes
 * às opções pré-conexão do jogador.
 */
public class PreConnectionUI extends WindowView implements IGameView {
	
	private Sprite title;
	public Image CREATE_GAME;
	
	/**
	 * Instancia a classe, especifica o mediador que fará a comunicação entre a
	 * visualização e os dados e carrega as imagens a serem exibidas. E seta
	 * a posição do sprite title.
	 * @param mediator O mediador a fazer a conexão entre visualização e dados.
	 */
	public PreConnectionUI(IMediator mediator) {
		super(false, mediator);
		
		try {
			title = new Sprite(Image.createImage("/titles/jogar.png"));
			CREATE_GAME = Image.createImage("/menu-options/create.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		title.setPosition(4, 5);
	}
	
	/**
	 * Método que efetua o tratamento de teclas neste estado do jogo.
	 */
	protected void keyPressed(int keyCode) {
		// int gameAction = getGameAction(keyCode);
		
		int key = keyCode - 49;
		if ((key >= 0 && key < 9) || keyCode < 0) {
			sendNotification(PreConnectionMediator.LIST, mediator, null);
		}
		
		flush();
	}

	/**
	 * Método que faz a renderização do sprite title na posição especificada.
	 */
	public void render() {
		super.render();
		
		Graphics g = this.getGraphics();
		g.drawImage(ResourceLibrary.STONE_TITLE, this.title.getX() + this.title.getWidth(), this.title.getY() + 6, 0);
		title.paint(g);
	}
	
}
