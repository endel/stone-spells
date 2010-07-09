package com.stonespells.controllers.spells.eddition1;

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.models.gameboard.SpellProxy;

/**
 * Classe que possui dados e comportamentos de um feiti�o.
 */
public class Red5Spell extends SpellCommand implements ISpellCommand {

	/**
	 * Array de bytes com os dados relativos � imagem da pedra.
	 */
	public byte[] getImageBytes() {
		return new byte[] {0, 0, 0, 17, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 1, -104, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 90, 0, 0, 0, -82, 0, 0, 0, -1, 0, 0, 0, -46, 0, 0, 0, -92, 0, 0, 0, 108, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 54, 0, 0, 0, -1, 0, 0, 0, -1, 34, 17, 17, -1, 51, 17, 17, -1, 51, 17, 17, -1, 68, 17, 17, -1, 51, 17, 17, -1, 34, 0, 0, -1, 0, 0, 0, -106, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 62, 0, 0, 0, -1, 0, 0, 0, -1, 68, 17, 17, -1, 68, 0, 0, -1, 51, 0, 0, -1, 68, 0, 0, -1, 51, 0, 0, -1, 102, 34, 17, -1, -120, 85, 68, -1, 85, 17, 0, -1, 51, 17, 17, -1, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 1, 0, 0, 0, -1, 0, 0, 0, -1, 102, 34, 17, -1, 68, 0, 0, -1, 17, 0, 0, -1, 51, 0, 0, -1, 68, 0, 0, -1, 102, 68, 51, -1, -86, 119, 119, -1, -103, 119, 102, -1, 68, 17, 0, -1, 85, 17, 0, -1, 51, 17, 17, -107, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 71, 0, 0, 0, -1, 34, 17, 0, -1, -103, 17, 17, -1, -86, 17, 0, -1, -120, 0, 0, -1, 68, 0, 0, -1, 119, 68, 68, -1, -86, -120, -120, -1, -86, -120, 119, -1, -103, 119, 102, -1, 85, 34, 17, -1, 68, 17, 0, -1, 85, 17, 0, -1, 17, 17, 17, 78, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -100, 0, 0, 0, -1, 102, 34, 17, -1, -120, 17, 0, -1, -35, 34, 17, -1, -35, 119, 102, -1, -103, 119, 119, -1, -120, 85, 68, -1, 119, 68, 51, -1, -120, 102, 85, -1, -52, -86, -103, -1, 102, 68, 51, -1, 68, 17, 0, -1, 85, 17, 17, -1, 68, 34, 34, -73, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, -1, 0, 0, 0, -1, -120, 34, 34, -1, 119, 0, 0, -1, -86, 0, 0, -1, -18, -18, -35, -1, -35, 102, 85, -1, 68, 0, 0, -1, 51, 0, 0, -1, 51, 0, 0, -1, -103, 85, 85, -1, 102, 68, 51, -1, 85, 17, 0, -1, 119, 34, 17, -1, 119, 68, 51, -1, 0, 0, 0, 1, 0, 0, 0, 0, -1, -1, -1, -12, 0, 0, 0, -1, -86, 51, 34, -1, 85, 0, 0, -1, -103, 17, 0, -1, -69, 68, 51, -1, -69, 34, 17, -1, 85, 17, 0, -1, 102, 17, 0, -1, 34, 0, 0, -1, 68, 0, 0, -1, -103, 34, 17, -1, -52, 34, 0, -1, -35, 51, 34, -1, 102, 51, 51, -1, 0, 0, 0, 4, 0, 0, 0, 40, 0, 0, 0, -1, 17, 0, 0, -1, -69, 51, 34, -1, -35, 34, 17, -1, -120, 0, 0, -1, -52, 17, 17, -1, -120, 17, 0, -1, 119, 17, 0, -1, -52, 34, 0, -1, -52, 17, 0, -1, 119, 0, 0, -1, -18, 34, 17, -1, -18, 51, 34, -1, -18, 68, 34, -1, 119, 51, 51, -1, 0, 0, 0, 3, 0, 0, 0, 38, 0, 0, 0, -1, 17, 0, 0, -1, -69, 51, 34, -1, -35, 34, 17, -1, -86, 17, 0, -1, -52, 17, 17, -1, -86, 17, 0, -1, -103, 34, 0, -1, -35, 34, 0, -1, -35, 17, 0, -1, -52, 17, 17, -1, 102, 34, 34, -1, -52, 68, 34, -1, -35, 68, 51, -1, 85, 34, 17, 103, 0, 0, 0, 0, 0, 0, 0, 65, 0, 0, 0, -1, 34, 17, 17, -1, -103, 34, 17, -1, -35, 17, 17, -1, -103, 17, 0, -1, -35, 68, 51, -1, -52, 51, 34, -1, -86, 68, 34, -1, -35, 68, 34, -1, -52, 68, 51, -1, -69, 68, 51, -1, 85, 51, 34, -1, -86, 68, 34, -1, -69, 68, 51, -1, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 68, 0, 0, 0, -1, 34, 17, 17, -1, 102, 17, 0, -1, -120, 0, 0, -1, 119, 51, 34, -1, -69, -103, -120, -1, -69, -103, -120, -1, -69, -103, -120, -1, -35, -103, -120, -1, -35, 119, 102, -1, -35, 51, 34, -1, -35, 68, 34, -1, -52, 85, 51, -1, 85, 34, 17, -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 69, 0, 0, 0, -1, 34, 17, 17, -1, 51, 0, 0, -1, 34, 0, 0, -1, -86, 85, 51, -1, -52, -52, -69, -1, -35, -52, -69, -1, -52, -69, -69, -1, -35, -52, -69, -1, -35, 85, 68, -1, -35, 34, 34, -1, -52, 85, 51, -1, -103, 68, 34, -1, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 0, 0, 0, -1, 17, 0, 0, -1, 68, 17, 0, -1, 68, 0, 0, -1, -69, 102, 68, -1, -35, -52, -69, -1, -18, -52, -69, -1, -35, -52, -69, -1, -69, -103, -120, -1, -69, 51, 34, -1, -69, 51, 51, -1, -69, 68, 51, -1, 17, 17, 0, 71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 0, 0, 0, -1, 0, 0, 0, -1, 85, 34, 34, -1, 85, 17, 0, -1, -86, 85, 34, -1, -18, -35, -69, -1, -18, -52, -69, -1, -86, -120, 119, -1, 102, 51, 51, -1, 102, 51, 34, -1, 119, 68, 51, -1, 68, 34, 17, -116, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, -1, 0, 0, 0, -1, 85, 34, 17, -1, 85, 17, 0, -1, 119, 68, 51, -1, -35, -52, -69, -1, -52, -86, -103, -1, 68, 34, 17, -1, 85, 51, 34, -1, 119, 68, 51, -1, 68, 51, 34, -1, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, -1, 0, 0, 0, -1, 85, 34, 17, -1, 51, 0, 0, -1, 68, 34, 17, -1, -69, -86, -103, -1, 102, 68, 51, -1, 85, 51, 34, -1, 119, 68, 51, -1, 102, 68, 68, -1, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -81, 0, 0, 0, -1, 51, 34, 17, -1, 51, 0, 0, -1, 68, 17, 0, -1, 102, 51, 34, -1, 85, 51, 34, -1, 102, 68, 51, -1, 85, 68, 51, -1, 17, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 84, 0, 0, 0, -1, 51, 17, 17, -1, 68, 0, 0, -1, -120, 17, 17, -1, 85, 51, 34, -1, -120, 68, 51, -1, 34, 34, 34, -99, 0, 0, 0, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 12, 0, 0, 0, -1, 0, 0, 0, -1, 119, 17, 0, -1, 119, 34, 17, -1, 102, 51, 34, -1, 17, 17, 17, -126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, -107, 0, 0, 0, -1, 68, 17, 17, -1, 51, 34, 17, -1, 17, 0, 0, 117, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 41, 0, 0, 0, -110, 0, 0, 0, -1, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	}
	
	public void onCast() {
		// TODO Auto-generated method stub

	}

	public void onCreate() {
		getSpell().setId(13);
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
