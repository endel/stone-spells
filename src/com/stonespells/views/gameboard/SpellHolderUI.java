package com.stonespells.views.gameboard;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import com.stonespells.views.RenderableItemUI;

/**
 * Classe contêiner que faz o carregamento e armazena as imagens do slot
 * de feitiços: o fundo de um slot selecionado, o slot, e o indicador de
 * um slot energizado.
 */
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
