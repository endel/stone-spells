package com.stonespells.views;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.patterns.observer.Notification;

import com.stonespells.core.GameView;
import com.stonespells.core.IGameView;
import com.stonespells.core.ResourceLibrary;

/**
 * Classe que carrega e pinta as imagens da tela do menu principal.
 */
public class MainMenuUI extends GameView implements IGameView {
	
	private Image logo;
	private int selectedIndex = 0;
	private Sprite options[];
	private Image selectionIcon;

	/**
	 * Construtor que especifica o mediador a tratar a comuni��o
	 * entre dados e imagens do menu principal.
	 */
	public MainMenuUI(IMediator mediator) {
		super(false, mediator);
	}

	/**
	 * M�todo que faz o carregamento das imagens do menu principal,
	 * alocandoas dentro de um vetor de sprites.
	 */
	public void initializeView() throws Exception {
		logo = Image.createImage("/main-menu/logo.png");
		
		options = new Sprite[] {
			new Sprite(Image.createImage("/main-menu/play.png")),
			new Sprite(Image.createImage("/main-menu/my-inventory.png")),
			new Sprite(Image.createImage("/main-menu/instructions.png")),
			new Sprite(Image.createImage("/main-menu/get-spells.png")),
			new Sprite(Image.createImage("/main-menu/exit.png"))
		};
		selectionIcon = ResourceLibrary.ENERGY_ICON;
	}
	
	/**
	 * M�todo que obt�m o n�mero de elementos salvos no vetor de sprites.
	 */
	public int getNumberOfOptions() {
		return options.length;
	}
	
	/**
	 * M�todo que retorna a posi��o do elemento escolhi do menu de op��es.
	 */
	public int getSelectedItem() {
		return this.selectedIndex;
	}
	
	/**
	 * M�todo que trata as teclas pressionadas na tela do menu de op��es.
	 * De acordo com o bot�o pressionado, testa-se a posi��o do elemento pressionado,
	 * muda-se o elemento selecionado, ou envia a notifica��o ao mediator de que determinado
	 * item foi selecionado.
	 * Ap�s cada a��o o mediador d� a "descarga" ao contexto gr�fico.
	 */
	protected void keyPressed(int keyCode) {
		int gameAction = getGameAction(keyCode);
		
		switch (gameAction) {
			case UP:
				selectedIndex = (selectedIndex <= 0) ? options.length-1 : selectedIndex-1;
				mediator.handleNotification(new Notification(MainMenuMediator.ITEM_CHANGE, this, null));
			break;
			case DOWN:
				selectedIndex = (selectedIndex >= options.length-1) ? 0 : selectedIndex + 1;
				mediator.handleNotification(new Notification(MainMenuMediator.ITEM_CHANGE, this, null));
			break;
			case FIRE:
				mediator.handleNotification(new Notification(MainMenuMediator.ITEM_SELECT, this, null));
			break;
		}
		flush();
		
	}

	/**
	 * M�todo que obt�m o contexto gr�fico e efetua o posicionamento
	 * e a pintura dos elementos contidos no vetor de sprites options.
	 */
	public void render() {
		Graphics g = getGraphics();
		super.render();
		
		g.setColor(255,255,255);
		g.drawImage(logo, 10, 10, 0);
		
		for (int i = 0;i<options.length; i++) {
			options[i].setPosition(this.getTotalWidth() - options[i].getWidth() - 6, 86 + (25 * i) + 1);
			options[i].paint(g);
		}
		
		g.drawImage(selectionIcon, options[selectedIndex].getX() - 12, options[selectedIndex].getY() + 6, 0);
		flushGraphics();
	}
	
	/**
	 * M�todo para a detrui��o do menu de op��es.
	 */
	public void destroy() {}
}

