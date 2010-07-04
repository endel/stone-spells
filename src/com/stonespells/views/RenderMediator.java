package com.stonespells.views;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;
import org.puremvc.java.patterns.observer.Notification;

import com.stonespells.controllers.spells.TemplateSpellCommand;
import com.stonespells.core.App;
import com.stonespells.core.Font;
import com.stonespells.core.GameView;
import com.stonespells.facade.GameFacade;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.game.board.GameStateIndicatorMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class RenderMediator extends Mediator implements IMediator {
	
	public static final String NAME = "RenderMediator";
	
	public static final String REGISTER_CANVAS = "RenderMediatorRegisterCanvasNotification";
	public static final String FLUSH = "RenderMediatorFlushNotification";
	public static final String RENDER_PARTIAL = "RenderMediatorRenderPartialNotification";
	
	private static Font font;
	
	static {
		font = new Font("/fonts/monofonto.png");
	}
	
	private GameView current;
	private String currentMediatorName;
	
	public RenderMediator() {
		super(NAME, ((GameFacade) GameFacade.getInstance()).getApp());
	}
	
	public static void drawString(String text, int x, int y) {
		Graphics g =((RenderMediator) GameFacade.getInstance().retrieveMediator(RenderMediator.NAME)).getGraphics();
		font.drawString(g, text, x, y);
	}
	
	public Graphics getGraphics() {
		return this.current.getGraphics();
	}
	
	public GameView getCanvas() {
		return this.current;
	}
	
	public String[] listNotificationInterests( )
	{
		return new String[] { REGISTER_CANVAS, FLUSH, RENDER_PARTIAL };
	}
	
	public Displayable getCurrent() {
		return Display.getDisplay((App)this.viewComponent).getCurrent();
	}
	
	public void handleNotification( INotification note )
	{
		if (note.getName().equals(REGISTER_CANVAS)) {
			
			// Entire mediator
			IMediator mediator = (IMediator) note.getBody();
			this.currentMediatorName = mediator.getMediatorName();
			this.current = (GameView) mediator.getViewComponent();
			Display.getDisplay((App)this.viewComponent).setCurrent( this.current );
		
		} else if (note.getName().equals(FLUSH)) {
			
			// Flush graphics
			this.flushMediator( facade.retrieveMediator(this.currentMediatorName) );

			// Render game state indicator if is enabled
			IMediator gameStateIndicator = facade.retrieveMediator(GameStateIndicatorMediator.NAME);
			if (gameStateIndicator != null && ((GameStateIndicatorMediator) gameStateIndicator).isEnabled()) {
				this.flushMediator( gameStateIndicator );
			}
			
			// Render the options if is enabled
			IMediator optionsMenu = facade.retrieveMediator(OptionsMenuMediator.NAME);
			if (((OptionsMenuMediator) optionsMenu).isEnabled()) {
				this.flushMediator( optionsMenu );
			}
			
			// Atualiza a tela...
			this.current.flushGraphics();
			
		} else if (note.getName().equals(RENDER_PARTIAL)) {
			// Partial object
			Graphics g = this.current.getGraphics();
			
			// RenderableItemUI renderable = (RenderableItemUI) note.getBody();
			// g.drawImage((Image) note.getBody(), x, y, anchor)
			Sprite sprite = (Sprite) note.getBody();
			sprite.paint(g);
		}
	}
	
	public IMediator getMediator() {
		return facade.retrieveMediator(this.currentMediatorName);
	}
	
	private void flushMediator(IMediator mediator) {
		mediator.handleNotification(new Notification(FLUSH, null, null));
	}
	
}
