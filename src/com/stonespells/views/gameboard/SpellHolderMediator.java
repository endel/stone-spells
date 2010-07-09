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
 * Classe que faz a mediação entre os dados e os componentes de visualização
 * de um slot de feitiço.
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
	 * Método que obtém o tamanho da imagem do slot.
	 * @return O tamanho do slot.
	 */
	public int getSize() {
		return SpellHolderUI.holderSprite.getWidth();
	}
	
	/**
	 * Método que obtém a posição x do slot.
	 * @return A posição x do slot.
	 */
	public int getX() {
		return ((SpellHolderUI) this.viewComponent).x;
	}
	
	/**
	 * Método que obtém a posição y do slot.
	 * @return A posição y do slot.
	 */
	public int getY() {
		return ((SpellHolderUI) this.viewComponent).y;
	}
	
	
	/**
	 * Método para configuração da posição do slot de feitiço.
	 * @param x Posição desejada x do slot de feitiço.
	 * @param y Posição desejada y do slot de feitiço.
	 */
	public void setPosition(int x, int y) {
		((SpellHolderUI) this.viewComponent).x = x;
		((SpellHolderUI) this.viewComponent).y = y;
		((SpellHolderUI) this.viewComponent).image.setPosition(x, y);
	}
	
	/**
	 * Método que obtém a posição do slot de feitiço.
	 * @return A posição do slot.
	 */
	public int getPosition() {
		return ((SpellHolderUI) this.viewComponent).position;
	}
		
	/**
	 * Método que indica se um slot está selecionado.
	 * @return Booleana que indica se o slot está selecionado.
	 */
	public boolean isSelected() {
		SpellProxy spell = this.getSpell();
		return spell.isSelected();
	}
	
	/**
	 * Método que muda o slot selecionado.
	 */
	public void swapSelect() {
		SpellProxy spell = this.getSpell();
		spell.swapSelected();
	}
	
	/**
	 * Método que retorna um array de strings que representam notificações
	 * de interesse deta classe.
	 */
	public String[] listNotificationInterests( )
	{
		return new String[] {};
	}
	
	/**
	 * Método que trata notificações referentes ao slot de feitiços.
	 * Pinta os feitiços dentro dos slots, indica a concetração necessária para que
	 * o feitiço seja lançado, e a concentração atual que cada feitiço possui.
	 * Também indica se um feitiço está travado, ou se ele já pode
	 * ser lançado.
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
	 * Método que aloca dados de um componente de um SpellProxy em um componente
	 * a ser renderizado.
	 * @param spell A instância de SpellProxy a ser salva.
	 */
	public void setSpell(SpellProxy spell) {
		((RenderableItemUI) this.viewComponent).data = spell.getData();
	}
	
	/**
	 * Configura um SpellProxy e o retorna.
	 * @return A instância de SpellProxy já configurada.
	 */
	public SpellProxy getSpell() {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		spell.setData( ((RenderableItemUI) this.viewComponent).data );
		return spell;
	}
	
	
}
