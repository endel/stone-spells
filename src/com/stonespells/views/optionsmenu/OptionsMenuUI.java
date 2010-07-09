package com.stonespells.views.optionsmenu;

import javax.microedition.lcdui.Image;

import javax.microedition.lcdui.game.Sprite;

import org.puremvc.java.interfaces.IMediator;

import com.stonespells.core.App;
import com.stonespells.views.RenderableItemUI;

/**
 *Classe que carrega imagens do fundo das options e trata do vetor de objetos options.
 */
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
	
	/**
	 * Construtor da classe.
	 * @param mediator Mediador que possui notificações.
	 */
	public OptionsMenuUI(IMediator mediator) {
		//this.mediator = mediator;
	}
	
	/**
	 * Aloca dados no vetor options de acordo com o jogador especificado
	 * @param side Especifica o jogador.
	 * @param data Dados a serem alocados no vetor options.
	 */
	public void setOption(int side, Object data) {
		this.options[side] = data;
	}

	/**
	 * Método que retorna os dados de options alocados na posição especificada.
	 * @param side Especifica a posição do vetor a ser retornadas.
	 * @return Dados salvos na posição especificada.
	 */
	public Object getOption(int side) {
		return this.options[side];
	}
	
}
