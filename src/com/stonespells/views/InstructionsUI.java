package com.stonespells.views;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.core.IGameView;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.WindowView;

public class InstructionsUI extends WindowView implements IGameView {

	public Image title;
	
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
	
	protected void keyPressed(int keyCode) {
		int gameAction = getGameAction(keyCode);
		
		if (gameAction == RIGHT) {
			sendNotification(PagedContentMediator.NEXT_PAGE, null, null);
		} else if (gameAction == LEFT) {
			sendNotification(PagedContentMediator.PRIOR_PAGE, null, null);
		}
		flush();
	}

	public void render() {
		super.render();
		Graphics g = this.getGraphics();
		
		int x = 4;
		int y = 6;
		g.drawImage(ResourceLibrary.STONE_TITLE, x + this.title.getWidth(), y + 6, 0);
		g.drawImage(title, 4, 6, 0);
	}
	
}
