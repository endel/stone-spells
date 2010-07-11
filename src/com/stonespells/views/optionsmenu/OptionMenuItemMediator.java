package com.stonespells.views.optionsmenu;

import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.RenderMediator;

/**
 * Classe que efetua a media��o entre os dados de um item do menu de op��es e
 * seus componentes de visualiza��o.
 */
public class OptionMenuItemMediator extends Mediator implements IMediator {
	
	public static final String NAME = "OptionMenuItemMediator";
	
	/**
	 * Construtor da classe.
	 */
	public OptionMenuItemMediator() {
		super(NAME, null);
	}
	
	/**
	 * M�todo que configura os dados do componente de visualiza��o de acordo com o argumento recebido.
	 */
	public void setData(Object data) {
		this.setViewComponent(data);
	}
	
	/**
	 * M�todo que obtem dados de uma inst�ncia da classe que possui o tratamento
	 * dos dados de um item do menu.
	 */
	public OptionsMenuItemProxy getData() {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.setData( this.getViewComponent() );
		return item;
	}
	
	/**
	 * M�todo que troca a imagem que representa graficamente um item do menu.
	 * @param img A nova imagem.
	 */
	public void changeImage(Image img) {
		getData().setImage( img );
	}
	
	/**
	 * M�todo que limpa a imagem que representa graficamente um item do menu.
	 */
	public void clear() {
		this.getData().setImage( null );
	}
	
	/**
	 * M�todo que verifica se os dados e a imagem da isnt�ncia da classe
	 * s�o nulos ou v�lidos.
	 */
	public boolean isValid() {
		return this.getData().isValid() && this.getData().getImage() != null;
	}
	
	/**
	 * M�todo que retorna uma lista de strings que representam as notifica��es
	 * relevantes a esta classe.
	 */
	public String[] listNotificationInterests( )
	{
		return new String[] {  };
	}
	
	/**
	 * M�todo que determina a posi��o de um item do menu na tela.
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y) {
		getData().getImage().setPosition(x, y);
	}
	
	/**
	 * M�todo que lida com notifica��o recebidas pela inst�ncia da classe.
	 * Renderiza intens do menu.
	 */
	public void handleNotification( INotification note )
	{
		if ( note.getName().equals(RenderMediator.FLUSH) ) {
			// Render menu item
			sendNotification(RenderMediator.RENDER_PARTIAL, getData().getImage(), null);
			
		}
	}
}
