package com.stonespells.views;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.core.Font;
import com.stonespells.models.PagedContentProxy;

public class PagedContentMediator extends Mediator implements IMediator {
	public static final String NAME = "PagedContentMediator";
	
	// Notifications
	public static final String NEXT_PAGE = "PagedContentNextPage";
	public static final String PRIOR_PAGE = "PagedContentPriorPage";
	
	private int x;
	private int y;
	
	private static final int CHARS_PER_LINE = 24;
	public Sprite paginationIcon;
	
	public PagedContentMediator() {
		super(NAME, null);
		
		try {
			this.paginationIcon = new Sprite(Image.createImage("/icons/nav-next.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String[] listNotificationInterests() {
		return new String[] { NEXT_PAGE, PRIOR_PAGE };
	}
	
	public void handleNotification( INotification note )
	{
		PagedContentProxy pagedContent = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContent.setData(this.getViewComponent());
		
		if (note.getName().equals(RenderMediator.FLUSH)) {
			
			String lines[] = pagedContent.getLines(pagedContent.getContent(), CHARS_PER_LINE);
			for (int i=0;i<lines.length;i++) {
				RenderMediator.drawString(lines[i], this.x, this.y + (i * Font.charH + 3));
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
