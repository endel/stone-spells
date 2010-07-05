package com.stonespells.controllers.spells.eddition1;

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.models.gameboard.SpellProxy;

public class Green3Spell extends SpellCommand implements ISpellCommand {

	public byte[] getImageBytes() {
		return new byte[] {0, 0, 0, 22, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 1, -28, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 21, 0, 0, 0, 83, 0, 0, 0, 124, 0, 0, 0, -96, 0, 0, 0, 116, 0, 0, 0, 45, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -18, -1, -69, 33, 0, 0, 0, -1, 0, 0, 0, -1, 0, 0, 0, -1, 51, 51, 34, -1, 68, 85, 34, -1, 85, 102, 51, -1, 51, 51, 17, -1, 17, 17, 0, -1, 0, 0, 0, 123, 0, 0, 0, 18, 0, 0, 0, 0, -120, -103, 85, 0, -120, -103, 85, 0, -103, -86, 102, 0, -86, -52, 119, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 61, 0, 0, 0, -1, 17, 34, 17, -1, 102, 102, 68, -1, -120, -103, 68, -1, -120, -103, 68, -1, -103, -69, 85, -1, -103, -86, 85, -1, -120, -103, 68, -1, 102, -120, 51, -1, -120, -103, 85, -1, 68, 68, 34, -22, 0, 0, 0, -127, 0, 0, 0, 0, -120, -103, 85, 0, -103, -86, 102, 0, -86, -52, 119, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 14, 0, 0, 0, -1, 0, 0, 0, -1, -120, -103, 85, -1, -120, -103, 68, -1, -120, -86, 85, -1, -103, -69, 102, -1, -120, -86, 68, -1, 119, -103, 68, -1, -86, -52, 119, -1, -103, -69, 85, -1, 119, -120, 51, -1, 119, -120, 51, -1, 119, -120, 68, -1, 17, 34, 17, -106, 0, 0, 0, 0, -103, -86, 102, 0, -86, -52, 119, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -117, 0, 0, 0, -1, 68, 85, 34, -1, -120, -86, 68, -1, -120, -86, 68, -1, -52, -35, 119, -1, -103, -86, 85, -1, -1, -1, -35, -1, -18, -1, -69, -1, -18, -18, -69, -1, -35, -18, -86, -1, -120, -86, 85, -1, 119, -120, 51, -1, -120, -86, 68, -1, 119, -103, 68, -1, 17, 17, 0, -106, 0, 0, 0, 0, -86, -52, 119, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 25, 0, 0, 0, -1, 17, 17, 0, -1, -69, -52, 119, -1, -103, -69, 85, -1, -103, -69, 68, -1, -69, -52, -120, -1, 102, 119, 51, -1, -18, -18, -69, -1, -18, -18, -86, -1, -35, -18, -69, -1, -69, -52, 119, -1, 119, -103, 68, -1, 102, -120, 51, -1, 85, 119, 34, -1, -103, -86, 85, -1, -52, -35, 119, -1, 0, 0, 0, -122, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 118, 0, 0, 0, -1, 85, 102, 68, -1, -86, -52, 102, -1, -69, -35, 119, -1, -103, -69, 85, -1, -103, -69, 119, -1, -1, -1, -18, -1, -35, -18, -120, -1, -35, -18, -103, -1, -35, -18, -86, -1, -86, -52, 119, -1, 119, -120, 68, -1, 85, 119, 34, -1, 102, -120, 34, -1, 85, 119, 34, -1, -69, -35, 119, -1, -69, -52, 119, -1, 0, 0, 0, 1, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 4, 0, 0, 0, -1, 0, 0, 0, -1, 102, 119, 51, -1, 119, -103, 51, -1, -103, -69, 102, -1, -69, -35, 119, -1, -120, -103, 85, -1, 119, -103, 68, -1, -18, -1, -52, -1, -52, -18, -120, -1, -103, -69, 85, -1, 85, 119, 34, -1, 85, 119, 34, -1, -35, -35, -69, -1, -69, -52, -103, -1, -120, -86, 85, -1, 119, -120, 51, -1, -86, -69, 102, -1, 17, 17, 17, 93, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 8, 0, 0, 0, -1, 0, 0, 0, -1, 119, -120, 68, -1, -103, -69, 85, -1, -86, -52, 102, -1, 119, -120, 51, -1, 119, -103, 68, -1, 85, 102, 34, -1, -120, -86, 68, -1, -35, -18, -103, -1, -120, -86, 85, -1, -69, -52, 119, -1, -86, -52, 102, -1, -69, -52, -120, -1, -52, -52, -86, -1, 119, -103, 68, -1, -86, -69, 102, -1, -103, -86, 85, -1, 119, -120, 68, -1, 0, 0, 0, 1, 0, 0, 0, 0, -1, -1, -1, 79, 0, 0, 0, -1, 34, 34, 17, -1, 102, -120, 51, -1, -69, -35, 119, -1, -18, -1, -120, -1, -35, -18, -86, -1, 85, 102, 34, -1, 85, 119, 34, -1, 119, -103, 68, -1, -103, -69, 85, -1, -86, -69, 102, -1, -103, -69, 85, -1, 119, -103, 68, -1, 102, -120, 51, -1, -103, -86, 119, -1, 85, 102, 34, -1, 119, -120, 51, -1, 85, 85, 34, -1, 85, 102, 51, -37, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 111, 0, 0, 0, -1, 85, 85, 68, -1, -103, -86, 68, -1, 102, -120, 51, -1, -86, -52, 119, -1, -1, -1, -35, -1, -1, -1, -86, -1, -1, -1, -52, -1, -120, -103, 85, -1, 102, 119, 51, -1, 119, -120, 68, -1, -86, -52, 119, -1, -120, -86, 85, -1, 51, 85, 17, -1, 102, 119, 51, -1, -69, -52, -120, -1, -69, -52, -120, -1, 102, 102, 51, -1, -103, -86, 102, -1, 0, 0, 0, 11, 0, 0, 0, 0, -1, -1, -1, -86, 0, 0, 0, -1, 85, 102, 51, -1, -69, -52, 102, -1, -103, -86, 85, -1, -103, -86, 119, -1, -86, -69, 119, -1, -120, -86, 68, -1, -103, -69, 85, -1, 102, 119, 51, -1, -120, -103, 85, -1, 119, -103, 51, -1, 119, -103, 68, -1, -120, -86, 85, -1, 85, 119, 34, -1, -120, -86, 85, -1, -120, -86, 85, -1, -86, -69, 119, -1, 85, 102, 51, -1, 85, 102, 51, -1, 0, 0, 0, 12, 0, 0, 0, 2, 0, 0, 0, -1, 0, 0, 0, -1, 68, 85, 34, -1, -69, -52, -120, -1, -69, -35, 119, -1, -52, -35, -120, -1, -52, -35, -120, -1, -86, -52, 102, -1, -86, -69, 85, -1, -52, -35, 119, -1, -120, -86, 85, -1, -86, -52, 85, -1, 102, -120, 51, -1, -103, -69, 85, -1, 102, -120, 51, -1, -103, -86, 102, -1, -35, -18, -103, -1, -86, -69, 119, -1, 119, 119, 68, -1, 68, 68, 34, -122, 0, 0, 0, 0, -1, -1, -1, 3, 0, 0, 0, -1, 0, 0, 0, -1, -86, -69, 102, -1, -86, -69, -120, -1, -18, -1, -69, -1, -35, -18, -103, -1, -52, -35, -120, -1, -69, -52, 119, -1, -52, -18, -120, -1, -1, -1, -69, -1, -86, -69, 119, -1, -18, -1, -86, -1, -69, -35, 102, -1, -52, -18, -120, -1, -18, -1, -86, -1, -1, -1, -69, -1, -103, -86, 102, -1, -86, -86, 119, -1, -120, -103, 102, -1, 17, 17, 0, 33, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, -63, 0, 0, 0, -1, 119, -103, 85, -1, -18, -18, -69, -1, -52, -35, -103, -1, -52, -35, -120, -1, -35, -18, -86, -1, 119, -120, 68, -1, 119, -103, 68, -1, -69, -52, 102, -1, -1, -1, -18, -1, -86, -69, 102, -1, -86, -52, 85, -1, -35, -18, -69, -1, -86, -35, 119, -1, -35, -18, -103, -1, -86, -69, 102, -1, -86, -69, 119, -1, 85, 85, 51, 121, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 1, 0, 0, 0, -1, 0, 0, 0, -1, 119, -120, 68, -1, -35, -18, -103, -1, -69, -35, -120, -1, -86, -69, 102, -1, -69, -52, -120, -1, -52, -35, -103, -1, -69, -52, -103, -1, -35, -18, -86, -1, -1, -1, -18, -1, -35, -18, -103, -1, -69, -52, -120, -1, -52, -35, -120, -1, -35, -18, -103, -1, -52, -35, 119, -1, -86, -69, 102, -1, 51, 51, 34, -1, 0, 0, 0, 16, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -75, 0, 0, 0, -1, 119, -120, 85, -1, -52, -35, -120, -1, 102, -120, 51, -1, -86, -52, 102, -1, 119, -120, 68, -1, -69, -52, -120, -1, -103, -86, 85, -1, -52, -35, 119, -1, -35, -18, -86, -1, -35, -18, -86, -1, -52, -35, -120, -1, -86, -52, 119, -1, -69, -52, 119, -1, -120, -103, 102, -1, 68, 68, 51, -106, 0, 0, 0, 9, 0, 0, 0, 0, 119, -120, 85, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 125, 0, 0, 0, -1, 68, 85, 51, -1, -86, -69, 102, -1, 51, 85, 0, -1, -103, -86, 102, -1, -35, -1, -103, -1, -86, -52, 102, -1, -52, -18, -120, -1, -52, -18, 119, -1, -86, -52, 119, -1, -86, -52, 119, -1, 119, -120, 68, -1, 119, -103, 85, -1, 119, 119, 85, -1, 17, 17, 0, -1, 0, 0, 0, 12, 0, 0, 0, 0, 119, -120, 102, 0, 119, -120, 85, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 75, 0, 0, 0, -1, 34, 34, 17, -1, -103, -69, 85, -1, 85, 119, 34, -1, -18, -18, -103, -1, -69, -52, 119, -1, 102, 119, 51, -1, -86, -69, 102, -1, -103, -69, 102, -1, -69, -52, 119, -1, -52, -35, -120, -1, 85, 102, 68, -1, 34, 51, 34, -1, 0, 0, 0, 70, 0, 0, 0, 5, 0, 0, 0, 0, 119, 119, 85, 0, 119, -120, 102, 0, -120, -103, 102, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 21, 0, 0, 0, -1, 0, 0, 0, -1, 119, -103, 68, -1, -120, -103, 85, -1, -103, -103, 102, -1, -86, -86, 102, -1, 119, -120, 68, -1, -103, -86, 85, -1, -120, -86, 102, -1, 102, 102, 68, -1, 34, 34, 17, -80, 0, 0, 0, 95, 0, 0, 0, 8, 0, 0, 0, 0, 102, 119, 102, 0, 119, 119, 85, 0, -120, -120, 102, 0, 119, -120, 102, 0, 102, 119, 85, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -106, 0, 0, 0, -1, 51, 51, 34, -1, 85, 85, 51, -1, 68, 68, 34, -1, 51, 51, 34, -1, 34, 34, 17, -1, 34, 34, 17, -1, 0, 0, 0, -85, 0, 0, 0, 80, 0, 0, 0, 0, 102, 102, 102, 0, 102, 102, 85, 0, 102, 102, 85, 0, 102, 102, 85, 0, 102, 119, 102, 0, 102, 119, 85, 0, 119, -120, 85, 0, -120, -120, 102, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 8, 0, 0, 0, 113, 0, 0, 0, -97, 0, 0, 0, -118, 0, 0, 0, 110, 0, 0, 0, 80, 0, 0, 0, 71, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1};
	}

	public void onCast() {
		// TODO Auto-generated method stub

	}

	public void onCreate() {
		getSpell().setId(5);
		getSpell().setName("Heart of the forest");
		getSpell().setDescription("Turns the opponent's next attack against himself");
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
