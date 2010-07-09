package com.stonespells.views.optionsmenu;

import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.RenderMediator;

/**
 * Classe que efetua a mediação entre os dados de um item do menu de opções e
 * seus componentes de visualização.
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
	 * Método que configura os dados do componente de visualização de acordo com o argumento recebido.
	 */
	public void setData(Object data) {
		this.setViewComponent(data);
	}
	
	/**
	 * Método que obtem dados de uma instância da classe que possui o tratamento
	 * dos dados de um item do menu.
	 */
	public OptionsMenuItemProxy getData() {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.setData( this.getViewComponent() );
		return item;
	}
	
	/**
	 * Método que troca a imagem que representa graficamente um item do menu.
	 * @param img A nova imagem.
	 */
	public void changeImage(Image img) {
		getData().setImage( img );
	}
	
	/**
	 * Método que limpa a imagem que representa graficamente um item do menu.
	 */
	public void clear() {
		this.getData().setImage( null );
	}
	
	/**
	 * Método que verifica se os dados e a imagem da isntância da classe
	 * são nulos ou válidos.
	 */
	public boolean isValid() {
		return this.getData().isValid() && this.getData().getImage() != null;
	}
	
	/**
	 * Método que retorna uma lista de strings que representam as notificações
	 * relevantes a esta classe.
	 */
	public String[] listNotificationInterests( )
	{
		return new String[] {  };
	}
	
	/**
	 * Método que determina a posição de um item do menu na tela.
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y) {
		getData().getImage().setPosition(x, y);
	}
	
	/**
	 * Método que lida com notificação recebidas pela instância da classe.
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
