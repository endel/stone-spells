package com.stonespells.views.preconnection;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;

import com.stonespells.core.IWithMenuMediator;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.WindowView;
import com.stonespells.core.WithMenuMediator;
import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que faz a media��o entre os dados e os componentes de visualiza��o referentes
 * a op��o do jogador condizentes com os elementos de conex�o anteriores ao jogo.
 */
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
	/**
	 * Construtor da classe. Instancia a classe que faz o tratamento dos elementos
	 * de visualiza��o das op��es do jogador referentes � conex�o.
	 */
	public PreConnectionMediator() {
		super(NAME, null);
		this.setViewComponent( new PreConnectionUI(this) );
	}
	
	/**
	 * M�todo que trata o conte�do da mensagem a ser exibida ao jogador escolher o inc�cio
	 * de um novo jogo.
	 */
	public void onRegister() {
		((WindowView) this.viewComponent).setTitle("Iniciar um novo jogo");
		
		PagedContentProxy pagedContent = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContent.setContent("Pressione qualquer teclapara buscar um jogo paraconectar.", 0);
		
		((PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME)).setViewComponent(pagedContent.getData());
	}
	
	/**
	 * M�todo que retorna um array de strings que representa as notifica��es
	 * relevantes a esta classe.
	 */
	public String[] listNotificationInterests( )
	{
		return new String[]{ VIEW_OPTIONS, VIEW_CONNECTIONS_LIST, VIEW_CREATE };
	}
	
	/**
	 * M�todo que trata as notifica��es recebidas pela classe.
	 */
	public void handleNotification( INotification note )
	{
		if (note.getName().equals(RenderMediator.FLUSH)) {
			((WindowView) this.viewComponent).render();
							
			PagedContentMediator pagedContent = (PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME);
			pagedContent.setPosition(((WindowView)this.viewComponent).getContentX(), ((WindowView)this.viewComponent).getContentY());
			pagedContent.handleNotification(note);
		
		}
	}
	
	/**
	 * M�todo que configura a vari�vel title do componente de visualiza��o
	 * utilizado.
	 */
	public void setBoxTitle(String title) {
		((WindowView) this.viewComponent).setTitle(title);		
	}

	/**
	 * M�todo que obt�m o item especificado do menu.
	 */
	public OptionsMenuItemProxy getMenuOption(int side) {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.create();
		if (side == OptionsMenuMediator.SIDE_LEFT) {
			item.setImage( ResourceLibrary.OPTION_BACK );
			item.setLabel( "Back" );
			item.setNotificationName( BACK );
		} else {
			item.setImage( ((PreConnectionUI) this.viewComponent).CREATE_GAME );
			item.setLabel( "Create" );
			item.setNotificationName( CREATE );
		}
		return item;
	}
	
	/**
	 * M�todo que obt�m a vari�vel state da classe.
	 * @return
	 */
	public int getState() {
		return this.state;
	}
	
	/**
	 * M�todo que configura a vari�vel state da classe.
	 */
	public void setState(int state) {
		this.state = state;
	}
	
	
}