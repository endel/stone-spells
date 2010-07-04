package com.stonespells.views.optionsmenu;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.core.App;
import com.stonespells.views.RenderableItemUI;

public class OptionsMenuUI {
	
	//private IMediator mediator;
	public Object options[] = new Object[2];
	public static RenderableItemUI holder = new RenderableItemUI();
	public static RenderableItemUI optionSelected = new RenderableItemUI();
	
	static {
		try {
			holder.image = new Sprite(Image.createImage("/options-background.png"));
			holder.image.setPosition(0, App.HEIGHT - holder.image.getHeight());
			optionSelected.image = new Sprite(Image.createImage("/options-selected-background.png")); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public OptionsMenuUI(IMediator mediator) {
		//this.mediator = mediator;
	}
	
	public void setOption(int side, Object data) {
		this.options[side] = data;
	}

	public Object getOption(int side) {
		return this.options[side];
	}
	
}
