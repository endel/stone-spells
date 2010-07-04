package com.stonespells.core;

import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;

public interface IWithMenuMediator {
	OptionsMenuItemProxy getMenuOption(int side);
	void setMenuInitiated(boolean init);
	boolean getMenuInitiated();
}
