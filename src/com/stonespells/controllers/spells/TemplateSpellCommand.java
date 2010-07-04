package com.stonespells.controllers.spells;

import com.stonespells.models.gameboard.PlayerProxy;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.gameboard.communication.PlayContextProxy;

public class TemplateSpellCommand extends SpellCommand implements ISpellCommand {
	
	public byte[] getImageBytes() {
		return new byte[] { 0, 0, 0, 22, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 1, -6, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 66, 0, 0, 0, -102, 0, 0, 0, -50, 0, 0, 0, -24, 0, 0, 0, -26, 0, 0, 0, -58, 0, 0, 0, -114, 0, 0, 0, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 79, 0, 0, 0, -72, 0, 0, 0, -1, 34, 17, 17, -1, 119, 85, 68, -1, -69, -120, 102, -1, -35, -86, -120, -1, -35, -86, -120, -1, -69, 119, 102, -1, 119, 68, 51, -1, 34, 17, 0, -98, 0, 0, 0, 53, 0, 0, 0, 0, -103, 85, 51, 0, -120, 68, 34, 0, -120, 68, 34, 0, -120, 68, 34, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -123, 0, 0, 0, -1, 17, 17, 0, -1, -103, 102, 68, -1, -1, -86, -120, -1, -1, -69, -103, -1, -1, -52, -103, -1, -1, -52, -86, -1, -1, -52, -86, -1, -1, -69, -103, -1, -1, -69, -103, -1, -1, -86, 119, -1, 119, 68, 51, -1, 0, 0, 0, 111, 0, 0, 0, 0, -120, 68, 34, 0, -120, 68, 34, 0, -120, 68, 34, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -125, 0, 0, 0, -1, 34, 17, 17, -1, -35, -120, 85, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -69, 119, -1, -1, -69, -120, -1, -1, -69, -120, -1, -1, -69, -120, -1, -1, -69, -120, -1, -1, -69, -120, -1, -1, -69, -120, -1, -1, -86, 119, -1, -69, 102, 68, -1, 17, 0, 0, 116, 0, 0, 0, 0, -120, 68, 34, 0, -120, 68, 34, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 79, 0, 0, 0, -1, 17, 0, 0, -1, -52, 119, 68, -1, -1, -103, 102, -1, -1, -86, 102, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -69, -120, -1, -1, -69, -120, -1, -1, -69, -120, -1, -1, -69, -120, -1, -1, -86, -120, -1, -1, -86, 119, -1, -1, -103, 102, -1, -69, 102, 51, -1, 17, 0, 0, 82, 0, 0, 0, 0, -120, 68, 34, 0, -1, -1, -1, 0, -1, -1, -1, 1, 0, 0, 0, -1, 0, 0, 0, -1, -103, 85, 51, -1, -1, -120, 85, -1, -1, -103, 85, -1, -1, -103, 102, -1, -1, -86, 102, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, -120, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -103, 102, -1, -1, -103, 85, -1, -103, 68, 34, -1, 0, 0, 0, 1, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 90, 0, 0, 0, -1, 51, 17, 17, -1, -18, -120, 68, -1, -1, -103, 85, -1, -1, -103, 85, -1, -1, -103, 85, -1, -1, -103, 102, -1, -1, -103, 102, -1, -1, -103, 102, -1, -1, -86, 102, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -103, 102, -1, -1, -103, 102, -1, -18, -120, 68, -1, 51, 17, 17, 118, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, -61, 0, 0, 0, -1, -103, 68, 34, -1, -1, -120, 85, -1, -1, -103, 102, -1, -1, -120, 68, -1, -1, -103, 85, -1, -1, -103, 85, -1, -1, -86, 119, -1, -1, -52, -86, -1, -1, -35, -69, -1, -1, -35, -69, -1, -1, -35, -69, -1, -1, -52, -103, -1, -1, -86, 119, -1, -1, -103, 102, -1, -1, -103, 102, -1, -1, -103, 102, -1, -1, -103, 85, -1, -69, 85, 34, -1, 0, 0, 0, 13, 0, 0, 0, 40, 0, 0, 0, -1, 17, 0, 0, -1, -35, 102, 51, -1, -1, -120, 85, -1, -1, -103, 85, -1, -1, -120, 68, -1, -1, -103, 85, -1, -1, -35, -69, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -52, -86, -1, -1, -103, 102, -1, -1, -103, 85, -1, -1, -103, 102, -1, -35, 119, 51, -1, 51, 17, 0, 90, 0, 0, 0, 90, 0, 0, 0, -1, 51, 17, 0, -1, -18, 102, 34, -1, -1, -120, 85, -1, -1, -120, 85, -1, -1, 119, 51, -1, -1, -86, 102, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -35, -1, -1, -18, -35, -1, -1, -18, -52, -1, -1, -18, -35, -1, -1, -1, -18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -86, 119, -1, -1, -120, 85, -1, -1, -103, 102, -1, -18, 119, 68, -1, -120, 51, 17, -76, 0, 0, 0, 119, 0, 0, 0, -1, 85, 34, 17, -1, -18, 102, 34, -1, -1, -120, 68, -1, -1, -103, 102, -1, -1, 119, 68, -1, -1, -120, 68, -1, -1, -103, 102, -1, -1, -86, 102, -1, -1, -86, 102, -1, -1, -86, 102, -1, -1, -86, 102, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, 119, -1, -1, -86, -120, -1, -1, -103, 102, -1, -1, -120, 85, -1, -1, -103, 102, -1, -18, 119, 68, -1, -86, 85, 34, -28, 0, 0, 0, -126, 0, 0, 0, -1, 85, 34, 17, -1, -18, 102, 34, -1, -18, 119, 51, -1, -1, -103, 102, -1, -1, -120, 68, -1, -1, 119, 51, -1, -1, 119, 51, -1, -1, 119, 68, -1, -1, -120, 68, -1, -1, -120, 68, -1, -1, -120, 85, -1, -1, -120, 85, -1, -1, -103, 85, -1, -1, -120, 85, -1, -1, -120, 85, -1, -1, -120, 85, -1, -18, -120, 85, -1, -1, -103, 102, -1, -35, 119, 51, -1, -52, 85, 34, -9, 0, 0, 0, 124, 0, 0, 0, -1, 85, 34, 0, -1, -18, 85, 17, -1, -18, 102, 34, -1, -1, -120, 68, -1, -1, -120, 85, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 51, -1, -1, 119, 68, -1, -1, -120, 68, -1, -1, -120, 68, -1, -1, -120, 85, -1, -1, -120, 85, -1, -1, -120, 85, -1, -1, -120, 85, -1, -18, -120, 68, -1, -1, -103, 102, -1, -1, -103, 102, -1, -35, 102, 51, -1, -52, 85, 34, -1, 0, 0, 0, 101, 0, 0, 0, -1, 68, 17, 0, -1, -35, 85, 17, -1, -18, 102, 17, -1, -18, 102, 34, -1, -1, -120, 85, -1, -18, 119, 68, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 68, -1, -18, -120, 68, -1, -18, -120, 68, -1, -18, -120, 68, -1, -18, -120, 68, -1, -18, -120, 85, -1, -1, -103, 102, -1, -18, -120, 68, -1, -35, 102, 34, -1, -52, 85, 34, -1, 0, 0, 0, 68, 0, 0, 0, -1, 34, 17, 0, -1, -35, 68, 0, -1, -35, 85, 17, -1, -18, 85, 17, -1, -18, 102, 34, -1, -18, 119, 68, -1, -18, 119, 51, -1, -18, 102, 34, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 68, -1, -18, 119, 68, -1, -18, -120, 68, -1, -18, -120, 85, -1, -18, -120, 85, -1, -35, 102, 51, -1, -35, 102, 34, -1, -52, 85, 17, -3, 0, 0, 0, 14, 0, 0, 0, -1, 0, 0, 0, -1, -69, 51, 0, -1, -35, 85, 0, -1, -35, 85, 0, -1, -35, 85, 0, -1, -18, 85, 17, -1, -18, 102, 34, -1, -18, 102, 34, -1, -18, 102, 34, -1, -18, 102, 34, -1, -18, 102, 51, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 51, -1, -18, 119, 68, -1, -18, 119, 68, -1, -35, 102, 51, -1, -35, 102, 34, -1, -52, 85, 34, -1, -69, 68, 17, -15, 0, 0, 0, 0, -1, -1, -1, -109, 0, 0, 0, -1, 102, 34, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -35, 85, 0, -1, -35, 85, 0, -1, -35, 85, 0, -1, -35, 85, 17, -1, -35, 102, 17, -1, -35, 102, 34, -1, -35, 102, 34, -1, -35, 102, 34, -1, -35, 102, 51, -1, -35, 119, 51, -1, -35, 102, 51, -1, -35, 102, 34, -1, -35, 102, 34, -1, -52, 85, 34, -1, -52, 85, 17, -1, -103, 51, 0, -44, 0, 0, 0, 0, -1, -1, -1, 42, 0, 0, 0, -1, 17, 0, 0, -1, -69, 51, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -35, 85, 0, -1, -35, 85, 0, -1, -35, 85, 0, -1, -35, 85, 17, -1, -35, 85, 17, -1, -35, 102, 17, -1, -35, 102, 34, -1, -35, 102, 34, -1, -35, 102, 34, -1, -35, 102, 34, -1, -52, 85, 17, -1, -52, 85, 17, -1, -52, 68, 0, -1, 68, 17, 0, 116, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, -123, 0, 0, 0, -1, 68, 17, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -35, 85, 0, -1, -35, 85, 0, -1, -35, 85, 0, -1, -35, 85, 17, -1, -35, 85, 17, -1, -52, 85, 17, -1, -52, 85, 17, -1, -52, 85, 17, -1, -52, 68, 0, -1, -103, 51, 0, -1, 0, 0, 0, 11, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, -106, 0, 0, 0, -1, 85, 17, 0, -1, -35, 68, 0, -1, -35, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 85, 0, -1, -52, 85, 0, -1, -52, 85, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -86, 51, 0, -1, 17, 0, 0, 103, 0, 0, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 25, 0, 0, 0, -106, 0, 0, 0, -1, 51, 17, 0, -1, -69, 51, 0, -1, -35, 68, 0, -1, -52, 51, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -52, 68, 0, -1, -120, 51, 0, -1, 17, 0, 0, 110, 0, 0, 0, 0, -120, 34, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 121, 0, 0, 0, -1, 17, 0, 0, -1, 85, 17, 0, -1, -86, 51, 0, -1, -69, 51, 0, -1, -69, 51, 0, -1, -69, 51, 0, -1, -69, 51, 0, -1, -69, 51, 0, -1, -69, 51, 0, -1, -120, 51, 0, -1, 51, 17, 0, -74, 0, 0, 0, 77, 0, 0, 0, 0, -120, 34, 0, 0, -120, 34, 0, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, -1, -1, -1, 0, 0, 0, 0, 23, 0, 0, 0, 124, 0, 0, 0, -56, 0, 0, 0, -21, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -19, 0, 0, 0, -26, 0, 0, 0, -69, 0, 0, 0, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1 };
	}
	
	public void onCreate() {
		spell.setId(1);
		spell.setName("Spell vermelha bonita");
		spell.setDescription("O oponente leva 1 de dano.");
		spell.setColor(SpellProxy.COLOR_RED);
		spell.setCost(2);
	}

	public void onCast() {
		PlayContextProxy playContext = this.getPlayContext();
		PlayerProxy opponent = playContext.getOpponent();
		opponent.setLife( opponent.getLife() - 1 );
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