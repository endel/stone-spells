package com.stonespells.models.gameboard;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

public class PlayerProxy extends Proxy implements IProxy {
	
	public static final String NAME = "PlayerProxy";
	
	public static final int MAX_LIFE = 30;
	
	public PlayerProxy() {
		super(NAME, null);
	}

	public void create() {
		PlayerVO player = new PlayerVO();
		this.setData(player);
	}
	
	public void setName(String name) {
		((PlayerVO) this.data).name = name;
	}
	
	public void setLife(int life) {
		((PlayerVO) this.data).life = life;
	}
	
	public void setActive(boolean active) {
		((PlayerVO) this.data).active = active;
	}
	
	public void addLife(int i) {
		((PlayerVO) this.data).life = ((PlayerVO) this.data).life + i;
	}
	
	public String getName() {
		return ((PlayerVO) this.data).name;
	}
	
	public int getLife() {
		return ((PlayerVO) this.data).life;
	}
	
	public int getConcentration() {
		return ((PlayerVO) this.data).concentration;
	}
	
	public boolean getActive() {
		return ((PlayerVO) this.data).active;
	}
	
	public void addConcentration(int number) {
		((PlayerVO) this.data).concentration += number;
	}
	
	public void swapActive() {
		this.setActive( !this.getActive() );
	}
	
	public void setSpellList(SpellListProxy spellList) {
		((PlayerVO) this.data).spellList = (SpellListVO) spellList.getData();
	}
	
	public SpellListProxy getSpellList() {
		SpellListProxy spellList = (SpellListProxy) facade.retrieveProxy(SpellListProxy.NAME);
		spellList.setData(((PlayerVO) this.data).spellList);
		return spellList;
		
	}
	
}
