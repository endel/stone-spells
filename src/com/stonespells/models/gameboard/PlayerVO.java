package com.stonespells.models.gameboard;

/**
 * Contêiner com os dados relativos a um dos jogadores.
 */
public class PlayerVO {
	
	public String name;
	public int life = PlayerProxy.MAX_LIFE;
	public int concentration;
	public boolean active = false;
	public SpellListVO spellList = null;
	
}
