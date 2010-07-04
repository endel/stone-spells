package com.stonespells.models.gameboard;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;


/**
 * Classe para interação com os dados do contexto de jogo.
 * Lê e escreve os dados do Jogador, Oponente e suas respectivas listas de spells.
 *  
 * @author Endel
 */
public class PlayContextProxy extends Proxy implements IProxy {
	
	public static final String NAME = "PlayContextProxy";
	
	public PlayContextProxy() {
		super(NAME, new PlayContextVO() );		
	}
	
	/**
	 * Armazena os dados do Oponente
	 * @param player
	 */
	public void setOpponent(PlayerProxy player) {
		((PlayContextVO) this.data).opponent = (PlayerVO) player.getData();
	}
	
	/**
	 * Armazena os dados do Jogador
	 * @param player
	 */
	public void setPlayer(PlayerProxy player) {
		((PlayContextVO) this.data).player = (PlayerVO) player.getData();
	}

	/**
	 * Retorna os dados do Oponente
	 * @return player PlayerProxy
	 * @see PlayerProxy
	 */
	public PlayerProxy getOpponent() {
		PlayerProxy player = (PlayerProxy) facade.retrieveProxy(PlayerProxy.NAME);
		player.setData(((PlayContextVO) this.data).opponent);
		return player;
	}
	
	/**
	 * Retorna os dados do Jogador
	 * @return player PlayerProxy
	 * @see PlayerProxy
	 */
	public PlayerProxy getPlayer() {
		PlayerProxy player = (PlayerProxy) facade.retrieveProxy(PlayerProxy.NAME);
		player.setData(((PlayContextVO) this.data).player);
		return player;
	}
	
}
