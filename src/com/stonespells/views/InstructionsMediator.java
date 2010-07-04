package com.stonespells.views;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;

import com.stonespells.core.IRenderable;
import com.stonespells.core.IWithMenuMediator;
import com.stonespells.core.ImageLibrary;
import com.stonespells.core.WindowView;
import com.stonespells.core.WithMenuMediator;
import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

public class InstructionsMediator extends WithMenuMediator implements IMediator, IWithMenuMediator {
	
	public static final String NAME = "InstructionsMediator";
	
	// Notifications
	public static final String CLOSE = "InstructionsClose";
	
	public InstructionsMediator() {
		super(NAME, null);
		this.setViewComponent(new InstructionsUI(this));
	}
	
	public void onRegister() {
		((WindowView) this.viewComponent).setTitle("Regras gerais");
		
		PagedContentProxy pagedContent = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContent.setContent("Esse joguinho eh muito complicado e voce nao vai querer joga-lo ate o final pelo motivo que exige muito do seu cerebro incapaz de compreender essas regras e esse texto. Agora repita comigo: eu sou um baita bundao e nao gosto de comer batatas. Eu sou um bundao e nao gosto de comer batatas. Tchau.", 190);
		
		((PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME)).setViewComponent(pagedContent.getData());
	}
	
	public String[] listNotificationInterests() {
		return new String[] {};
	}
	
	public void handleNotification( INotification note )
	{
		if (note.getName().equals(RenderMediator.FLUSH)) {
			((IRenderable) this.viewComponent).render();
			
			// Render Paged Content
			PagedContentMediator pagedContent = (PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME);
			pagedContent.setPosition(((WindowView) this.viewComponent).getContentX(), ((WindowView) this.viewComponent).getContentY() );
			pagedContent.handleNotification(note);
			
		}
	}

	public OptionsMenuItemProxy getMenuOption(int side) {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.create();
		if (side == OptionsMenuMediator.SIDE_LEFT) {
			item.setImage( ImageLibrary.OPTION_CLOSE );
			item.setLabel( "Close" );
			item.setNotificationName( CLOSE );
		} else {
			item = null;
		}
		return item;
	}
}
