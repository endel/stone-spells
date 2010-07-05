package com.stonespells.controllers.spells;

import org.puremvc.java.interfaces.ICommand;

import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.SpellProxy;

public interface ISpellCommand extends ICommand {

	/**
	 * Este método deve retornar um array de bytes com as informações da imagem
	 * no seguinte formato: [width, height, r, g, b, r, g, b, r, g, b, ...]
	 * 
	 * @see TemplateSpellCommand
	 * @return
	 */
	public byte[] getImageBytes();

	/**
	 * Este método deve inicializar os dados básicos da spell.
	 * 
	 * @see TemplateSpellCommand
	 */
	public void onCreate();

	/**
	 * Este método é disparado ao início do turno do possuidor da spell.
	 */
	public void onTurnBegin();

	/**
	 * Este método é disparado ao final do turno do possuidor da spell.
	 */
	public void onTurnEnd();

	/**
	 * Este método é disparado nas duas spells que tiveram suas posições
	 * trocadas.
	 */
	public void onSwapPosition();

	/**
	 * Este método é disparado à cada ponto de energia adicionado na spell.
	 */
	public void onEnergize();

	/**
	 * Este método é disparado quando a spell foi selecionada e confirmada para
	 * cast. Utilize o método getPlayContext para interagir com todas as
	 * informações disponíveis no jogo.
	 */
	public void onCast();
	
	public SpellProxy getSpell();
	public PlayContextProxy getPlayContext();
}
