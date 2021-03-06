package com.stonespells.models.gameboard;

import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.ICommand;

/**
 * Classe cont�iner com os dados relativos a um feiti�o.
 */
public class SpellVO {
	
	public int id;
	public String name;
	public String description;
	public int color;
	public Image image;
	public int position;
	public int cost;
	public int concentration = 0;
	public boolean locked = false;
	public boolean casting = false;
	public boolean selected = false;
	
	public ICommand commandListener;
	
}
