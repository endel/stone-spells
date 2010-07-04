package com.stonespells.views.preconnection;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.bluetooth.ServiceRecord;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.core.GameView;
import com.stonespells.core.IWithMenuMediator;
import com.stonespells.core.ImageLibrary;
import com.stonespells.core.WindowView;
import com.stonespells.core.WithMenuMediator;
import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.connection.ClientProxy;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class PreConnectionMediator extends WithMenuMediator implements IMediator, IWithMenuMediator {
	
	public static final String NAME = "PreConnectionMediator";
	
	// Notifications
	public static final String VIEW_OPTIONS = "PreConnectionOptions";
	public static final String VIEW_CONNECTIONS_LIST = "PreConnectionConnectionsList";
	public static final String VIEW_CREATE = "PreConnectionCreate";
	public static final String CONNECTION_ACCEPTED = "ConnectionAccepted";
	
	public static final String BACK = "PreConnectionBack";
	public static final String CREATE = "PreConnectionCreate";
	public static final String LIST = "PreConnectionList";
	
	private int state;
	
	public PreConnectionMediator() {
		super(NAME, null);
		this.setViewComponent( new PreConnectionUI(this) );
	}
	
	public void onRegister() {
		((WindowView) this.viewComponent).setTitle("Iniciar um novo jogo");
		
		PagedContentProxy pagedContent = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContent.setContent("Pressione qualquer tecla para buscar um jogo para conectar.", 0);
		
		((PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME)).setViewComponent(pagedContent.getData());
	}
	
	public String[] listNotificationInterests( )
	{
		return new String[]{ VIEW_OPTIONS, VIEW_CONNECTIONS_LIST, VIEW_CREATE };
	}
	
	public void handleNotification( INotification note )
	{
		if (note.getName().equals(RenderMediator.FLUSH)) {
			((WindowView) this.viewComponent).render();
							
			PagedContentMediator pagedContent = (PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME);
			pagedContent.setPosition(((WindowView)this.viewComponent).getContentX(), ((WindowView)this.viewComponent).getContentY());
			pagedContent.handleNotification(note);
		
		}
	}
	
	public void setBoxTitle(String title) {
		((WindowView) this.viewComponent).setTitle(title);		
	}

	public OptionsMenuItemProxy getMenuOption(int side) {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.create();
		if (side == OptionsMenuMediator.SIDE_LEFT) {
			item.setImage( ImageLibrary.OPTION_BACK );
			item.setLabel( "Back" );
			item.setNotificationName( BACK );
		} else {
			item.setImage( ((PreConnectionUI) this.viewComponent).CREATE_GAME );
			item.setLabel( "Create" );
			item.setNotificationName( CREATE );
		}
		return item;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	
}