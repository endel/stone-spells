package com.stonespells.controllers.spells;

import org.puremvc.java.interfaces.ICommand;

import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.SpellProxy;

/**
 * Classe que trata carcter�sticas dos feiti�os.
 */
public interface ISpellCommand extends ICommand {

	/**
	 * Este m�todo deve retornar um array de bytes com as informa��es da imagem
	 * no seguinte formato: [width, height, r, g, b, r, g, b, r, g, b, ...]
	 * 
	 * @see TemplateSpellCommand
	 * @return
	 */
	public byte[] getImageBytes();

	/**
	 * Este m�todo deve inicializar os dados b�sicos da spell.
	 * 
	 * @see TemplateSpellCommand
	 */
	public void onCreate();

	/**
	 * Este m�todo � disparado ao in�cio do turno do possuidor da spell.
	 */
	public void onTurnBegin();

	/**
	 * Este m�todo � disparado ao final do turno do possuidor da spell.
	 */
	public void onTurnEnd();

	/**
	 * Este m�todo � disparado nas duas spells que tiveram suas posi��es
	 * trocadas.
	 */
	public void onSwapPosition();

	/**
	 * Este m�todo � disparado � cada ponto de energia adicionado na spell.
	 */
	public void onEnergize();

	/**
	 * Este m�todo � disparado quando a spell foi selecionada e confirmada para
	 * cast. Utilize o m�todo getPlayContext para interagir com todas as
	 * informa��es dispon�veis no jogo.
	 */
	public void onCast();
	
	/**
	 * Este m�todo � disparado ao tentar adicionar um ponto de concentra��o na spell.
	 * Dever� retornar se � poss�vel ou n�o adicionar pontos de concentra��o nela.
	 * 
	 * @return boolean
	 */
	public boolean canEnergize();
	
	/**
	 * Este m�todo � disparado ao tentar selecionar a spell para cast.
	 * Dever� retornar se � poss�vel lan��-la ou n�o.
	 * 
	 * @return boolean
	 */
	public boolean canCast();
	
	public SpellProxy getSpell();
	public PlayContextProxy getPlayContext();
	
}
