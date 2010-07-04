package com.stonespells.models.gameboard;

/**
 * Player Value Object
 * @author Endel
 *
 */
public class PlayerVO {
	
	public String name;
	public int life = PlayerProxy.MAX_LIFE;
	public int concentration;
	public boolean active = false;
	public SpellListVO spellList = null;
	
}
