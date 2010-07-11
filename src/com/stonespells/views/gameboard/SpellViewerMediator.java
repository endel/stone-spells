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
 * Classe que efetua a comunicação de dados e elementos de
 * visualização das descrições dos feitiços.
 *
 */
public class SpellViewerMediator extends WithMenuMediator implements IMediator, IWithMenuMediator {
	
	public static final String NAME = "SpellViewerMediator";
	
	// Notifications
	public static final String CLOSE = "SpellViewerClose";
	public static final String SPELL_SELECTED = "SpellViewerSpellSelected";
	
	/**
	 * Construtor que instância a classe que contém os elementos de renderização
	 * da descrição de um feitiço.
	 */
	public SpellViewerMediator() {
		super(NAME, null);
		this.setViewComponent(new SpellViewerUI(this));
	}
	
	/**
	 * Método que retorna umalista de strings com notificações relevantes a esta
	 * classe.
	 */
	public String[] listNotificationInterests() {
		return new String[] {};
	}
	
	/**
	 * Método que lida com as notificações recebidas pela instância da classe.
	 * Renderiza o conteúdo paginado da descrição de um feitiço, ou especifica o
	 * feitiço atual.
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
	 * Método que determina o feitiço atual.
	 * Obtém a descrição do feitiço, e o componente de visualização a ser configurado. 
	 * @param spell A instância que contém os dados a serem tratados e posteriormente visualizados.
	 */
	public void setCurrentSpell(SpellProxy spell) {
		PagedContentProxy pagedContentProxy = (PagedContentProxy) facade.retrieveProxy(PagedContentProxy.NAME);
		pagedContentProxy.setContent( spell.getDescription(), 0 );
		
		PagedContentMediator pagedContentMediator = (PagedContentMediator) facade.retrieveMediator(PagedContentMediator.NAME);
		pagedContentMediator.setViewComponent( pagedContentProxy.getData() );
		
		((SpellViewerUI) this.viewComponent).setCurrentSpell( spell );
	}

	/**
	 * Método que configura as imagens dos feitiços em uma lista a ser repassada para
	 * a instância da classe que efetua a renderização dos feitiços da lista.
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
	 * Método que retorna um objtedo ObjectMenuItemProxy. Se o argumento passado ao
	 * método for SIDE_LEFT, é retornada um botão de fechamento do menu. Ao contrário
	 * é retornado uma instância vazia.
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
