package com.stonespells.views;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.core.Font;
import com.stonespells.models.PagedContentProxy;

/**
 *  Classe que faz a mediação entre os dados e a visualização do conteúdo a ser
 *  paginado à tela.
 */
public class PagedContentMediator extends Mediator implements IMediator {
	public static final String NAME = "PagedContentMediator";
	
	// Notifications
	public static final String NEXT_PAGE = "PagedContentNextPage";
	public static final String PRIOR_PAGE = "PagedContentPriorPage";
	
	private int x;
	private int y;
	
	private static final int CHARS_PER_LINE = 24;
	public Sprite paginationIcon;
	
	/**
	 * Construtor que cria o mediador e carrega uma imagem para a navegação na
	 * visualização do conteúdo paginado na tela.
	 */
	public PagedContentMediator() {
		super(NAME, null);
		
		try {
			this.paginationIcon = new Sprite(Image.createImage("/icons/nav-next.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que especifica a posição do conteúdo a ser exibido na tela.
	 * @param x Especifica a posição x do conteúdo.
	 * @param y Especifica a posição y do conteúdo.
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Método que retorna uma string com uma lista de notificação relevantes a
	 * este mediador.
	 */
	public String[] listNotificationInterests() {
		return new String[] { NEXT_PAGE, PRIOR_PAGE };
	}
	
	/**
	 * Método da classe mediadora que lida com notificações recebidas.
	 * Se a notificação determinar que o conteúdo de uma página seja pintado na tela,
	 * o conteúdo é pintado conforme o número de caracteres por linha determinado e é verificado
	 * o índice da página e a forma em que o botão de navegação deve apresentar-se, conforme
	 * o índice da página.
	 * A notificação também pode determinar que se avance ou retroceda a página mostrada na tela.
	 */
	public void handleNotification( INotification note )
	{
		PagedContentProxy pagedContent = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContent.setData(this.getViewComponent());
		
		if (note.getName().equals(RenderMediator.FLUSH)) {
			
			String lines[] = pagedContent.getLines(pagedContent.getContent(), CHARS_PER_LINE);
			for (int i=0;i<lines.length;i++) {
				RenderMediator.drawString(lines[i], this.x, this.y + (i * Font.charH + 2));
			}
			
			// Render pagination icon
			if (pagedContent.getNumberOfPages() > 0) {
				this.paginationIcon.setTransform( Sprite.TRANS_NONE );
				if (pagedContent.isLastPage()) {
					this.paginationIcon.setTransform( Sprite.TRANS_MIRROR );
				}
				int paginationX = this.x + (CHARS_PER_LINE * (Font.charW - 2)) - this.paginationIcon.getWidth();
				int paginationY = this.y + (lines.length * (Font.charH))  - this.paginationIcon.getHeight() + 3;
				this.paginationIcon.setPosition(paginationX, paginationY);
				
				sendNotification(RenderMediator.RENDER_PARTIAL, this.paginationIcon, null);
			}				
			
		} else if (note.getName().equals(NEXT_PAGE)) {
			
			if (!pagedContent.isLastPage()) {
				pagedContent.setCurrentPage( pagedContent.getCurrentPage() + 1 );
			}
			
		} else if (note.getName().equals(PRIOR_PAGE)) {
			
			if (pagedContent.getCurrentPage() > 0) {
				pagedContent.setCurrentPage( pagedContent.getCurrentPage() - 1 );
			}
			
		}
	}
}
