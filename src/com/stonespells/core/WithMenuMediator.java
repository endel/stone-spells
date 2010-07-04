package com.stonespells.core;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;

/**
 * Um Mediator que necessite de comandos de menu deve estender esta classe.
 * @author Endel
 */
public abstract class WithMenuMediator extends Mediator implements IMediator, IWithMenuMediator {

	protected boolean init;
	
	public WithMenuMediator(String mediatorName, Object viewComponent) {
		super(mediatorName, viewComponent);
		init = false;
	}
	
	/**
	 * Voc� necessita criar um {@link OptionsMenuItemProxy} de acordo com 
	 * o lado enviado como argumento.
	 * 
	 * Caso n�o necessite de um item em algum dos lados, dever� ser retornado null.
	 * 
	 * @param side
	 * @return OptionsMenuItemProxy
	 */
	public abstract OptionsMenuItemProxy getMenuOption(int side);

	/**
	 * Verifica se os itens de menu j� foram inicializados.
	 * @return boolean
	 */
	public boolean getMenuInitiated() {
		return this.init;
	}

	/**
	 * Notifica se os itens de menu foram inicializados.
	 * @return void
	 */
	public void setMenuInitiated(boolean init) {
		this.init = init;
	}
	
}