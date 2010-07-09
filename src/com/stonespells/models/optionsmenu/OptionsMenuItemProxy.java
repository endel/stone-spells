package com.stonespells.models.optionsmenu;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

/**
 * Proxy para manipula��o dos dados de um item de menu.
 */
public class OptionsMenuItemProxy extends Proxy implements IProxy {
	public static final String NAME = "OptionsMenuProxy";
	
	/**
	 * Construtor da classe. Chama o construtor da classe pai, que tem como
	 * objetivo a manipula��o de dados de um objeto.
	 */
	public OptionsMenuItemProxy() {
		super(NAME, new OptionsMenuItemVO());
	}
	
	/**
	 * Aloca os dados da inst�ncia do objeto.
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
	 * Configura um nome de notifica��o.
	 * @param name Nome de notifica��o a ser alocado.
	 */
	public void setNotificationName(String name) {
		((OptionsMenuItemVO) this.data).notificationName = name;
	}
	
	/**
	 * Configura um r�tulo.
	 * @param label R�tulo a ser alocado.
	 */
	public void setLabel(String label) {
		((OptionsMenuItemVO) this.data).label = label;
	}
	
	/**
	 * Obt�m um imagem.
	 * @return Imagem de um item do menu.
	 */
	public Sprite getImage() {
		return ((OptionsMenuItemVO) this.data).image;
	}
	
	/**
	 * Retorna notifica��o de um item do menu.
	 * @return Nome da notifica��o
	 */
	public String getNotificationName() {
		return ((OptionsMenuItemVO) this.data).notificationName;
	}
	
	public int getSide() {
		return ((OptionsMenuItemVO) this.data).side;
	}
	
	/**
	 * Retorna o r�tulo de um item do menu.
	 * @return R�tulo de um item.
	 */
	public String getLabel() {
		return ((OptionsMenuItemVO) this.data).label;
	}
	
	/**
	 * Retorna uma booleana indicando se os dados est�o nulos ou n�o.
	 * @return  Indica��o se os r�tulos est�o nulos ou n�o.
	 */
	public boolean isValid() {
		return this.data != null;
	}
	
}
