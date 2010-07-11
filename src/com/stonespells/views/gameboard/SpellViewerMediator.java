package com.stonespells.views.gameboard;

import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;
import org.puremvc.java.interfaces.INotification;

import com.stonespells.core.IRenderable;
import com.stonespells.core.IWithMenuMediator;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.WindowView;
import com.stonespells.core.WithMenuMediator;
import com.stonespells.models.PagedContentProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellListVO;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.optionsmenu.OptionsMenuItemProxy;
import com.stonespells.views.PagedContentMediator;
import com.stonespells.views.RenderMediator;
import com.stonespells.views.optionsmenu.OptionsMenuMediator;

/**
 * Classe que efetua a comunica��o de dados e elementos de
 * visualiza��o das descri��es dos feiti�os.
 *
 */
public class SpellViewerMediator extends WithMenuMediator implements IMediator, IWithMenuMediator {
	
	public static final String NAME = "SpellViewerMediator";
	
	// Notifications
	public static final String CLOSE = "SpellViewerClose";
	public static final String SPELL_SELECTED = "SpellViewerSpellSelected";
	
	/**
	 * Construtor que inst�ncia a classe que cont�m os elementos de renderiza��o
	 * da descri��o de um feiti�o.
	 */
	public SpellViewerMediator() {
		super(NAME, null);
		this.setViewComponent(new SpellViewerUI(this));
	}
	
	/**
	 * M�todo que retorna umalista de strings com notifica��es relevantes a esta
	 * classe.
	 */
	public String[] listNotificationInterests() {
		return new String[] {};
	}
	
	/**
	 * M�todo que lida com as notifica��es recebidas pela inst�ncia da classe.
	 * Renderiza o conte�do paginado da descri��o de um feiti�o, ou especifica o
	 * feiti�o atual.
	 */
	public void handleNotification( INotification note ) {
		
		if (note.getName().equals(RenderMediator.FLUSH)) {
			((IRenderable) this.viewComponent).render();
			
			// Render Paged Content
			PagedContentMediator pagedContent = (PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME);
			pagedContent.setPosition(((WindowView) this.viewComponent).getContentX(), ((WindowView) this.viewComponent).getContentY() );
			pagedContent.handleNotification(note);
		
		} else if (note.getName().equals(SPELL_SELECTED)) {
			
			SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
			spell.setData( note.getBody() );
			this.setCurrentSpell( spell );
		}
		
	}

	/**
	 * M�todo que determina o feiti�o atual.
	 * Obt�m a descri��o do feiti�o, e o componente de visualiza��o a ser configurado. 
	 * @param spell A inst�ncia que cont�m os dados a serem tratados e posteriormente visualizados.
	 */
	public void setCurrentSpell(SpellProxy spell) {
		PagedContentProxy pagedContentProxy = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContentProxy.setContent( spell.getDescription(), 0 );
		
		PagedContentMediator pagedContentMediator = (PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME);
		pagedContentMediator.setViewComponent( pagedContentProxy.getData() );
		
		((SpellViewerUI) this.viewComponent).setCurrentSpell( spell );
	}

	/**
	 * M�todo que configura as imagens dos feiti�os em uma lista a ser repassada para
	 * a inst�ncia da classe que efetua a renderiza��o dos feiti�os da lista.
	 * @param spellList
	 */
	public void setSpellList(SpellListProxy spellList) {
		int qty = spellList.getQty();
		Sprite imgList[] = new Sprite[qty];
		int positions[] = new int[qty];
		for (int i=0;i < qty;i++) {
			SpellProxy spell = spellList.getSpellAt(i);
			imgList[i] = new Sprite(spell.getImage());
			positions[i] = spell.getPosition();
		}
		((SpellViewerUI) this.viewComponent).configureSpells((SpellListVO) spellList.getData(), imgList, positions);
		this.setCurrentSpell( spellList.getSpellAt(0) );
	}
	
	/**
	 * M�todo que retorna um objtedo ObjectMenuItemProxy. Se o argumento passado ao
	 * m�todo for SIDE_LEFT, � retornada um bot�o de fechamento do menu. Ao contr�rio
	 * � retornado uma inst�ncia vazia.
	 */
	public OptionsMenuItemProxy getMenuOption(int side) {
		OptionsMenuItemProxy item = (OptionsMenuItemProxy) facade.retrieveProxy(OptionsMenuItemProxy.NAME);
		item.create();
		if (side == OptionsMenuMediator.SIDE_LEFT) {
			item.setImage(ResourceLibrary.OPTION_CLOSE);
			item.setLabel("Close");
			item.setNotificationName( CLOSE );
		} else {
			item = null;
		}
		return item;
	}
	
}
