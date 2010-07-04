package com.stonespells.views.game.board;

import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.core.ImageLibrary;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.gameboard.SpellVO;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.RenderableItemUI;

public class SpellHolderMediator extends Mediator implements IMediator {
	
	public static final String NAME = "SpellHolderMediator";
	
	public SpellHolderMediator() {
		super(NAME, null);
	}
	
	public int getSize() {
		return SpellHolderUI.holderSprite.getWidth();
	}
	
	public int getX() {
		return ((SpellHolderUI) this.viewComponent).x;
	}
	
	public int getY() {
		return ((SpellHolderUI) this.viewComponent).y;
	}
	
	public void setPosition(int x, int y) {
		((SpellHolderUI) this.viewComponent).x = x;
		((SpellHolderUI) this.viewComponent).y = y;
		((SpellHolderUI) this.viewComponent).image.setPosition(x, y);
	}
	
	public int getPosition() {
		return ((SpellHolderUI) this.viewComponent).position;
	}
	
	public boolean isSelected() {
		SpellProxy spell = this.getSpell();
		return spell.isSelected();
	}
	
	public void swapSelect() {
		SpellProxy spell = this.getSpell();
		spell.swapSelected();
	}
	
	public String[] listNotificationInterests( )
	{
		return new String[] {};
	}
	
	public void handleNotification( INotification note )
	{
		if ( note.getName().equals(RenderMediator.FLUSH) ) {
			// Render spell background
			((RenderableItemUI) this.viewComponent).image = (this.isSelected()) ? SpellHolderUI.selectedSprite : SpellHolderUI.holderSprite;
			((RenderableItemUI) this.viewComponent).image.setPosition( this.getX(), this.getY() );
			sendNotification(RenderMediator.RENDER_PARTIAL, ((RenderableItemUI) this.viewComponent).image, null);
			
			SpellProxy spell = this.getSpell();
			
			RenderableItemUI spellIcon = new RenderableItemUI();
			spellIcon.image = new Sprite( spell.getImage() );
			spellIcon.image.setPosition(this.getX() + 15, this.getY() + 15);
			
			SpellHolderUI.energyIcon.setPosition(this.getX() + 4, this.getY() + 17);
			RenderMediator.drawString( String.valueOf(spell.getConcentration()), this.getX() + 4, this.getY() + 4);
			RenderMediator.drawString( String.valueOf(spell.getCost()), this.getX() + 4, this.getY() + 25);
			
			// Icons on holder
			if (spell.isLocked()) {
				RenderableItemUI lockedIcon = new RenderableItemUI();
				lockedIcon.image = new Sprite(ImageLibrary.SPELL_LOCKED_ICON);
				lockedIcon.image.setPosition(this.getX() + 28, this.getY() + 5);
				sendNotification(RenderMediator.RENDER_PARTIAL, lockedIcon.image, null);
				
			} else if (spell.canCast()) {
				RenderableItemUI canCastIcon = new RenderableItemUI();
				canCastIcon.image = new Sprite(ImageLibrary.SPELL_CAN_CAST_ICON);
				canCastIcon.image.setPosition(this.getX() + 28, this.getY() + 5);
				sendNotification(RenderMediator.RENDER_PARTIAL, canCastIcon.image, null);
				
			}
			
			sendNotification(RenderMediator.RENDER_PARTIAL, spellIcon.image, null);
			sendNotification(RenderMediator.RENDER_PARTIAL, SpellHolderUI.energyIcon, null);
		}
	}

	public void setSpell(SpellProxy spell) {
		((RenderableItemUI) this.viewComponent).data = spell.getData();
	}
	
	public SpellProxy getSpell() {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		spell.setData( ((RenderableItemUI) this.viewComponent).data );
		return spell;
	}
	
	
}
