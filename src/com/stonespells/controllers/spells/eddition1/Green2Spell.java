package com.stonespells.controllers.spells.eddition1;

import java.util.Random;

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;

public class Green2Spell extends SpellCommand implements ISpellCommand {

	public byte[] getImageBytes() {
		return new byte[] {0, 0, 0, 17, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 1, -121, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 89, 0, 0, 0, -111, 0, 0, 0, -80, 0, 0, 0, -105, 0, 0, 0, 104, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 117, 0, 0, 0, -1, 0, 0, 0, -1, 34, 34, 17, -1, 68, 85, 34, -1, 102, 119, 68, -1, 85, 102, 51, -1, 51, 51, 17, -1, 0, 0, 0, 127, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 6, 0, 0, 0, -106, 0, 0, 0, -1, 51, 51, 34, -1, -120, -103, 68, -1, 102, -120, 34, -1, 85, 102, 34, -1, 119, -103, 85, -1, -52, -18, -103, -1, 102, 119, 51, -1, 85, 102, 51, -1, 51, 51, 34, -106, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, -108, 0, 0, 0, -1, 34, 51, 34, -1, 68, 102, 17, -1, 119, -103, 51, -1, 119, -120, 51, -1, 85, 102, 34, -1, 85, 119, 34, -1, 102, -120, 51, -1, 85, 102, 34, -1, 85, 119, 34, -1, 102, 119, 51, -1, 51, 51, 34, -106, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 52, 0, 0, 0, -1, 17, 17, 17, -1, 85, 102, 34, -1, 34, 68, 0, -1, 68, 85, 17, -1, -120, -103, 102, -1, -103, -86, 119, -1, 102, 119, 51, -1, -120, -103, 102, -1, -120, -120, 85, -1, 34, 68, 0, -1, 51, 85, 0, -1, 102, 119, 68, -1, 34, 34, 17, 105, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -99, 0, 0, 0, -1, 68, 85, 51, -1, 102, 119, 51, -1, 68, 102, 17, -1, 85, 119, 51, -1, -103, -86, 119, -1, -103, -103, 102, -1, -120, -103, 102, -1, -103, -103, 102, -1, -120, -120, 85, -1, 102, 119, 68, -1, -103, -86, 102, -1, -120, -103, 85, -1, 119, -120, 85, -1, 0, 0, 0, 2, 0, 0, 0, 13, 0, 0, 0, -1, 0, 0, 0, -1, 102, 119, 51, -1, 119, -120, 68, -1, -86, -52, 102, -1, -120, -103, 68, -1, 119, -120, 85, -1, -120, -103, 102, -1, -120, -103, 102, -1, -120, -103, 102, -1, -120, -103, 85, -1, -86, -69, 119, -1, -52, -35, -103, -1, 119, -103, 68, -1, -120, -103, 68, -1, 17, 17, 17, 52, 0, 0, 0, 60, 0, 0, 0, -1, 34, 34, 17, -1, 102, 119, 68, -1, -120, -86, 102, -1, 119, -120, 68, -1, 85, 102, 34, -1, 119, -120, 68, -1, -120, -103, 102, -1, -120, -103, 102, -1, -120, -103, 85, -1, 119, -103, 85, -1, -120, -103, 85, -1, -86, -69, 119, -1, -103, -86, 85, -1, -103, -86, 85, -1, 51, 68, 34, 105, 0, 0, 0, 96, 0, 0, 0, -1, 51, 68, 34, -1, 102, 119, 68, -1, 119, -120, 68, -1, 68, 85, 34, -1, 68, 102, 34, -1, 51, 85, 34, -1, 102, -120, 68, -1, -120, -103, 102, -1, -103, -86, 85, -1, -103, -86, 85, -1, 51, 68, 17, -1, 119, 119, 68, -1, 119, -103, 68, -1, -120, -103, 85, -1, 85, 85, 51, -117, 0, 0, 0, 114, 0, 0, 0, -1, 68, 68, 51, -1, -103, -69, 102, -1, 68, 85, 17, -1, 85, 102, 34, -1, 68, 102, 34, -1, 51, 85, 17, -1, 102, -120, 51, -1, -103, -86, 102, -1, -69, -52, -120, -1, -1, -1, -86, -1, -86, -69, 119, -1, -86, -69, 119, -1, 102, 119, 51, -1, 102, -120, 51, -1, 85, 102, 68, -111, 0, 0, 0, 99, 0, 0, 0, -1, 51, 68, 34, -1, -103, -69, 102, -1, -69, -35, 119, -1, -18, -1, -69, -1, -52, -35, -103, -1, -18, -1, -52, -1, -69, -35, 119, -1, -120, -86, 85, -1, -35, -18, -103, -1, -1, -1, -35, -1, -1, -1, -35, -1, -1, -1, -35, -1, -35, -18, -120, -1, -69, -35, 119, -1, 68, 68, 51, 111, 0, 0, 0, 65, 0, 0, 0, -1, 34, 34, 17, -1, -86, -69, 119, -1, -86, -52, 102, -1, -1, -1, -18, -1, -18, -1, -52, -1, -1, -1, -69, -1, -120, -103, 68, -1, 119, -120, 68, -1, -86, -52, 102, -1, -120, -103, 85, -1, -52, -52, -103, -1, -52, -35, -103, -1, -52, -35, 119, -1, -103, -86, 102, -1, 34, 34, 17, 56, 0, 0, 0, 22, 0, 0, 0, -1, 0, 0, 0, -1, -86, -86, 119, -1, -103, -86, 85, -1, -18, -18, -35, -1, -18, -18, -52, -1, 119, -120, 68, -1, 102, 119, 51, -1, 102, 119, 51, -1, 85, 119, 34, -1, 102, -120, 51, -1, 119, -120, 68, -1, 119, -120, 68, -1, 102, 119, 51, -1, 119, -120, 68, -1, 0, 0, 0, 11, 0, 0, 0, 0, -1, -1, -1, -75, 0, 0, 0, -1, 102, 119, 68, -1, 119, -120, 68, -1, -86, -86, -120, -1, -1, -1, -18, -1, -120, -103, 85, -1, 102, 119, 34, -1, -120, -120, 85, -1, 68, 102, 17, -1, 85, 119, 51, -1, 119, -120, 85, -1, 102, 119, 68, -1, 85, 102, 51, -1, 68, 85, 51, -88, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 79, 0, 0, 0, -1, 34, 34, 34, -1, 102, 119, 68, -1, 85, 102, 34, -1, -69, -52, -103, -1, -35, -35, -52, -1, 85, 102, 34, -1, 119, -120, 68, -1, 51, 68, 17, -1, 85, 102, 51, -1, 85, 102, 51, -1, 85, 102, 34, -1, 85, 102, 34, -1, 17, 34, 17, 73, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 3, 0, 0, 0, -1, 0, 0, 0, -1, 85, 102, 51, -1, 68, 102, 34, -1, 68, 102, 17, -1, -35, -35, -52, -1, 102, -120, 68, -1, 51, 85, 0, -1, 51, 85, 34, -1, 85, 102, 51, -1, 51, 68, 17, -1, 68, 102, 17, -1, 85, 102, 51, -1, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 90, 0, 0, 0, -1, 17, 34, 17, -1, 68, 85, 34, -1, 34, 68, 0, -1, 85, 102, 51, -1, -103, -86, -120, -1, 51, 85, 0, -1, 85, 102, 51, -1, 68, 102, 34, -1, 51, 85, 17, -1, 68, 102, 34, -1, 17, 17, 0, 91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -98, 0, 0, 0, -1, 68, 85, 34, -1, 68, 102, 17, -1, 17, 51, 0, -1, 85, 119, 68, -1, 102, 119, 68, -1, 68, 85, 34, -1, 51, 85, 17, -1, 85, 102, 34, -1, 51, 68, 34, -108, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 53, 0, 0, 0, -1, 0, 0, 0, -1, 85, 102, 34, -1, 51, 85, 0, -1, 34, 68, 0, -1, 68, 102, 34, -1, 68, 102, 34, -1, 51, 85, 17, -1, 68, 85, 34, -73, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 118, 0, 0, 0, -1, 17, 17, 17, -1, 68, 102, 34, -1, 68, 102, 17, -1, 85, 119, 34, -1, 85, 102, 34, -1, 85, 102, 51, -1, 0, 0, 0, 78, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, -115, 0, 0, 0, -1, 34, 34, 17, -1, 51, 85, 17, -1, 68, 102, 34, -1, 68, 85, 34, -1, 0, 17, 0, 113, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -125, 0, 0, 0, -1, 17, 17, 17, -1, 34, 51, 17, -1, 0, 0, 0, 95, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 46, 0, 0, 0, -127, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	}

	public void onCast() {
		
		Random random = new Random();
		random.setSeed( System.currentTimeMillis() );
		
		SpellListProxy opponentSpells = this.getPlayContext().getOpponent().getSpellList();
		for (int i=0;i<2;i++) {
			int position = random.nextInt(9);
			SpellProxy spellToCharge = opponentSpells.getSpellAt(position);
			spellToCharge.addConcentration( spellToCharge.getCost() );
		}
	}

	public void onCreate() {
		spell.setId(4);
		spell.setName("Perception Jade");
		spell.setDescription("Fully charges random two of your stones.");
		spell.setColor(SpellProxy.COLOR_GREEN);
		spell.setCost(5);
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
