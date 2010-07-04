package com.stonespells.core;

import java.io.IOException;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;

import com.stonespells.facade.GameFacade;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.views.RenderMediator;

public class GameView extends GameCanvas implements IGameView {
	
	private boolean initiated = false;
	
	protected static Image background = null;
	protected IMediator mediator;
	
	public GameView(boolean supressKeyEvents, IMediator mediator) {
		super(supressKeyEvents);
		this.mediator = mediator;
		this.init();
	}
	
	public void initializeView() throws Exception {}
	
	public boolean isInit() {
		return initiated;		
	}
	
	public void init() {
		if (background == null) {
			try {
				background = Image.createImage("/background.png");
			} catch(IOException e) {
				System.out.println(e);
			}
		}
		try {
			this.initializeView();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Set default command listener to Command Translator
		this.setCommandListener( ((GameFacade)GameFacade.getInstance()).getCommandTranslator() );
		this.setFullScreenMode(true);
		initiated = true;
	}
	
	/**
	 * Get total width of the view
	 * @return int
	 */
	public int getTotalWidth() {
		return background.getWidth();
	}
	
	/**
	 * Get total height of the view
	 * @return int
	 */
	public int getTotalHeight() {
		return background.getHeight();
	}
	
	public Graphics getGraphics() {
		return super.getGraphics();
	}
	
	/**
	 * Delegate FLUSH to RenderMediator
	 */
	protected void flush() {
		GameFacade.getInstance().sendNotification(RenderMediator.FLUSH, this.mediator, null);
		flushGraphics();
	}
	
	protected void renderPartial(Sprite toRender) {
		GameFacade.getInstance().sendNotification(RenderMediator.RENDER_PARTIAL, toRender, null);
	}
	
	protected void sendNotification(String notificationName, Object body, String type) {
		GameFacade.getInstance().sendNotification(notificationName, body, type);
	}
	
	public void flushGraphics() {
		super.flushGraphics();
	}
	
	/**
	 * Render background into Canvas
	 */
	public void render() {
		Graphics g = getGraphics();
		g.drawImage(background, 0, 0, 0);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
