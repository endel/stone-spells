package com.stonespells.core;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;

public abstract class WithMenuMediator extends Mediator implements IMediator, IWithMenuMediator {

	protected boolean init;
	
	public WithMenuMediator(String mediatorName, Object viewComponent) {
		super(mediatorName, viewComponent);
		init = false;
	}

	public abstract OptionsMenuItemProxy getMenuOption(int side);

	public boolean getMenuInitiated() {
		return this.init;
	}

	public void setMenuInitiated(boolean init) {
		this.init = init;
	}
	
	

}
