package com.stonespells.controllers.spells.eddition1;

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.models.gameboard.SpellProxy;

/**
 * Classe que possui dados e comportamentos de um feiti�o.
 */
public class White3Spell extends SpellCommand implements ISpellCommand {

	/**
	 * Array de bytes com os dados relativos � imagem da pedra.
	 */
	public byte[] getImageBytes() {
		return new byte[] {0, 0, 0, 22, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 1, -28, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 63, 0, 0, 0, 115, 0, 0, 0, -96, 0, 0, 0, -117, 0, 0, 0, 74, 0, 0, 0, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 1, 0, 0, 0, 64, 0, 0, 0, -87, 0, 0, 0, -16, 0, 0, 0, -1, 34, 34, 34, -1, 68, 51, 51, -1, 85, 85, 85, -1, 102, 85, 102, -1, 51, 34, 34, -1, 34, 34, 34, 115, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 44, 0, 0, 0, -1, 0, 0, 0, -1, 34, 17, 17, -1, 102, 102, 102, -1, -103, -120, -120, -1, -103, -120, -103, -1, -120, 102, 119, -1, 102, 85, 102, -1, -120, 119, -120, -1, -86, -120, -86, -1, -120, 119, 119, -1, 68, 51, 51, -113, 0, 0, 0, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 111, 0, 0, 0, -1, 0, 0, 0, -1, 102, 102, 102, -1, -86, -103, -103, -1, -86, -103, -103, -1, -103, -120, -103, -1, -86, -103, -86, -1, 119, 102, 119, -1, 102, 85, 102, -1, 119, 102, 119, -1, -86, -120, -103, -1, -69, -103, -86, -1, -86, -103, -86, -1, 119, 102, 102, -1, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 120, 0, 0, 0, -1, 0, 0, 0, -1, -69, -86, -86, -1, -52, -69, -69, -1, -69, -69, -69, -1, -35, -35, -35, -1, -103, -120, -103, -1, -86, -103, -103, -1, -86, -103, -86, -1, -69, -103, -86, -1, -69, -103, -86, -1, -69, -103, -86, -1, -35, -69, -52, -1, -69, -69, -69, -1, -86, -120, -103, -1, 68, 51, 51, -1, 0, 0, 0, 5, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 59, 0, 0, 0, -1, 0, 0, 0, -1, -52, -69, -69, -1, -35, -52, -52, -1, -103, -120, -103, -1, -52, -69, -69, -1, -18, -52, -52, -1, -69, -86, -69, -1, -69, -86, -69, -1, -69, -86, -69, -1, -69, -86, -69, -1, -52, -86, -69, -1, -52, -69, -52, -1, -35, -52, -35, -1, -35, -52, -52, -1, -35, -52, -52, -1, -103, -120, -103, -1, 17, 17, 17, 35, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -92, 0, 0, 0, -1, 119, 102, 119, -1, -18, -52, -52, -1, -120, 119, 119, -1, 102, 68, 85, -1, -86, -103, -86, -1, -18, -35, -35, -1, -52, -69, -69, -1, -35, -52, -35, -1, -52, -69, -69, -1, -69, -86, -86, -1, -69, -86, -86, -1, -52, -69, -52, -1, -86, -120, -120, -1, -69, -103, -86, -1, -52, -86, -69, -1, -86, -120, -103, -1, 51, 34, 51, 79, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, -124, 0, 0, 0, -1, 34, 34, 34, -1, -69, -86, -86, -1, -35, -52, -52, -1, 119, 102, 119, -1, -120, 102, 119, -1, -1, -1, -1, -1, -69, -86, -86, -1, -52, -52, -52, -1, -35, -35, -35, -1, -18, -18, -18, -1, -86, -103, -103, -1, -18, -35, -35, -1, -52, -86, -86, -1, -86, -120, -120, -1, -103, -120, -120, -1, -120, 119, 119, -1, -103, 119, -120, -1, 102, 85, 102, -109, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, -19, 0, 0, 0, -1, -103, -120, -103, -1, -69, -86, -69, -1, -1, -1, -1, -1, -18, -35, -35, -1, -35, -52, -52, -1, -18, -18, -18, -1, 85, 68, 85, -1, 85, 68, 85, -1, -69, -86, -86, -1, -35, -52, -52, -1, -35, -69, -52, -1, -69, -103, -86, -1, -103, -120, -120, -1, -86, -120, -103, -1, -86, -120, -103, -1, 102, 85, 102, -1, 102, 85, 102, -1, 68, 51, 68, -94, 0, 0, 0, 0, -1, -1, -1, 53, 0, 0, 0, -1, 17, 17, 17, -1, -86, -103, -103, -1, -86, -120, -103, -1, -52, -69, -52, -1, -18, -35, -35, -1, -1, -18, -18, -1, -86, -103, -103, -1, 85, 51, 68, -1, 85, 68, 68, -1, -35, -52, -52, -1, -52, -69, -69, -1, -35, -52, -52, -1, -52, -69, -69, -1, -52, -69, -69, -1, -86, -103, -103, -1, -103, -120, -120, -1, 68, 68, 68, -1, 68, 51, 51, -1, 68, 51, 51, -101, 0, 0, 0, 0, -1, -1, -1, -98, 0, 0, 0, -1, 102, 85, 102, -1, -86, -103, -86, -1, -69, -86, -86, -1, -35, -52, -52, -1, -18, -52, -52, -1, -1, -1, -1, -1, -35, -52, -35, -1, -69, -86, -86, -1, -52, -69, -69, -1, -1, -1, -1, -1, -18, -35, -35, -1, -18, -35, -35, -1, -18, -18, -18, -1, -18, -18, -18, -1, -69, -86, -86, -1, -86, -120, -120, -1, 102, 85, 102, -1, -120, 119, 119, -1, 51, 51, 51, -109, 0, 0, 0, 1, 0, 0, 0, -1, 0, 0, 0, -1, -103, -120, -120, -1, -86, -103, -86, -1, -52, -86, -69, -1, -69, -86, -86, -1, -103, 119, -120, -1, -52, -69, -69, -1, -1, -18, -18, -1, -1, -18, -18, -1, -52, -69, -69, -1, -35, -52, -52, -1, -1, -1, -1, -1, -103, -120, -120, -1, -120, -120, -120, -1, -120, -120, -120, -1, -35, -52, -52, -1, -52, -86, -86, -1, -120, 119, 119, -1, -103, -120, -120, -1, 17, 17, 17, 42, 0, 0, 0, 3, 0, 0, 0, -1, 0, 0, 0, -1, -103, -120, -120, -1, -86, -103, -86, -1, -69, -103, -86, -1, -103, -120, -120, -1, 102, 85, 102, -1, -103, -120, -120, -1, -69, -86, -86, -1, -103, -120, -103, -1, -86, -103, -103, -1, -18, -52, -52, -1, -35, -52, -52, -1, 85, 68, 85, -1, 51, 34, 68, -1, -69, -86, -86, -1, -35, -52, -52, -1, -103, -120, -103, -1, -69, -86, -69, -1, -103, -120, -103, -13, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, -1, 0, 0, 0, -1, -86, -103, -103, -1, -86, -103, -86, -1, -69, -103, -86, -1, -69, -103, -86, -1, -86, -120, -103, -1, -69, -103, -86, -1, -69, -103, -86, -1, -103, 119, -120, -1, -86, -103, -103, -1, -1, -18, -18, -1, -1, -1, -1, -1, 102, 85, 102, -1, -86, -103, -86, -1, -35, -52, -52, -1, -69, -86, -86, -1, -52, -69, -69, -1, -52, -69, -69, -1, 51, 51, 51, -118, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, -1, 0, 0, 0, -1, -103, 119, -120, -1, -69, -103, -86, -1, -69, -103, -86, -1, -69, -103, -86, -1, -86, -120, -103, -1, -86, -103, -103, -1, -69, -86, -86, -1, -103, -120, -120, -1, -103, -120, -120, -1, -18, -18, -18, -1, -1, -1, -1, -1, -35, -52, -52, -1, -52, -52, -52, -1, 119, 102, 102, -1, 68, 68, 68, -1, -69, -86, -69, -1, -86, -86, -86, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, -1, 0, 0, 0, -1, -103, 119, -120, -1, -52, -86, -69, -1, -52, -86, -69, -1, -52, -86, -69, -1, -35, -52, -35, -1, -69, -86, -69, -1, -86, -103, -103, -1, -86, -103, -86, -1, -86, -103, -86, -1, -86, -103, -103, -1, -52, -69, -69, -1, -69, -103, -103, -1, -1, -18, -18, -1, -120, 119, -120, -1, 102, 85, 85, -1, -86, -86, -86, -1, 17, 0, 0, -106, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 118, 0, 0, 0, -1, 85, 85, 85, -1, -69, -86, -86, -1, -18, -35, -35, -1, -1, -18, -1, -1, -1, -18, -18, -1, -86, -120, -103, -1, -69, -86, -86, -1, -69, -86, -69, -1, -69, -86, -86, -1, -103, -120, -120, -1, -86, -120, -103, -1, -52, -69, -69, -1, -1, -1, -1, -1, -69, -69, -69, -1, -69, -86, -86, -1, 102, 85, 85, -106, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 43, 0, 0, 0, -1, 34, 34, 34, -1, -69, -86, -86, -1, -1, -18, -18, -1, -18, -35, -18, -1, -1, -1, -1, -1, -35, -52, -52, -1, -69, -86, -86, -1, -69, -86, -86, -1, -69, -86, -86, -1, -103, -120, -103, -1, -103, -120, -103, -1, -103, -120, -120, -1, -35, -52, -52, -1, -69, -86, -69, -1, 85, 85, 85, -97, 0, 0, 0, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 103, 0, 0, 0, -1, 51, 34, 51, -1, -86, -103, -103, -1, -52, -69, -52, -1, -86, -103, -86, -1, -86, -103, -86, -1, -69, -86, -86, -1, -69, -86, -69, -1, -69, -86, -69, -1, -69, -86, -86, -1, -69, -86, -86, -1, -69, -86, -69, -1, -86, -103, -103, -1, 51, 51, 51, -97, 0, 0, 0, 54, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 104, 0, 0, 0, -1, 34, 34, 34, -1, 102, 85, 102, -1, -103, -120, -120, -1, -69, -103, -86, -1, -69, -86, -86, -1, -52, -69, -69, -1, -52, -69, -69, -1, -69, -86, -69, -1, -103, -120, -103, -1, 102, 85, 85, -1, 17, 0, 0, -106, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 50, 0, 0, 0, -1, 17, 17, 17, -1, 17, 17, 17, -1, 85, 85, 85, -1, 102, 85, 85, -1, 119, 102, 102, -1, 102, 85, 85, -1, 68, 68, 68, -1, 17, 17, 17, -88, 0, 0, 0, 63, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 26, 0, 0, 0, 46, 0, 0, 0, -119, 0, 0, 0, -109, 0, 0, 0, -88, 0, 0, 0, -106, 0, 0, 0, 114, 0, 0, 0, 45, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	}

	public void onCast() {
		// TODO Auto-generated method stub

	}

	public void onCreate() {
		getSpell().setId(16);
		getSpell().setName("Eternal Diamond");
		getSpell().setDescription("Makes you immune to damage for 3 turns.");
		getSpell().setColor(SpellProxy.COLOR_WHITE);
		getSpell().setCost(5);

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
