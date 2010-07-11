package com.stonespells.core;

import java.io.IOException;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.facade.GameFacade;
import com.stonespells.views.RenderMediator;

/**
 * Trata de aspectos da visualização do jogo.
 */
public class GameView extends GameCanvas implements IGameView {
	
	private boolean initiated = false;
	
	protected static Image background = null;
	protected IMediator mediator;
	
	/**
	 * Construtor da classe
	 * @param supressKeyEvents Indica que input de teclas não serão tratados aqui.
	 * @param mediator O mediador a ser utilizado.
	 */
	public GameView(boolean supressKeyEvents, IMediator mediator) {
		super(supressKeyEvents);
		this.mediator = mediator;
		this.init();
	}
	
	public void initializeView() throws Exception {}
	
	public boolean isInit() {
		return initiated;		
	}
	
	/**
	 * Cria imagem de fundo e inicializ aa visualização do jogo.
	 */
	public void init() {
		if (background == null) {
			try {
				background = Image.createImage("/background.png");
			} catch(IOException e) {
				Logger.instance.println(e);
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
	 * Obtém tamanho total da largura da visualização
	 * @return int
	 */
	public int getTotalWidth() {
		return background.getWidth();
	}
	
	/**
	 * Obtém tamanho total da altura da visualização
	 * @return int
	 */
	public int getTotalHeight() {
		return background.getHeight();
	}
	
	/**
	 * Obtém o contexto gráfico.
	 */
	public Graphics getGraphics() {
		return super.getGraphics();
	}
	
	/**
	 * Delega flush ao RenderMediator.
	 */
	protected void flush() {
		GameFacade.getInstance().sendNotification(RenderMediator.FLUSH, this.mediator, null);
		flushGraphics();
	}
	
	/**
	 * Envia notificação do sprite a ser renderizado.
	 * @param toRender Sprite a ser renderizado.
	 */
	protected void renderPartial(Sprite toRender) {
		GameFacade.getInstance().sendNotification(RenderMediator.RENDER_PARTIAL, toRender, null);
	}
	
	/**
	 * Envia notificação para GameFacade.
	 * @param notificationName
	 * @param body
	 * @param type
	 */
	protected void sendNotification(String notificationName, Object body, String type) {
		GameFacade.getInstance().sendNotification(notificationName, body, type);
	}
	
	public void flushGraphics() {
		super.flushGraphics();
	}
	
	/**
	 * Renderiza background no Canvas
	 */
	public void render() {
		Graphics g = getGraphics();
		g.drawImage(background, 0, 0, 0);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
