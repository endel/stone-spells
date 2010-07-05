package com.stonespells.views.gameboard;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.patterns.observer.Notification;

import com.stonespells.core.Font;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.WindowView;
import com.stonespells.models.gameboard.SpellListVO;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.RenderMediator;

public class SpellViewerUI extends WindowView {
	
	public Sprite imgList[];
	public int positions[];
	public int currentItem;
	private SpellListVO spellList;
	
	public SpellViewerUI(IMediator mediator) {
		super(false, mediator);
	}
	
	protected void keyPressed(int keyCode) {
		
		int slotSelected = keyCode - 49;
		
		// check if this position exists
		for (int i=0;i<positions.length;i++) {
			if (positions[i] == slotSelected) {
				this.currentItem = i;
				mediator.handleNotification( new Notification(SpellViewerMediator.SPELL_SELECTED, this.spellList.spells[i], null) );
				break;
			}
		}
		
		int gameAction = getGameAction(keyCode);
		if (gameAction == LEFT) {
			sendNotification(PagedContentMediator.PRIOR_PAGE, null, null);
			
		} else if (gameAction == RIGHT) {
			sendNotification(PagedContentMediator.NEXT_PAGE, null, null);
		}
		
		flush();
	}

	public void render() {
		super.render();
		Graphics g = this.getGraphics();
		
		int qty = this.imgList.length;
		
		int imgWidth = imgList[0].getWidth() - 8;
		int imgListCenterX = this.getTotalWidth() / 2 - (imgWidth * qty) / 2;
		
		int textWidth = Font.charW * (qty + 4);
		int textCenterX = this.getTotalWidth() / 2 - textWidth / 2;
		
		int bottomBoxY = this.getTotalHeight() / 2 + this.getBoxHeight() / 2 - 28;

		String numbers = "";
		for (int i=0;i < qty;i++) {
			
			boolean isSelected = (this.currentItem == this.spellList.spells[i].position);
			this.imgList[i].setPosition(imgListCenterX + (i * (imgWidth)), bottomBoxY + (isSelected ? -8 : 0) );
			this.renderPartial( this.imgList[i] );
			
			numbers += String.valueOf(positions[i] + 1);
			if (i < qty-1) {
				numbers += "-";
			}
		}
		
		int costX = (this.getTotalWidth()/2 + this.getBoxWidth()/2) - 30;
		int costY = this.getTotalHeight()/2 - this.getBoxHeight()/2 + 8;
		g.drawImage(ResourceLibrary.ENERGY_ICON, costX, costY, 0);
		RenderMediator.drawString(numbers, textCenterX, bottomBoxY + 8);
		RenderMediator.drawString(String.valueOf(this.spellList.spells[currentItem].cost), costX + 14, costY - 2);
		
	}
	
	public void configureSpells(SpellListVO spellList, Sprite imgList[], int positions[]) {
		this.spellList = spellList;
		this.imgList = imgList;
		this.positions = positions;
	}

	public void setCurrentSpell(SpellProxy spell) {
		this.currentItem = spell.getPosition();
		this.setTitle( spell.getName() );
		
		flush();
	}
	
	
}
