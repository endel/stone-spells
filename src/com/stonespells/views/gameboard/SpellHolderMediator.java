package com.stonespells.views.gameboard;

import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.mediator.Mediator;

import com.stonespells.core.ResourceLibrary;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.RenderableItemUI;

/**
 * Classe que faz a media��o entre os dados e os componentes de visualiza��o
 * de um slot de feiti�o.
 */
public class SpellHolderMediator extends Mediator implements IMediator {
	
	public static final String NAME = "SpellHolderMediator";
	
	/**
	 * Construtor da classe.
	 */
	public SpellHolderMediator() {
		super(NAME, null);
	}
	
	/**
	 * M�todo que obt�m o tamanho da imagem do slot.
	 * @return O tamanho do slot.
	 */
	public int getSize() {
		return SpellHolderUI.holderSprite.getWidth();
	}
	
	/**
	 * M�todo que obt�m a posi��o x do slot.
	 * @return A posi��o x do slot.
	 */
	public int getX() {
		return ((SpellHolderUI) this.viewComponent).x;
	}
	
	/**
	 * M�todo que obt�m a posi��o y do slot.
	 * @return A posi��o y do slot.
	 */
	public int getY() {
		return ((SpellHolderUI) this.viewComponent).y;
	}
	
	
	/**
	 * M�todo para configura��o da posi��o do slot de feiti�o.
	 * @param x Posi��o desejada x do slot de feiti�o.
	 * @param y Posi��o desejada y do slot de feiti�o.
	 */
	public void setPosition(int x, int y) {
		((SpellHolderUI) this.viewComponent).x = x;
		((SpellHolderUI) this.viewComponent).y = y;
		((SpellHolderUI) this.viewComponent).image.setPosition(x, y);
	}
	
	/**
	 * M�todo que obt�m a posi��o do slot de feiti�o.
	 * @return A posi��o do slot.
	 */
	public int getPosition() {
		return ((SpellHolderUI) this.viewComponent).position;
	}
		
	/**
	 * M�todo que indica se um slot est� selecionado.
	 * @return Booleana que indica se o slot est� selecionado.
	 */
	public boolean isSelected() {
		SpellProxy spell = this.getSpell();
		return spell.isSelected();
	}
	
	/**
	 * M�todo que muda o slot selecionado.
	 */
	public void swapSelect() {
		SpellProxy spell = this.getSpell();
		spell.swapSelected();
	}
	
	/**
	 * M�todo que retorna um array de strings que representam notifica��es
	 * de interesse deta classe.
	 */
	public String[] listNotificationInterests( )
	{
		return new String[] {};
	}
	
	/**
	 * M�todo que trata notifica��es referentes ao slot de feiti�os.
	 * Pinta os feiti�os dentro dos slots, indica a concetra��o necess�ria para que
	 * o feiti�o seja lan�ado, e a concentra��o atual que cada feiti�o possui.
	 * Tamb�m indica se um feiti�o est� travado, ou se ele j� pode
	 * ser lan�ado.
	 */
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
				lockedIcon.image = new Sprite(ResourceLibrary.SPELL_LOCKED_ICON);
				lockedIcon.image.setPosition(this.getX() + 28, this.getY() + 5);
				sendNotification(RenderMediator.RENDER_PARTIAL, lockedIcon.image, null);
				
			} else if (spell.canCast()) {
				RenderableItemUI canCastIcon = new RenderableItemUI();
				canCastIcon.image = new Sprite(ResourceLibrary.SPELL_CAN_CAST_ICON);
				canCastIcon.image.setPosition(this.getX() + 28, this.getY() + 5);
				sendNotification(RenderMediator.RENDER_PARTIAL, canCastIcon.image, null);
				
			}
			
			sendNotification(RenderMediator.RENDER_PARTIAL, spellIcon.image, null);
			sendNotification(RenderMediator.RENDER_PARTIAL, SpellHolderUI.energyIcon, null);
		}
	}

	/**
	 * M�todo que aloca dados de um componente de um SpellProxy em um componente
	 * a ser renderizado.
	 * @param spell A inst�ncia de SpellProxy a ser salva.
	 */
	public void setSpell(SpellProxy spell) {
		((RenderableItemUI) this.viewComponent).data = spell.getData();
	}
	
	/**
	 * Configura um SpellProxy e o retorna.
	 * @return A inst�ncia de SpellProxy j� configurada.
	 */
	public SpellProxy getSpell() {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		spell.setData( ((RenderableItemUI) this.viewComponent).data );
		return spell;
	}
	
	
}
