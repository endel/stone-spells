package com.stonespells.controllers.spells.eddition1;

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.models.gameboard.SpellProxy;

/**
 * Classe que possui dados e comportamentos de um feiti�o.
 */
public class Green5Spell extends SpellCommand implements ISpellCommand {

	/**
	 * Array de bytes com os dados relativos � imagem da pedra.
	 */
	public byte[] getImageBytes() {
		return new byte[] {0, 0, 0, 23, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 1, -75, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 2, 0, 0, 0, 53, 0, 0, 0, 122, 0, 0, 0, -87, 0, 0, 0, -57, 0, 0, 0, -43, 0, 0, 0, -50, 0, 0, 0, -73, 0, 0, 0, -116, 0, 0, 0, 75, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 2, 0, 0, 0, 98, 0, 0, 0, -1, 0, 0, 0, -1, 17, 34, 17, -1, 51, 85, 51, -1, 68, 119, 68, -1, 85, -103, 85, -1, 85, -86, 85, -1, 68, -120, 68, -1, 34, 119, 51, -1, 17, 68, 34, -1, 17, 34, 17, -1, 0, 0, 0, -122, 0, 0, 0, 29, 0, 0, 0, 0, 34, 102, 51, 0, 34, 102, 51, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 82, 0, 0, 0, -1, 0, 0, 0, -1, 34, 68, 34, -1, 85, -103, 85, -1, 85, -69, 102, -1, 17, -103, 34, -1, 17, -103, 51, -1, 34, -69, 68, -1, 51, -86, 68, -1, 34, -103, 68, -1, 17, -103, 51, -1, 0, -120, 34, -1, 17, -120, 51, -1, 34, 119, 34, -1, 17, 68, 17, -1, 0, 0, 0, 91, 0, 0, 0, 0, 34, 102, 51, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 122, 0, 0, 0, -1, 0, 17, 0, -1, 68, -120, 68, -1, 119, -52, 119, -1, 102, -52, 119, -1, 17, -69, 68, -1, 0, -103, 34, -1, 0, -69, 51, -1, 17, -52, 68, -1, 17, -103, 51, -1, 17, -86, 68, -1, 17, -52, 68, -1, 0, -86, 34, -1, 0, 119, 17, -1, 17, -120, 51, -1, 34, -103, 68, -1, 34, 102, 51, -1, 0, 0, 0, 72, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 121, 0, 0, 0, -1, 17, 17, 17, -1, 34, -103, 68, -1, 85, -52, 102, -1, 119, -52, 119, -1, 68, -52, 85, -1, 17, -52, 85, -1, 17, -69, 51, -1, 0, -69, 51, -1, 17, -52, 68, -1, 34, -52, 68, -1, 68, -52, 102, -1, 68, -18, 119, -1, 0, -69, 51, -1, 0, -120, 17, -1, 0, -120, 34, -1, 0, -120, 17, -1, 0, 119, 0, -1, 0, 85, 17, -79, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 76, 0, 0, 0, -1, 0, 17, 0, -1, 51, -103, 68, -1, 34, -69, 68, -1, 51, -69, 85, -1, 85, -69, 85, -1, 34, -52, 68, -1, 17, -52, 68, -1, 68, -18, 119, -1, 51, -35, 85, -1, 85, -35, 102, -1, -103, -1, -86, -1, -120, -18, -120, -1, 102, -69, 102, -1, 17, -86, 51, -1, 0, -103, 34, -1, 0, -120, 17, -1, 0, -103, 34, -1, 0, -103, 17, -1, 0, -120, 17, -1, 0, 34, 0, 78, 0, 0, 0, 0, -1, -1, -1, -75, 0, 0, 0, -1, 34, 102, 51, -1, 34, -86, 68, -1, 51, -86, 68, -1, 34, -86, 51, -1, 34, -86, 68, -1, 51, -52, 85, -1, 51, -52, 85, -1, 51, -52, 85, -1, 34, -69, 68, -1, 34, -69, 68, -1, 51, -18, 119, -1, 34, -52, 85, -1, 17, -103, 51, -1, 17, -103, 51, -1, -86, -35, -86, -1, -69, -35, -86, -1, 51, -86, 85, -1, 17, -103, 51, -1, 0, -86, 34, -1, 17, 102, 34, -73, 0, 0, 0, 60, 0, 0, 0, -1, 0, 34, 17, -1, 17, -86, 51, -1, 17, -86, 51, -1, 34, -86, 51, -1, 17, -86, 51, -1, 34, -86, 51, -1, 34, -69, 68, -1, 51, -52, 85, -1, 34, -69, 68, -1, 17, -86, 51, -1, 17, -86, 51, -1, 34, -35, 102, -1, 34, -52, 68, -1, 0, -103, 34, -1, 0, -120, 34, -1, 68, -86, 85, -1, -1, -1, -18, -1, 102, -52, 119, -1, 51, -86, 85, -1, 51, -86, 68, -1, 17, -120, 51, -28, 0, 0, 0, -109, 0, 0, 0, -1, 17, 85, 34, -1, 17, -52, 68, -1, 17, -69, 51, -1, 0, -86, 51, -1, 34, -86, 51, -1, 34, -69, 68, -1, 34, -86, 51, -1, 17, -86, 51, -1, 34, -86, 51, -1, 68, -86, 68, -1, 51, -86, 68, -1, 17, -103, 51, -1, 34, -86, 68, -1, 51, -69, 85, -1, 0, -103, 34, -1, 0, 119, 17, -1, 68, -86, 85, -1, 85, -69, 85, -1, 68, -69, 85, -1, 51, -86, 68, -1, 0, -103, 34, -18, 0, 0, 0, -62, 0, 0, 0, -1, 17, -120, 51, -1, 17, -69, 68, -1, 0, -69, 51, -1, 102, -52, 119, -1, -69, -18, -69, -1, 17, -86, 51, -1, 34, -120, 34, -1, 34, -103, 51, -1, 34, -103, 51, -1, 17, -120, 34, -1, 34, -120, 51, -1, 34, -120, 51, -1, 51, -86, 68, -1, 68, -69, 85, -1, 17, -103, 51, -1, 0, 119, 17, -1, 17, -103, 51, -1, 51, -86, 85, -1, 51, -69, 85, -1, 0, -103, 34, -1, 0, -120, 34, -18, 0, 0, 0, -38, 0, 0, 0, -1, 17, -103, 51, -1, 17, -52, 68, -1, 34, -69, 51, -1, -86, -18, -86, -1, -69, -18, -69, -1, 0, -86, 51, -1, 34, -103, 51, -1, 34, -120, 34, -1, 17, 119, 34, -1, 0, 102, 17, -1, 17, 119, 34, -1, 51, -103, 51, -1, 68, -69, 85, -1, 85, -69, 85, -1, 68, -86, 68, -1, 0, 119, 17, -1, 34, -52, 85, -1, 34, -86, 68, -1, 17, -69, 68, -1, 0, -86, 34, -1, 0, -120, 34, -24, 0, 0, 0, -57, 0, 0, 0, -1, 34, -120, 51, -1, 51, -52, 85, -1, 68, -69, 85, -1, 85, -69, 85, -1, 102, -52, 119, -1, 0, -86, 34, -1, 17, -120, 34, -1, 17, 119, 34, -1, 34, -120, 51, -1, 17, -120, 34, -1, 0, 119, 17, -1, 17, 119, 17, -1, 68, -103, 51, -1, 51, -86, 68, -1, 51, -103, 68, -1, 119, -69, 102, -1, 119, -35, -120, -1, 17, -103, 51, -1, 17, -86, 51, -1, 0, -86, 34, -1, 0, 102, 17, -76, 0, 0, 0, -110, 0, 0, 0, -1, 17, 85, 34, -1, 51, -69, 85, -1, 68, -69, 85, -1, 68, -69, 85, -1, 51, -86, 68, -1, 0, -103, 51, -1, 0, -103, 34, -1, 34, -103, 51, -1, 34, -103, 51, -1, 17, -120, 34, -1, 0, 119, 34, -1, 51, -103, 34, -1, 85, -69, 51, -1, 68, -69, 85, -1, 68, -86, 85, -1, -86, -52, -120, -1, 119, -69, 119, -1, 17, -103, 34, -1, 0, -103, 34, -1, 0, -103, 34, -1, 0, 17, 0, 75, 0, 0, 0, 59, 0, 0, 0, -1, 0, 34, 17, -1, 34, -52, 68, -1, 51, -52, 85, -1, 51, -69, 68, -1, 51, -86, 68, -1, 34, -86, 68, -1, 17, -86, 51, -1, 17, -86, 51, -1, 34, -69, 68, -1, 51, -86, 68, -1, 68, -86, 85, -1, 68, -52, 85, -1, -103, -18, -103, -1, -120, -35, -120, -1, 119, -52, 119, -1, 68, -86, 68, -1, 51, -103, 51, -1, 17, -120, 51, -1, 17, -120, 34, -1, 0, 85, 17, -90, 0, 0, 0, 0, -1, -1, -1, 1, 0, 0, 0, -1, 0, 0, 0, -1, 17, 119, 34, -1, 0, -69, 51, -1, 17, -86, 51, -1, 51, -86, 68, -1, 51, -86, 68, -1, 51, -86, 68, -1, 85, -69, 102, -1, 85, -52, 102, -1, 85, -35, 119, -1, 85, -52, 102, -1, 68, -69, 85, -1, -120, -18, -120, -1, -103, -1, -103, -1, -86, -18, -103, -1, 119, -52, 119, -1, 51, -86, 68, -1, 17, -103, 34, -1, 0, 85, 17, -1, 0, 0, 0, 61, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 74, 0, 0, 0, -1, 0, 0, 0, -1, 17, -120, 34, -1, 0, -86, 34, -1, 34, -86, 68, -1, 34, -86, 68, -1, 34, -69, 68, -1, 68, -18, 119, -1, 68, -35, 119, -1, 51, -18, 102, -1, 34, -35, 85, -1, 34, -69, 85, -1, 51, -52, 85, -1, 68, -35, 102, -1, 68, -69, 85, -1, 51, -86, 68, -1, 17, -103, 51, -1, 34, 85, 34, -1, 0, 0, 0, 82, 0, 0, 0, 0, 51, 119, 51, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 121, 0, 0, 0, -1, 0, 17, 0, -1, 0, -120, 51, -1, 17, -86, 68, -1, 34, -86, 68, -1, 34, -69, 68, -1, 34, -35, 85, -1, 68, -18, 119, -1, 51, -18, 102, -1, 34, -52, 85, -1, 17, -69, 51, -1, 17, -86, 51, -1, 17, -69, 51, -1, 51, -52, 85, -1, 17, -120, 51, -1, 0, 34, 0, -98, 0, 0, 0, 53, 0, 0, 0, 0, 51, 119, 51, 0, 51, 119, 51, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 101, 0, 0, 0, -1, 0, 0, 0, -1, 0, 68, 17, -1, 17, -120, 51, -1, 17, -69, 68, -1, 34, -52, 85, -1, 51, -35, 102, -1, 34, -69, 68, -1, 34, -86, 51, -1, 34, -69, 68, -1, 34, -86, 51, -1, 17, 119, 34, -1, 0, 51, 17, -1, 0, 0, 0, 108, 0, 0, 0, 0, 51, 119, 51, 0, 51, 119, 51, 0, 51, 119, 51, 0, 51, 119, 51, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 16, 0, 0, 0, 121, 0, 0, 0, -44, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -26, 0, 0, 0, -69, 0, 0, 0, 94, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1};
	}

	public void onCast() {
		// TODO Auto-generated method stub

	}

	public void onCreate() {
		getSpell().setId(7);
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
