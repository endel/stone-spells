package com.stonespells.controllers.spells.eddition1;

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.models.gameboard.SpellProxy;

public class Blue1Spell extends SpellCommand implements ISpellCommand {

	public byte[] getImageBytes() {
		return new byte[] {0, 0, 0, 23, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 2, 17, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 37, 0, 0, 0, -123, 0, 0, 0, -63, 0, 0, 0, -23, 0, 0, 0, -17, 0, 0, 0, -17, 0, 0, 0, -40, 0, 0, 0, -91, 0, 0, 0, 79, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 40, 0, 0, 0, -111, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 34, -1, 17, 17, 85, -1, 34, 51, -103, -1, 34, 51, -69, -1, 34, 34, -103, -1, 34, 34, 119, -1, 34, 34, 85, -1, 17, 17, 34, -1, 0, 0, 0, 101, 0, 0, 0, 0, 102, 119, -103, 0, -120, -120, -86, 0, -86, -86, -69, 0, -86, -86, -69, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 108, 0, 0, 0, -1, 0, 0, 0, -1, 17, 17, 68, -1, 17, 17, 102, -1, 17, 17, 119, -1, 17, 34, -69, -1, 51, 102, -18, -1, 68, 102, -35, -1, 51, 85, -52, -1, 17, 51, -69, -1, 34, 34, -103, -1, 34, 34, -120, -1, 34, 51, -103, -1, 17, 17, 51, -106, 0, 0, 0, 15, 0, 0, 0, 0, -86, -86, -69, 0, -86, -86, -69, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 110, 0, 0, 0, -1, 0, 0, 17, -1, 17, 34, 119, -1, 17, 17, -120, -1, 17, 51, -69, -1, 34, 68, -18, -1, 34, 68, -52, -1, 17, 51, -86, -1, 34, 68, -69, -1, 17, 17, -120, -1, 34, 51, -103, -1, 34, 51, -69, -1, 34, 68, -35, -1, 17, 34, -120, -1, 34, 68, -69, -1, 34, 34, 68, -106, 0, 0, 0, 8, 0, 0, 0, 0, -86, -86, -69, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 79, 0, 0, 0, -1, 0, 0, 17, -1, 17, 51, -103, -1, 34, 34, -103, -1, 51, 51, -120, -1, 34, 51, -86, -1, 51, 85, -69, -1, 85, 102, -103, -1, 102, 102, -103, -1, 51, 68, -86, -1, 34, 51, -86, -1, 51, 51, -86, -1, 68, 102, -52, -1, 68, 68, -52, -1, 51, 51, -120, -1, 68, 85, -86, -1, 51, 51, -86, -1, 34, 34, 68, -107, 0, 0, 0, 0, -86, -86, -69, 0, -1, -1, -1, 0, -1, -1, -1, 3, 0, 0, 0, -1, 0, 0, 0, -1, 34, 51, -103, -1, 17, 51, -69, -1, 51, 51, -103, -1, 51, 51, -120, -1, 85, 85, -69, -1, 85, 85, -86, -1, -103, -103, -86, -1, -86, -86, -86, -1, -120, -120, -86, -1, 119, 119, -86, -1, -86, -86, -69, -1, -69, -86, -52, -1, 68, 68, -86, -1, 51, 51, -103, -1, 68, 68, -103, -1, 68, 68, -69, -1, 51, 68, -86, -1, 34, 34, 34, 111, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 107, 0, 0, 0, -1, 17, 34, 85, -1, 17, 51, -69, -1, 34, 85, -35, -1, 85, 102, -35, -1, 102, 119, -35, -1, -103, -69, -1, -1, -120, -103, -18, -1, -120, 119, -103, -1, 119, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 119, 119, -103, -1, -86, -103, -69, -1, 119, 119, -69, -1, 68, 85, -52, -1, 51, 51, -103, -1, 51, 51, -103, -1, 51, 68, -69, -1, 68, 85, -69, -1, 0, 0, 0, 10, 0, 0, 0, 4, 0, 0, 0, -1, 0, 0, 0, -1, 34, 51, -86, -1, 17, 68, -52, -1, 34, 85, -35, -1, 68, 85, -69, -1, -103, -103, -52, -1, -69, -69, -18, -1, 102, 102, -103, -1, 102, 85, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 119, 119, -86, -1, 85, 85, -69, -1, 51, 51, -103, -1, 51, 51, -86, -1, 68, 85, -69, -1, 68, 102, -35, -1, 34, 51, 68, 89, 0, 0, 0, 56, 0, 0, 0, -1, 0, 17, 34, -1, 34, 85, -18, -1, 34, 102, -1, -1, 68, 85, -52, -1, -103, -103, -69, -1, -35, -52, -35, -1, -120, -120, -69, -1, 85, 85, -103, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 85, -120, -1, -120, -120, -86, -1, 102, 102, -69, -1, 51, 68, -86, -1, 51, 68, -86, -1, 51, 85, -86, -1, 85, 119, -103, -84, 0, 0, 0, 107, 0, 0, 0, -1, 17, 34, 85, -1, 51, 85, -52, -1, 85, 119, -18, -1, 119, 119, -69, -1, -103, -103, -69, -1, -86, -86, -69, -1, 85, 85, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 85, -120, -1, 85, 85, -120, -1, -120, 119, -86, -1, -52, -69, -35, -1, 102, 102, -69, -1, 51, 85, -52, -1, 51, 85, -52, -1, 68, 102, -86, -46, 0, 0, 0, -106, 0, 0, 0, -1, 34, 51, 119, -1, 119, 119, -52, -1, -120, -120, -18, -1, 119, 119, -52, -1, -120, -120, -69, -1, 119, 119, -86, -1, 85, 85, -103, -1, 102, 102, -103, -1, 102, 102, -120, -1, 102, 102, -120, -1, 102, 102, -103, -1, 102, 102, -120, -1, 102, 85, -120, -1, 85, 85, -120, -1, 85, 85, -120, -1, 102, 102, -103, -1, -86, -86, -35, -1, 102, 119, -52, -1, 68, 102, -52, -1, 34, 68, -69, -1, 51, 68, -86, -26, 0, 0, 0, -94, 0, 0, 0, -1, 51, 68, -120, -1, 85, 102, -69, -1, 119, 119, -52, -1, 119, 119, -69, -1, -120, -120, -86, -1, 119, 119, -103, -1, 102, 85, -120, -1, 102, 85, -103, -1, 102, 102, -120, -1, 102, 102, -103, -1, 102, 102, -86, -1, 102, 85, -103, -1, 102, 85, -120, -1, 85, 85, -120, -1, 85, 85, -120, -1, 85, 85, -120, -1, 119, 119, -52, -1, 85, 102, -52, -1, 68, 85, -69, -1, 34, 51, -103, -1, 34, 68, -69, -22, 0, 0, 0, -122, 0, 0, 0, -1, 34, 51, 102, -1, 51, 68, -86, -1, 85, 102, -35, -1, -120, -120, -18, -1, -86, -86, -52, -1, -103, -120, -86, -1, 102, 85, -120, -1, 102, 102, -103, -1, 102, 102, -103, -1, 102, 102, -103, -1, 102, 102, -103, -1, 102, 85, -103, -1, 102, 85, -120, -1, 85, 85, -120, -1, 85, 85, -120, -1, 102, 102, -86, -1, -103, -103, -52, -1, 85, 102, -69, -1, 68, 68, -86, -1, 34, 51, -86, -1, 34, 51, -120, -32, 0, 0, 0, 88, 0, 0, 0, -1, 34, 34, 68, -1, 68, 85, -69, -1, 85, 102, -35, -1, 85, 102, -69, -1, -120, -120, -69, -1, -86, -103, -69, -1, 102, 102, -103, -1, 102, 102, -103, -1, 102, 102, -103, -1, 102, 85, -103, -1, 102, 85, -103, -1, 85, 85, -103, -1, 85, 85, -120, -1, 85, 85, -120, -1, 68, 85, -86, -1, 119, -120, -18, -1, -52, -69, -18, -1, 85, 102, -69, -1, 34, 51, -69, -1, 34, 51, -86, -1, 51, 51, 119, -58, 0, 0, 0, 31, 0, 0, 0, -1, 17, 17, 17, -1, 85, 102, -69, -1, 68, 68, -86, -1, 68, 85, -69, -1, 34, 51, -86, -1, 85, 85, -69, -1, 119, 119, -86, -1, 102, 85, -103, -1, 85, 85, -103, -1, 85, 85, -103, -1, 85, 85, -103, -1, 85, 85, -120, -1, 85, 85, -120, -1, 85, 85, -103, -1, 102, 119, -52, -1, -86, -86, -18, -1, -120, -120, -69, -1, 51, 68, -86, -1, 34, 51, -69, -1, 17, 34, -103, -1, 51, 51, 85, -111, 0, 0, 0, 0, -1, -1, -1, -82, 0, 0, 0, -1, 68, 68, -120, -1, 68, 85, -69, -1, 51, 85, -86, -1, 51, 68, -86, -1, 51, 85, -52, -1, 102, 102, -52, -1, -120, -120, -69, -1, 85, 85, -103, -1, 85, 85, -120, -1, 85, 85, -103, -1, 85, 85, -120, -1, 85, 85, -103, -1, 102, 102, -86, -1, 85, 102, -86, -1, 51, 51, -120, -1, 17, 51, -69, -1, 51, 85, -18, -1, 34, 51, -69, -1, 34, 51, -86, -1, 17, 17, 34, 49, 0, 0, 0, 0, -1, -1, -1, 69, 0, 0, 0, -1, 17, 17, 17, -1, 68, 102, -52, -1, 51, 68, -103, -1, 51, 68, -86, -1, 34, 68, -86, -1, 68, 85, -52, -1, -52, -69, -18, -1, -69, -69, -35, -1, -120, -120, -86, -1, 102, 102, -103, -1, -120, -120, -86, -1, -86, -86, -69, -1, -120, -120, -69, -1, 0, 17, -103, -1, 17, 34, -86, -1, 51, 102, -18, -1, 34, 68, -52, -1, 34, 68, -35, -1, 51, 68, -120, -100, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -113, 0, 0, 0, -1, 51, 51, 85, -1, 68, 85, -52, -1, 51, 85, -52, -1, 85, -103, -18, -1, 68, 119, -35, -1, -103, -103, -35, -1, -86, -103, -52, -1, 119, 119, -69, -1, 102, 85, -86, -1, -103, -120, -86, -1, -86, -103, -69, -1, 68, 102, -52, -1, 34, 85, -52, -1, 34, 85, -35, -1, 34, 68, -52, -1, 17, 51, -52, -1, 34, 68, -86, -1, 0, 0, 0, 51, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 7, 0, 0, 0, -106, 0, 0, 0, -1, 51, 68, 102, -1, 68, 102, -35, -1, 85, 119, -52, -1, 102, -120, -1, -1, 102, 119, -35, -1, 102, 119, -35, -1, 51, 68, -69, -1, 51, 68, -69, -1, 68, 85, -52, -1, 85, 85, -103, -1, 119, -120, -69, -1, 102, -103, -1, -1, 68, 85, -18, -1, 17, 34, -86, -1, 34, 51, -120, -1, 17, 17, 17, 113, 0, 0, 0, 0, -86, -86, -69, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 39, 0, 0, 0, -106, 0, 0, 0, -1, 51, 68, 119, -1, 85, 102, -52, -1, 85, 85, -52, -1, 68, 85, -69, -1, 102, 102, -35, -1, 102, 119, -18, -1, 85, 102, -35, -1, 85, 102, -35, -1, 102, 102, -52, -1, 85, 85, -103, -1, 85, 85, -103, -1, 51, 68, -86, -1, 51, 68, -103, -1, 17, 17, 17, 124, 0, 0, 0, 0, -86, -103, -86, 0, -86, -86, -86, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 24, 0, 0, 0, -110, 0, 0, 0, -1, 17, 17, 34, -1, 51, 68, 119, -1, 68, 85, -69, -1, 102, 119, -18, -1, 102, -120, -18, -1, 68, 85, -52, -1, 102, 102, -52, -1, 102, 102, -52, -1, 85, 85, -103, -1, 68, 68, 119, -1, 51, 51, 68, -1, 0, 0, 0, 99, 0, 0, 0, 0, -86, -86, -69, 0, -86, -86, -69, 0, -86, -86, -69, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 69, 0, 0, 0, -82, 0, 0, 0, -1, 17, 17, 51, -1, 51, 51, 85, -1, 51, 51, 102, -1, 51, 51, 119, -1, 51, 51, 119, -1, 51, 51, 85, -1, 34, 17, 51, -1, 0, 0, 0, 113, 0, 0, 0, 8, 0, 0, 0, 0, -103, -103, -86, 0, -86, -86, -69, 0, -86, -86, -69, 0, -86, -86, -69, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 60, 0, 0, 0, 110, 0, 0, 0, -113, 0, 0, 0, -98, 0, 0, 0, -104, 0, 0, 0, -127, 0, 0, 0, 86, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1};
	}

	public void onCast() {
		spell.swapPosition(spell.getConcentration()-1);
	}

	public void onCreate() {
		spell.setId(2);
		spell.setName("Reflexion Topaz");
		spell.setDescription("Swaps this stone with the stone on position equal to the energy amount this stone has.");
		spell.setColor(SpellProxy.COLOR_BLUE);
		spell.setCost(2);

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
