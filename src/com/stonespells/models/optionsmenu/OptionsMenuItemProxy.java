package com.stonespells.models.optionsmenu;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

public class OptionsMenuItemProxy extends Proxy implements IProxy {
	public static final String NAME = "OptionsMenuProxy";
	
	public OptionsMenuItemProxy() {
		super(NAME, new OptionsMenuItemVO());
	}
	
	public void create() {
		this.data = new OptionsMenuItemVO();
	}
	
	public void setImage(Image image) {
		((OptionsMenuItemVO) this.data).image = new Sprite(image);
	}
	
	public void setSide(int side) {
		((OptionsMenuItemVO) this.data).side = side;
	}
	
	public void setNotificationName(String name) {
		((OptionsMenuItemVO) this.data).notificationName = name;
	}
	
	public void setLabel(String label) {
		((OptionsMenuItemVO) this.data).label = label;
	}
	
	public Sprite getImage() {
		return ((OptionsMenuItemVO) this.data).image;
	}
	
	public String getNotificationName() {
		return ((OptionsMenuItemVO) this.data).notificationName;
	}
	
	public int getSide() {
		return ((OptionsMenuItemVO) this.data).side;
	}
	
	public String getLabel() {
		return ((OptionsMenuItemVO) this.data).label;
	}
	
	public boolean isValid() {
		return this.data != null;
	}
	
}
