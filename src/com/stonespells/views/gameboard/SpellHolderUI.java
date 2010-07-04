package com.stonespells.views.gameboard;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import com.stonespells.views.RenderableItemUI;

public class SpellHolderUI extends RenderableItemUI {
	
	public static Sprite holderSprite;
	public static Sprite selectedSprite;
	public static Sprite energyIcon;
	
	static {
		try {
			holderSprite = new Sprite(Image.createImage("/stone-holder.png"));
			selectedSprite = new Sprite(Image.createImage("/stone-holder-selected.png"));
			energyIcon = new Sprite(Image.createImage("/icons/energy-tiny.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int x;
	public int y;
	public int position;
	public boolean selected = false;
	
}
