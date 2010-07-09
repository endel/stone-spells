package com.stonespells.views;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;

import com.stonespells.core.IRenderable;
import com.stonespells.core.IWithMenuMediator;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.WindowView;
import com.stonespells.core.WithMenuMediator;
import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que faz a media��o entre as propriedades da tela de instru��es
 * e a visualiza��o dela.
 */
public class InstructionsMediator extends WithMenuMediator implements IMediator, IWithMenuMediator {
	
	public static final String NAME = "InstructionsMediator";
	
	// Notifications
	public static final String CLOSE = "InstructionsClose";
	
	/**
	 * Construtor que configura o componente de visualiz��o a ser tratado
	 * pelo mediador.
	 */
	public InstructionsMediator() {
		super(NAME, null);
		this.setViewComponent(new InstructionsUI(this));
	}
	
	/**
	 * M�todo que trata as a��es a serem executadas no registro deste mediador.
	 * � atribuido um t�tulo a janela, e o conte�do a ser escrito na tela � especificado.
	 */
	public void onRegister() {
		((WindowView) this.viewComponent).setTitle("Regras gerais");
		
		PagedContentProxy pagedContent = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContent.setContent("At the beginning of each turn, you have two points of concentration available to energize your stones. Each one of your stones has a cost to cast. The objective of the game is to defeat your opponent using a combination of your spell effects.", 165);
		
		((PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME)).setViewComponent(pagedContent.getData());
	}
	
	/**
	 * M�todo que retorna uma string com uma lista de notifica��o relevantes a
	 * este mediador.
	 */
	public String[] listNotificationInterests() {
		return new String[] {};
	}
	
	/**
	 * M�todo que lida com uma notifica��o recebida.
	 * � verificado se o componente de visualiza��o deve ser renderizado,
	 * o conte�do especificado na p�gina � alocado, e posicionado na janela.
	 */
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

	/**
	 * M�todo que retorna um proxy para o tratamente do item que
	 * executa o fechamento da tela de instru��es.
	 */
	public OptionsMenuItemProxy getMenuOption(int side) {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.create();
		if (side == OptionsMenuMediator.SIDE_LEFT) {
			item.setImage( ResourceLibrary.OPTION_CLOSE );
			item.setLabel( "Close" );
			item.setNotificationName( CLOSE );
		} else {
			item = null;
		}
		return item;
	}
}
