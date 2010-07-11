package com.stonespells.controllers.spells.eddition1;

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.models.gameboard.PlayContextProxy;
import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;

/**
 * Classe que possui dados e comportamentos de um feiti�o.
 */
public class Yellow1Spell extends SpellCommand implements ISpellCommand {

	/**
	 * Array de bytes com os dados relativos � imagem da pedra.
	 */
	public byte[] getImageBytes() {
		return new byte[] {0, 0, 0, 22, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 1, -6, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, -121, 0, 0, 0, -66, 0, 0, 0, -63, 0, 0, 0, -78, 0, 0, 0, -109, 0, 0, 0, 72, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -103, 119, 68, 0, -103, 119, 85, 31, 0, 0, 0, -117, 0, 0, 0, -1, 17, 0, 0, -1, 68, 34, 17, -1, 102, 51, 17, -1, 85, 51, 0, -1, 85, 51, 0, -1, 85, 51, 17, -1, 34, 17, 0, -1, 0, 0, 0, 99, 0, 0, 0, 0, -69, -86, 102, 0, -52, -69, -120, 0, -52, -86, 119, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -103, 119, 68, 90, 0, 0, 0, -1, 0, 0, 0, -1, 68, 51, 34, -1, 102, 51, 17, -1, 102, 51, 0, -1, 102, 51, 0, -1, 119, 68, 0, -1, 102, 51, 0, -1, 102, 34, 0, -1, 119, 51, 0, -1, 85, 51, 0, -1, 17, 17, 0, -116, 0, 0, 0, 0, -52, -69, -120, 0, -52, -69, -120, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 116, 0, 0, 0, -1, 17, 0, 0, -1, 85, 68, 34, -1, 68, 17, 0, -1, 85, 17, 0, -1, 102, 51, 0, -1, 102, 68, 0, -1, -120, 102, 0, -1, -103, 102, 0, -1, -120, 68, 0, -1, -103, 85, 0, -1, -120, 85, 17, -1, 119, 85, 0, -1, 51, 51, 17, -110, 0, 0, 0, 0, -69, -103, 102, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 97, 0, 0, 0, -1, 17, 0, 0, -1, 85, 51, 17, -1, 68, 0, 0, -1, 68, 0, 0, -1, 102, 68, 0, -1, 119, 68, 0, -1, 119, 68, 0, -1, -103, 85, 0, -1, -86, 119, 17, -1, -103, 102, 17, -1, -103, 102, 17, -1, -120, 85, 17, -1, 119, 68, 0, -1, -120, 85, 0, -1, 34, 17, 0, 110, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 43, 0, 0, 0, -1, 0, 0, 0, -1, 102, 68, 34, -1, 68, 17, 0, -1, 68, 17, 0, -1, 85, 34, 0, -1, 119, 85, 17, -1, 119, 85, 17, -1, -103, 102, 34, -1, -69, -103, 119, -1, 119, 85, 34, -1, 119, 85, 17, -1, -120, 102, 17, -1, 119, 85, 17, -1, 102, 51, 0, -1, 119, 51, 0, -1, 102, 68, 0, -1, 0, 0, 0, 14, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -106, 0, 0, 0, -1, 85, 68, 34, -1, 85, 17, 0, -1, 85, 17, 0, -1, 85, 34, 0, -1, 119, 68, 17, -1, -103, 119, 51, -1, -120, 102, 34, -1, -52, -86, 119, -1, -1, -1, -18, -1, -52, -86, -120, -1, -120, 102, 17, -1, -120, 85, 17, -1, -120, 85, 0, -1, 85, 34, 0, -1, 68, 17, 0, -1, 85, 34, 0, -1, 51, 34, 17, 108, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 94, 0, 0, 0, -1, 51, 34, 17, -1, 119, 51, 0, -1, 102, 34, 0, -1, 102, 34, 0, -1, 102, 51, 0, -1, -69, -103, 102, -1, -69, -86, -120, -1, 102, 68, 17, -1, 51, 0, 0, -1, 85, 34, 17, -1, 119, 68, 34, -1, -120, 102, 34, -1, -103, 119, 68, -1, 102, 51, 0, -1, 85, 34, 0, -1, 85, 34, 0, -1, 85, 34, 0, -1, 68, 34, 0, -75, 0, 0, 0, 0, -1, -1, -1, 1, 0, 0, 0, -1, 0, 0, 0, -1, 102, 68, 34, -1, 85, 17, 0, -1, 119, 51, 0, -1, -103, 68, 0, -1, -103, 85, 0, -1, -52, -86, 102, -1, -120, 85, 34, -1, 102, 34, 0, -1, 68, 0, 0, -1, 85, 34, 0, -1, 85, 34, 0, -1, 68, 17, 0, -1, -120, 102, 68, -1, 68, 17, 0, -1, 85, 34, 0, -1, 51, 17, 0, -1, 51, 0, 0, -1, 51, 17, 0, -51, 0, 0, 0, 0, -1, -1, -1, 87, 0, 0, 0, -1, 34, 34, 17, -1, 119, 51, 0, -1, 102, 34, 0, -1, -86, 68, 0, -1, -86, 85, 0, -1, -86, -120, 51, -1, -103, 102, 51, -1, 102, 34, 0, -1, -120, 68, 0, -1, -103, 102, 0, -1, -103, 102, 0, -1, 85, 34, 0, -1, 17, 0, 0, -1, 51, 17, 17, -1, 68, 17, 0, -1, 34, 0, 0, -1, 34, 0, 0, -1, 51, 0, 0, -1, 68, 34, 17, -44, 0, 0, 0, 0, -1, -1, -1, -64, 0, 0, 0, -1, 102, 68, 34, -1, 102, 34, 0, -1, 119, 51, 0, -1, -103, 85, 0, -1, -69, 119, 17, -1, -35, -52, -69, -1, -120, 85, 34, -1, 119, 51, 0, -1, -86, 102, 0, -1, -1, -52, 0, -1, -103, 102, 0, -1, 85, 34, 0, -1, 51, 0, 0, -1, 119, 85, 85, -1, -120, 102, 85, -1, 51, 0, 0, -1, 51, 0, 0, -1, 51, 0, 0, -1, 68, 34, 17, -59, 0, 0, 0, 33, 0, 0, 0, -1, 17, 0, 0, -1, 102, 51, 17, -1, 85, 34, 0, -1, 119, 51, 0, -1, -103, 85, 0, -1, -18, -35, -52, -1, -35, -52, -86, -1, 119, 51, 0, -1, -103, 85, 0, -1, -52, -103, 0, -1, -35, -69, 0, -1, 102, 51, 0, -1, 119, 51, 0, -1, -120, 51, 0, -1, -35, -52, -69, -1, -35, -35, -52, -1, 119, 51, 0, -1, -120, 68, 0, -1, 119, 34, 0, -1, 68, 34, 17, -86, 0, 0, 0, 70, 0, 0, 0, -1, 34, 17, 0, -1, 85, 34, 0, -1, 102, 51, 0, -1, 102, 34, 0, -1, -52, -86, -120, -1, -1, -1, -1, -1, -86, 119, 68, -1, -86, 85, 0, -1, -52, -103, 0, -1, -35, -69, 0, -1, -120, 85, 0, -1, 119, 68, 0, -1, -69, 102, 0, -1, -69, 102, 17, -1, -18, -35, -52, -1, -86, 102, 34, -1, -86, 85, 0, -1, -69, 102, 0, -1, -103, 85, 0, -1, 51, 34, 0, 108, 0, 0, 0, 96, 0, 0, 0, -1, 34, 17, 0, -1, 68, 17, 0, -1, 102, 51, 0, -1, 119, 68, 0, -1, -103, 119, 34, -1, -35, -52, -86, -1, 119, 51, 17, -1, -120, 68, 0, -1, -35, -86, 0, -1, -52, -103, 0, -1, 102, 51, 0, -1, -120, 68, 0, -1, -103, 68, 0, -1, -86, 119, 34, -1, -86, 119, 51, -1, -120, 68, 0, -1, -103, 85, 0, -1, -103, 85, 0, -1, -120, 85, 17, -1, 0, 0, 0, 29, 0, 0, 0, 112, 0, 0, 0, -1, 34, 17, 0, -1, 68, 17, 0, -1, 119, 68, 0, -1, 119, 68, 0, -1, 102, 68, 0, -1, -120, 102, 34, -1, 85, 34, 17, -1, 85, 17, 0, -1, -69, -120, 0, -1, -120, 85, 0, -1, 102, 51, 0, -1, -120, 68, 0, -1, -86, 102, 34, -1, -69, -120, 68, -1, -120, 68, 0, -1, -103, 85, 0, -1, -52, -120, 0, -1, -69, 119, 0, -1, 68, 34, 0, -104, 0, 0, 0, 0, -1, -1, -1, 92, 0, 0, 0, -1, 34, 34, 17, -1, 102, 51, 0, -1, 119, 85, 0, -1, 119, 68, 0, -1, 85, 51, 0, -1, -52, -69, -103, -1, -35, -52, -52, -1, -86, 102, 0, -1, -103, 85, 0, -1, 102, 51, 0, -1, 102, 34, 0, -1, -86, 102, 34, -1, -1, -18, -35, -1, -69, 119, 51, -1, -103, 68, 0, -1, -52, 119, 0, -1, -35, -103, 0, -1, -86, 119, 17, -1, 17, 0, 0, 47, 0, 0, 0, 0, -1, -1, -1, 31, 0, 0, 0, -1, 0, 0, 0, -1, 102, 51, 0, -1, 102, 51, 0, -1, 119, 85, 0, -1, 119, 68, 0, -1, -69, -103, 119, -1, -35, -52, -86, -1, -52, -103, 85, -1, -69, -120, 51, -1, -103, 102, 51, -1, 102, 51, 17, -1, -18, -35, -69, -1, -18, -35, -69, -1, -103, 85, 0, -1, -86, 102, 0, -1, -35, -86, 0, -1, -35, -103, 0, -1, 68, 34, 0, -118, 0, 0, 0, 0, -120, 68, 0, 0, -1, -1, -1, 0, -1, -1, -1, -72, 0, 0, 0, -1, 102, 68, 0, -1, 119, 68, 0, -1, 119, 85, 0, -1, -120, 85, 0, -1, -103, 102, 17, -1, -86, 119, 17, -1, -69, -120, 34, -1, -35, -69, -120, -1, -35, -52, -86, -1, -103, 119, 68, -1, -69, -120, 51, -1, -35, -103, 0, -1, -52, 119, 0, -1, -86, 85, 0, -1, -69, 119, 0, -1, -120, 102, 17, -1, 0, 0, 0, 12, 0, 0, 0, 0, -120, 85, 0, 0, -1, -1, -1, 0, -1, -1, -1, 79, 0, 0, 0, -1, 34, 17, 0, -1, -103, 102, 0, -1, 102, 34, 0, -1, 119, 68, 0, -1, -86, -120, 17, -1, -52, -103, 17, -1, -35, -86, 17, -1, -86, 119, 34, -1, -103, 119, 51, -1, -103, 119, 68, -1, 102, 51, 0, -1, -120, 68, 0, -1, -103, 85, 0, -1, -103, 85, 0, -1, -120, 85, 17, -1, 0, 0, 0, 82, 0, 0, 0, 0, -103, 102, 17, 0, -103, 102, 17, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -109, 0, 0, 0, -1, 68, 51, 17, -1, -120, 68, 0, -1, -120, 85, 0, -1, -86, 119, 17, -1, -103, 119, 17, -1, -86, 119, 0, -1, -120, 85, 0, -1, -120, 85, 0, -1, 119, 68, 17, -1, 85, 34, 0, -1, 85, 34, 0, -1, 102, 51, 0, -1, 119, 68, 0, -1, 17, 17, 0, 115, 0, 0, 0, 0, -86, 119, 34, 0, -86, 119, 34, 0, -86, 119, 34, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 14, 0, 0, 0, -106, 0, 0, 0, -1, 51, 34, 0, -1, -120, 85, 0, -1, -103, 85, 0, -1, -120, 85, 0, -1, 119, 68, 0, -1, 119, 68, 0, -1, 119, 68, 0, -1, 102, 68, 0, -1, 85, 34, 0, -1, 85, 34, 0, -1, 85, 51, 0, -1, 17, 0, 0, 120, 0, 0, 0, 0, -86, 119, 34, 0, -86, 119, 34, 0, -86, 119, 34, 0, -86, 119, 34, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 125, 0, 0, 0, -1, 0, 0, 0, -1, 85, 51, 0, -1, -120, 85, 0, -1, 102, 51, 0, -1, 119, 68, 0, -1, 119, 68, 0, -1, 119, 68, 0, -1, 102, 68, 0, -1, 51, 34, 17, -1, 0, 0, 0, 97, 0, 0, 0, 0, -103, 102, 17, 0, -86, 119, 34, 0, -86, 119, 34, 0, -86, 119, 34, 0, -86, 119, 34, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 24, 0, 0, 0, 118, 0, 0, 0, -44, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -23, 0, 0, 0, -54, 0, 0, 0, 106, 0, 0, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1};
	}

	public void onCast() {
		int ctr = 0;
		PlayContextProxy playContext = this.getPlayContext();
		PlayerProxy opponent = playContext.getOpponent();
		PlayerProxy player = playContext.getPlayer();
		SpellListProxy slpO = opponent.getSpellList();
		SpellListProxy slpP = player.getSpellList();
		for (int i = 0; i < slpO.getQty(); i++) {
			if (slpO.getSpellAt(i).getColor() == SpellProxy.COLOR_GOLD) {
				ctr++;
			}
			if (slpP.getSpellAt(i).getColor() == SpellProxy.COLOR_GOLD) {
				ctr++;
			}
		}
		
		player.addLife( ctr );

	}

	public void onCreate() {
		getSpell().setId(17);
		getSpell().setName("Gleaming Citrine");
		getSpell().setDescription("You gain HP according to the number of yellow stones in game.");
		getSpell().setColor(SpellProxy.COLOR_GOLD);
		getSpell().setCost(4);

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
