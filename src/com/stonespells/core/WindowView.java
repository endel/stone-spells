package com.stonespells.core;

import java.io.IOException;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.views.RenderMediator;

/**
 * Classe que trata da pintura da janela na tela *
 */
public class WindowView extends GameView implements IGameView {
	
	private static Image windowBackground;
	private static Image header;
	
	private boolean hasHeader = false;
	private String title;
	
	public WindowView(boolean supressKeyEvents, IMediator mediator) {
		super(supressKeyEvents, mediator);
	}
	
	/**
	 * Inicializa a pintura da janela, criando duas imagens a serem pintadas.
	 */
	public void init() {
		super.init();
		// load static images in the first time
		if (windowBackground == null) {
			try {
				windowBackground = Image.createImage("/box.png");
				header = Image.createImage("/box-header.png");
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Obtém altura da caixa a ser pintada.
	 * @return
	 */
	public int getBoxWidth() {
		return windowBackground.getWidth();
	}
	/**
	 * Obtém largura da caixa a ser pintada.
	 * @return
	 */
	public int getBoxHeight() {
		return windowBackground.getHeight();
	}
	
	public int getContentX() {
		return this.getTotalWidth()/2 - this.getBoxWidth()/2 + 6;
	}
	
	public int getContentY() {
		return this.getTotalHeight()/2 - this.getBoxHeight()/2 + 28;
	}
	
	/**
	 * Especifica o título para a janela a ser exibida.
	 */
	public void setTitle(String t) {
		this.hasHeader = true;
		this.title = t;
	}
	
	/**
	 * Pinta janela na tela.
	 * Você deve chamar super.paint(g, x, y) se sobrescrever este método.
	 * @param g
	 * @param x
	 * @param y
	 */
	public void render() {
		super.render();
		Graphics g = getGraphics();
		
		int x = (App.WIDTH/2 - this.getBoxWidth()/2) - 1;
		int y = (App.HEIGHT/2 - this.getBoxHeight()/2) - 1;
		
		g.drawImage(windowBackground, x, y, 0);
		if (this.hasHeader) {
			g.drawImage(header, x, y, 0);
			RenderMediator.drawString(title, x + 8, y + 6);
		}
	}
	
}