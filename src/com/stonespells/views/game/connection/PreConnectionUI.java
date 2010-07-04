package com.stonespells.views.game.connection;

import java.io.IOException;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.patterns.observer.Notification;

import com.stonespells.core.IGameView;
import com.stonespells.core.ImageLibrary;
import com.stonespells.core.WindowView;
import com.stonespells.views.game.board.GameBoardMediator;

public class PreConnectionUI extends WindowView implements IGameView {
	
	private Sprite title;
	public Image CREATE_GAME;
	
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
	
	protected void keyPressed(int keyCode) {
		// int gameAction = getGameAction(keyCode);
		
		int key = keyCode - 49;
		// check valid position of slot
		if (key >= 0 && key < 9) {
			sendNotification(PreConnectionMediator.LIST, mediator, null);
		}
		
		flush();
	}

	public void render() {
		super.render();
		
		Graphics g = this.getGraphics();
		g.drawImage(ImageLibrary.STONE_TITLE, this.title.getX() + this.title.getWidth(), this.title.getY() + 6, 0);
		title.paint(g);
	}
	
}
