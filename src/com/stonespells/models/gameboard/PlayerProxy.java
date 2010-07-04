package com.stonespells.models.gameboard;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

/**
 * Proxy para manipulação dos dados de jogadores.
 * @author Endel
 *
 */
public class PlayerProxy extends Proxy implements IProxy {
	
	public static final String NAME = "PlayerProxy";
	
	/**
	 * Constante com o valor inicial de vida dos jogadores
	 */
	public static final int MAX_LIFE = 20;
	
	public PlayerProxy() {
		super(NAME, null);
	}
	
	/**
	 * Cria um novo objeto {@link PlayerVO} à ser manipulado.
	 */
	public void create() {
		PlayerVO player = new PlayerVO();
		this.setData(player);
	}
	
	/**
	 * Define um nome para o jogador.
	 * @param name	String
	 */
	public void setName(String name) {
		((PlayerVO) this.data).name = name;
	}
	
	/**
	 * Define uma vida para o jogador.
	 * @param life	int
	 */
	public void setLife(int life) {
		((PlayerVO) this.data).life = life;
	}
	
	/**
	 * Define a atividade do jogador.
	 * Jogadores inativos não podem interagir com o jogo.
	 * @param active	boolean
	 */
	public void setActive(boolean active) {
		((PlayerVO) this.data).active = active;
	}
	
	/**
	 * Incrementa vida ao jogador.
	 * @param i
	 */
	public void addLife(int i) {
		((PlayerVO) this.data).life = ((PlayerVO) this.data).life + i;
	}
	
	/**
	 * Obtém o nome do jogador.
	 * @return	String
	 */
	public String getName() {
		return ((PlayerVO) this.data).name;
	}
	
	/**
	 * Obtém a vida do jogador.
	 * @return	int
	 */
	public int getLife() {
		return ((PlayerVO) this.data).life;
	}
	
	/**
	 * Obtém o número de pontos de concentração do jogador.
	 * @return	int
	 */
	public int getConcentration() {
		return ((PlayerVO) this.data).concentration;
	}
	
	/**
	 * Obtém atividade do jogador.
	 * @return	boolean
	 */
	public boolean getActive() {
		return ((PlayerVO) this.data).active;
	}
	
	/**
	 * Incrementa pontos de concentração ao jogador.
	 * @param number	int
	 */
	public void addConcentration(int number) {
		((PlayerVO) this.data).concentration += number;
	}
	
	/**
	 * Permuta o estado de atividade do jogador entre ativo/inativo.
	 */
	public void swapActive() {
		this.setActive( !this.getActive() );
	}
	
	/**
	 * Define a lista de spells do jogador.
	 * @param spellList
	 */
	public void setSpellList(SpellListProxy spellList) {
		((PlayerVO) this.data).spellList = (SpellListVO) spellList.getData();
	}
	
	/**
	 * Obtém a lista de spells do jogador.
	 * @return SpellListProxy
	 */
	public SpellListProxy getSpellList() {
		SpellListProxy spellList = (SpellListProxy) facade.retrieveProxy(SpellListProxy.NAME);
		spellList.setData(((PlayerVO) this.data).spellList);
		return spellList;
	}
	
}
