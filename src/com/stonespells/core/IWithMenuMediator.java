package com.stonespells.core;

import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;

/**
 * Um Mediator que necessite de comandos de menu deve implementar esta interface.
 */
public interface IWithMenuMediator {
	
	OptionsMenuItemProxy getMenuOption(int side);
	void setMenuInitiated(boolean init);
	boolean getMenuInitiated();
}
