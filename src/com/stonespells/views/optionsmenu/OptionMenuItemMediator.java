package com.stonespells.views.optionsmenu;

import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.RenderMediator;

public class OptionMenuItemMediator extends Mediator implements IMediator {
	
	public static final String NAME = "OptionMenuItemMediator";
	
	public OptionMenuItemMediator() {
		super(NAME, null);
	}
	
	public void setData(Object data) {
		this.setViewComponent(data);
	}
	
	public OptionsMenuItemProxy getData() {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.setData( this.getViewComponent() );
		return item;
	}
	
	public void changeImage(Image img) {
		getData().setImage( img );
	}
	
	public void clear() {
		this.getData().setImage( null );
	}
	
	public boolean isValid() {
		return this.getData().isValid() && this.getData().getImage() != null;
	}
	
	public String[] listNotificationInterests( )
	{
		return new String[] {  };
	}
	
	public void setPosition(int x, int y) {
		getData().getImage().setPosition(x, y);
	}
	
	public void handleNotification( INotification note )
	{
		if ( note.getName().equals(RenderMediator.FLUSH) ) {
			// Render menu item
			sendNotification(RenderMediator.RENDER_PARTIAL, getData().getImage(), null);
			
		}
	}
}
