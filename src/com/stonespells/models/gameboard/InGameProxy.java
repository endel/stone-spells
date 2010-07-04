package com.stonespells.models.gameboard;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

public class InGameProxy extends Proxy implements IProxy {
	
	public static final String NAME = "InGameProxy";
	
	public InGameProxy() {
		super(NAME, new InGameVO());
	}

}
