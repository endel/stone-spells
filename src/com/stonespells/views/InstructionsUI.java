package com.stonespells.views;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.core.IGameView;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.WindowView;

/**
 * Classe que faz o carregamente do bot�o de instru��es e sua pintura na tela.
 */
public class InstructionsUI extends WindowView implements IGameView {

	public Image title;
	
	/**
	 * Construtor que especifica o mediador a tratar do uso do bot�o de instru��es
	 * e carrega a imagem dele.
	 */
	public InstructionsUI(IMediator mediator) {
		super(false, mediator);
		try {
			title = Image.createImage("/titles/instrucoes.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initializeView() throws Exception {
		
	}
	
	/**
	 * M�todo que trata uma tecla pressionada pelo jogador, enviando uma mensagem
	 * ao mediador especificado no construtor da classe.
	 */
	protected void keyPressed(int keyCode) {
		int gameAction = getGameAction(keyCode);
		
		if (gameAction == RIGHT) {
			sendNotification(PagedContentMediator.NEXT_PAGE, null, null);
		} else if (gameAction == LEFT) {
			sendNotification(PagedContentMediator.PRIOR_PAGE, null, null);
		}
		flush();
	}

	/**
	 * M�todo que renderiza o item que possibilita a visualiza��o da tela 
	 * de instru��es .
	 */
	public void render() {
		super.render();
		Graphics g = this.getGraphics();
		
		int x = 4;
		int y = 6;
		g.drawImage(ResourceLibrary.STONE_TITLE, x + this.title.getWidth(), y + 6, 0);
		g.drawImage(title, 4, 6, 0);
	}
	
}
