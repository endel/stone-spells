package com.stonespells.models.optionsmenu;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

/**
 * Proxy para manipulação dos dados de um item de menu.
 */
public class OptionsMenuItemProxy extends Proxy implements IProxy {
	public static final String NAME = "OptionsMenuProxy";
	
	/**
	 * Construtor da classe. Chama o construtor da classe pai, que tem como
	 * objetivo a manipulação de dados de um objeto.
	 */
	public OptionsMenuItemProxy() {
		super(NAME, new OptionsMenuItemVO());
	}
	
	/**
	 * Aloca os dados da instância do objeto.
	 */
	public void create() {
		this.data = new OptionsMenuItemVO();
	}
	
	/**
	 * Configura uma imagem do proxy.
	 * @param image A imagem a ser alocada.
	 */
	public void setImage(Image image) {
		((OptionsMenuItemVO) this.data).image = new Sprite(image);
	}
	
	public void setSide(int side) {
		((OptionsMenuItemVO) this.data).side = side;
	}
	
	/**
	 * Configura um nome de notificação.
	 * @param name Nome de notificação a ser alocado.
	 */
	public void setNotificationName(String name) {
		((OptionsMenuItemVO) this.data).notificationName = name;
	}
	
	/**
	 * Configura um rótulo.
	 * @param label Rótulo a ser alocado.
	 */
	public void setLabel(String label) {
		((OptionsMenuItemVO) this.data).label = label;
	}
	
	/**
	 * Obtém um imagem.
	 * @return Imagem de um item do menu.
	 */
	public Sprite getImage() {
		return ((OptionsMenuItemVO) this.data).image;
	}
	
	/**
	 * Retorna notificação de um item do menu.
	 * @return Nome da notificação
	 */
	public String getNotificationName() {
		return ((OptionsMenuItemVO) this.data).notificationName;
	}
	
	public int getSide() {
		return ((OptionsMenuItemVO) this.data).side;
	}
	
	/**
	 * Retorna o rótulo de um item do menu.
	 * @return Rótulo de um item.
	 */
	public String getLabel() {
		return ((OptionsMenuItemVO) this.data).label;
	}
	
	/**
	 * Retorna uma booleana indicando se os dados estão nulos ou não.
	 * @return  Indicação se os rótulos estão nulos ou não.
	 */
	public boolean isValid() {
		return this.data != null;
	}
	
}
