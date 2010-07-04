package com.stonespells.controllers.spells;

import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.ICommand;

import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.communication.PlayContextProxy;

public interface ISpellCommand extends ICommand {
	public byte[] getImageBytes();
	public PlayContextProxy getPlayContext();
	public void onCreate();
	public void onTurnBegin();
	public void onTurnEnd();
	public void onSwapPosition();
	public void onEnergize();
	public void onCast();
}
