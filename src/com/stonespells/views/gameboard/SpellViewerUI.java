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

/**
 * Classe que possui e efetua a pintura de elementos de visualiza��o da descri��o
 * dos feiti�os.
 */
public class SpellViewerUI extends WindowView {
	
	public Sprite imgList[];
	public int positions[];
	public int currentItem;
	private SpellListVO spellList;
	
	/**
	 * Construtor da classe que recebe um mediador que far� a comunica��o entre
	 * esta classe que � respons�vle pela pintura da descri��o dos feiti�os, 
	 * e os dados referentes �s descri��es.
	 * @param mediator
	 */
	public SpellViewerUI(IMediator mediator) {
		super(false, mediator);
	}
	/**
	 * M�todo que efetua o tratamento de teclas para navega��o entre as p�ginas
	 * contendo as descri��es dos feiti�os.
	 */
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

	/**
	 * M�todo que efetua a pintura propriamente dita do conte�do paginado � tela. 
	 */
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
	
	/**
	 * M�todo que configura as vari�veis da classe de acordo com os argumentos
	 * recebidos.
	 */
	public void configureSpells(SpellListVO spellList, Sprite imgList[], int positions[]) {
		this.spellList = spellList;
		this.imgList = imgList;
		this.positions = positions;
		this.currentItem = 0;
	}

	/**
	 * M�todo que determina o feiti�o atual na navega��o, e efetua a pintura na tela.
	 * @param spell
	 */
	public void setCurrentSpell(SpellProxy spell) {
		for (int i=0;i<positions.length;i++) {
			if (this.positions[i] == spell.getPosition()) {
				this.currentItem = i;
			}
		}
		
		this.setTitle( spell.getName() );
		flush();
	}
	
	
}
