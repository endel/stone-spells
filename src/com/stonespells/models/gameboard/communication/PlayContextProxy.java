package com.stonespells.models.gameboard.communication;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.PlayerVO;

public class PlayContextProxy extends Proxy implements IProxy {
	
	public static final String NAME = "BoardContextProxy";
	
	public PlayContextProxy() {
		super(NAME, new PlayContextVO() );		
	}
	
	public void setOpponent(PlayerProxy player) {
		((PlayContextVO) this.data).opponent = (PlayerVO) player.getData();
	}
	
	public void setPlayer(PlayerProxy player) {
		((PlayContextVO) this.data).player = (PlayerVO) player.getData();
	}
	
	public PlayerProxy getOpponent() {
		PlayerProxy player = (PlayerProxy) facade.retrieveProxy(PlayerProxy.NAME);
		player.setData(((PlayContextVO) this.data).opponent);
		return player;
	}
	
	public PlayerProxy getPlayer() {
		PlayerProxy player = (PlayerProxy) facade.retrieveProxy(PlayerProxy.NAME);
		player.setData(((PlayContextVO) this.data).player);
		return player;
	}
	
}
