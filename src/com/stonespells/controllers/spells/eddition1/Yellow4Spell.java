package com.stonespells.controllers.spells.eddition1;

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.models.gameboard.SpellProxy;

public class Yellow4Spell extends SpellCommand implements ISpellCommand {

	public byte[] getImageBytes() {
		return new byte[] {0, 0, 0, 22, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 1, -28, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 23, 0, 0, 0, -128, 0, 0, 0, -40, 0, 0, 0, -20, 0, 0, 0, -26, 0, 0, 0, -49, 0, 0, 0, -119, 0, 0, 0, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 107, 0, 0, 0, -1, 0, 0, 0, -1, 85, 68, 17, -1, 102, 85, 17, -1, -103, -120, 17, -1, -52, -86, 34, -1, -86, -103, 34, -1, 85, 68, 17, -1, 17, 17, 0, -115, 0, 0, 0, 21, 0, 0, 0, 0, -86, -120, 85, 0, -86, -120, 85, 0, -103, -120, 85, 0, -103, -120, 68, 0, -86, -120, 68, 0, -86, -120, 51, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 120, 0, 0, 0, -1, 34, 17, 0, -1, -86, -103, 34, -1, -52, -69, 85, -1, -18, -35, 51, -1, -103, 119, 0, -1, -120, 102, 0, -1, -86, -120, 17, -1, 119, 85, 0, -1, 119, 68, 0, -1, 68, 51, 17, -106, 0, 0, 0, 0, -86, -120, 85, 0, -86, -120, 85, 0, -103, -120, 85, 0, -103, -120, 68, 0, -86, -120, 68, 0, -86, -120, 51, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 75, 0, 0, 0, -1, 17, 17, 0, -1, -103, 119, 34, -1, -52, -69, 51, -1, -18, -35, 102, -1, -18, -35, 34, -1, -69, -103, 34, -1, 119, 85, 0, -1, 102, 51, 0, -1, 85, 51, 0, -1, 85, 51, 0, -1, -120, 102, 0, -1, 51, 51, 17, 116, 0, 0, 0, 0, -120, 119, 68, 0, -103, -120, 85, 0, -103, -120, 68, 0, -86, -120, 68, 0, -86, -120, 51, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -76, 0, 0, 0, -1, 85, 68, 17, -1, -103, 119, 0, -1, -69, -86, 34, -1, -18, -1, 85, -1, -52, -69, 51, -1, -86, -103, 34, -1, -103, 102, 0, -1, 119, 85, 0, -1, 119, 85, 0, -1, -120, 102, 0, -1, 102, 68, 0, -1, 68, 34, 0, -1, 0, 0, 0, 57, 0, 0, 0, 2, 0, 0, 0, 0, -103, -120, 68, 0, -86, -120, 68, 0, -86, -120, 51, 0, -1, -1, -1, 0, -1, -1, -1, 77, 0, 0, 0, -1, 51, 34, 17, -1, 119, 85, 0, -1, -103, -120, 17, -1, -103, 119, 17, -1, -69, -86, 34, -1, -69, -86, 17, -1, -86, -120, 17, -1, -86, 119, 17, -1, -103, 119, 0, -1, 119, 68, 0, -1, 119, 85, 0, -1, 68, 51, 0, -1, 51, 17, 0, -1, 68, 51, 17, -1, 17, 17, 0, -1, 0, 0, 0, 95, 0, 0, 0, 0, -86, -120, 68, 0, -86, -120, 51, 0, -1, -1, -1, 0, -1, -1, -1, -74, 0, 0, 0, -1, 119, 102, 34, -1, -86, -120, 17, -1, -120, 119, 17, -1, -86, -120, 34, -1, -69, -86, 85, -1, -1, -18, -103, -1, -35, -52, 102, -1, -69, -86, 85, -1, -69, -86, 85, -1, -120, 102, 34, -1, 85, 51, 0, -1, 68, 34, 0, -1, 68, 17, 0, -1, 102, 68, 0, -1, 68, 51, 0, -1, 85, 68, 17, -1, 34, 34, 17, -107, 0, 0, 0, 0, -86, -120, 51, 0, -1, -1, -1, 13, 0, 0, 0, -1, 0, 0, 0, -1, 119, 68, 17, -1, -52, -103, 17, -1, -35, -52, 17, -1, -52, -86, 51, -1, -1, -1, -1, -1, -1, -18, -18, -1, -35, -52, -120, -1, -52, -69, -120, -1, -52, -69, -120, -1, -52, -52, -103, -1, -86, -103, 102, -1, 85, 51, 17, -1, 51, 17, 0, -1, 51, 17, 0, -1, 102, 51, 0, -1, -120, 85, 0, -1, 119, 102, 0, -1, 51, 34, 17, 121, 0, 0, 0, 0, -1, -1, -1, 61, 0, 0, 0, -1, 34, 34, 17, -1, -86, -120, 34, -1, -69, -86, 34, -1, -69, -86, 34, -1, -35, -69, 68, -1, -1, -18, -35, -1, -52, -69, -103, -1, -35, -52, -120, -1, -35, -52, -120, -1, -52, -69, -120, -1, -52, -52, -103, -1, -52, -52, -103, -1, -69, -86, 102, -1, 102, 85, 17, -1, 85, 51, 0, -1, -86, -120, 17, -1, -52, -103, 17, -1, -86, 119, 0, -1, -103, 119, 17, -1, 0, 0, 0, 17, 0, 0, 0, 97, 0, 0, 0, -1, 68, 51, 34, -1, -18, -18, 102, -1, -18, -18, 85, -1, -52, -52, 102, -1, -69, -86, 85, -1, -35, -35, -86, -1, -52, -69, -120, -1, -18, -35, -103, -1, -18, -18, -103, -1, -52, -69, -120, -1, -52, -69, -120, -1, -52, -69, -120, -1, -69, -86, 119, -1, -103, -120, 85, -1, 119, 85, 0, -1, -52, -69, 34, -1, -86, -86, 34, -1, -52, -86, 17, -1, -69, -103, 17, -1, 51, 51, 17, 89, 0, 0, 0, -124, 0, 0, 0, -1, 85, 85, 51, -1, -86, -103, 34, -1, -52, -69, 51, -1, -69, -86, 34, -1, -18, -35, -86, -1, -35, -35, -86, -1, -52, -69, -120, -1, -35, -52, -120, -1, -18, -35, -103, -1, -35, -35, -120, -1, -52, -69, -120, -1, -69, -86, 119, -1, -86, -103, 102, -1, -86, -103, 102, -1, -103, -120, 68, -1, -120, 102, 0, -1, -86, -120, 17, -1, 119, 68, 0, -1, -86, -120, 17, -1, 85, 68, 17, -116, 0, 0, 0, -80, 0, 0, 0, -1, 102, 85, 51, -1, 85, 68, 0, -1, -103, 119, 17, -1, -52, -69, 102, -1, -1, -18, -69, -1, -18, -35, -86, -1, -52, -69, -120, -1, -35, -52, -103, -1, -18, -35, -103, -1, -18, -18, -103, -1, -35, -52, 119, -1, -52, -69, 119, -1, -86, -103, 102, -1, -86, -103, 102, -1, -103, -120, 68, -1, -120, 119, 34, -1, -18, -52, 51, -1, -103, 102, 0, -1, 85, 68, 0, -1, 85, 68, 17, -101, 0, 0, 0, -70, 0, 0, 0, -1, 119, 102, 51, -1, 85, 68, 0, -1, 102, 68, 17, -1, -103, -120, 17, -1, -18, -35, -120, -1, -18, -35, -103, -1, -35, -52, -120, -1, -35, -52, -120, -1, -52, -69, -120, -1, -18, -18, -86, -1, -18, -35, -120, -1, -52, -69, 102, -1, -86, -103, 85, -1, -69, -103, 102, -1, -86, -86, 102, -1, 119, 102, 0, -1, -52, -86, 17, -1, -86, -120, 17, -1, 51, 34, 0, -1, 68, 51, 17, -113, 0, 0, 0, -72, 0, 0, 0, -1, -120, 119, 51, -1, -103, 119, 17, -1, -86, -120, 34, -1, -52, -69, 51, -1, -69, -86, 34, -1, -35, -52, -120, -1, -52, -69, -120, -1, -69, -86, 119, -1, -18, -35, -120, -1, -1, -1, -103, -1, -52, -69, 119, -1, -69, -103, 102, -1, -69, -103, 102, -1, -18, -18, -18, -1, -18, -18, -35, -1, 119, 102, 0, -1, -86, -120, 0, -1, 102, 85, 0, -1, 85, 68, 0, -1, 34, 34, 0, 99, 0, 0, 0, -68, 0, 0, 0, -1, 119, 102, 51, -1, -86, -120, 17, -1, -52, -86, 51, -1, 119, 102, 34, -1, 119, 85, 0, -1, -86, -120, 51, -1, -52, -86, -120, -1, -69, -86, 119, -1, -35, -52, 119, -1, -35, -52, 119, -1, -86, -103, 85, -1, -69, -103, 85, -1, -35, -52, -86, -1, -1, -18, -86, -1, -18, -35, -120, -1, -52, -86, 17, -1, -103, 119, 0, -1, 119, 85, 0, -1, 102, 85, 17, -1, 0, 0, 0, 25, 0, 0, 0, -88, 0, 0, 0, -1, 119, 102, 51, -1, -52, -86, 34, -1, -120, 85, 17, -1, -120, 102, 17, -1, -103, 119, 17, -1, 102, 85, 0, -1, 119, 85, 51, -1, -120, 119, 68, -1, -103, -120, 68, -1, -86, -103, 34, -1, -52, -86, 34, -1, -35, -35, 85, -1, -18, -35, 85, -1, -52, -86, 51, -1, -52, -86, 51, -1, -52, -86, 51, -1, -120, 85, 0, -1, 102, 68, 0, -1, 34, 34, 17, 127, 0, 0, 0, 0, -1, -1, -1, 119, 0, 0, 0, -1, 85, 68, 34, -1, -18, -35, 51, -1, -120, 102, 34, -1, 119, 85, 17, -1, -120, 102, 17, -1, 102, 68, 0, -1, 68, 34, 0, -1, 68, 34, 0, -1, -103, 119, 0, -1, -69, -103, 17, -1, -18, -35, 68, -1, -1, -1, 102, -1, -1, -18, 102, -1, -18, -18, 102, -1, -35, -69, 51, -1, -120, 102, 34, -1, 119, 85, 17, -1, 34, 34, 17, -108, 0, 0, 0, 0, -103, -120, 102, 0, -1, -1, -1, 96, 0, 0, 0, -1, 51, 51, 17, -1, -35, -52, 68, -1, -69, -86, 85, -1, 68, 34, 0, -1, 85, 68, 0, -1, 102, 85, 0, -1, 102, 51, 0, -1, 102, 51, 0, -1, -120, 102, 17, -1, -103, -120, 34, -1, -69, -103, 51, -1, -18, -18, 102, -1, -1, -1, -86, -1, -1, -18, 85, -1, -69, -103, 51, -1, 102, 85, 34, -1, 17, 17, 0, -126, 0, 0, 0, 0, -103, -120, 102, 0, -103, -120, 102, 0, -1, -1, -1, 37, 0, 0, 0, -1, 17, 17, 0, -1, -69, -86, 68, -1, -103, -120, 51, -1, 85, 51, 0, -1, 102, 68, 0, -1, 102, 68, 0, -1, 119, 85, 17, -1, 102, 68, 0, -1, 102, 68, 17, -1, 102, 85, 34, -1, -120, 102, 34, -1, -69, -86, 68, -1, -18, -18, 102, -1, -103, -103, 51, -1, 51, 51, 17, -71, 0, 0, 0, 80, 0, 0, 0, 0, -103, -120, 102, 0, -103, -120, 102, 0, -103, -120, 102, 0, -1, -1, -1, 2, 0, 0, 0, -1, 0, 0, 0, -1, 102, 68, 17, -1, 102, 68, 0, -1, 102, 68, 0, -1, 102, 85, 0, -1, -69, -103, 0, -1, -69, -103, 0, -1, 119, 85, 17, -1, -120, 102, 34, -1, -86, -103, 51, -1, -103, -120, 51, -1, 85, 68, 34, -1, 34, 34, 17, -67, 0, 0, 0, 86, 0, 0, 0, 0, -86, -120, 102, 0, -86, -120, 85, 0, -103, -120, 102, 0, -103, -120, 102, 0, -103, -120, 102, 0, -1, -1, -1, 0, -1, -1, -1, 123, 0, 0, 0, -1, 68, 51, 34, -1, 119, 85, 17, -1, -103, 119, 34, -1, -86, -103, 34, -1, -103, -120, 34, -1, 102, 85, 34, -1, 85, 68, 34, -1, 51, 34, 17, -1, 17, 17, 0, -1, 0, 0, 0, -116, 0, 0, 0, 56, 0, 0, 0, 0, -86, -103, 102, 0, -86, -103, 102, 0, -86, -120, 102, 0, -86, -120, 85, 0, -103, -120, 102, 0, -103, -120, 102, 0, -103, -120, 102, 0, -1, -1, -1, 0, -1, -1, -1, 18, 0, 0, 0, 123, 0, 0, 0, -43, 0, 0, 0, -35, 0, 0, 0, -50, 0, 0, 0, -74, 0, 0, 0, -86, 0, 0, 0, -119, 0, 0, 0, 81, 0, 0, 0, 38, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1};
	}

	public void onCast() {
		// TODO Auto-generated method stub

	}

	public void onCreate() {
		getSpell().setId(20);
		getSpell().setName("Spell vermelha bonita");
		getSpell().setDescription("O oponente leva 1 de dano.");
		getSpell().setColor(SpellProxy.COLOR_RED);
		getSpell().setCost(2);
	}

	public void onEnergize() {
		// TODO Auto-generated method stub

	}

	public void onSwapPosition() {
		// TODO Auto-generated method stub

	}

	public void onTurnBegin() {
		// TODO Auto-generated method stub

	}

	public void onTurnEnd() {
		// TODO Auto-generated method stub

	}

}
