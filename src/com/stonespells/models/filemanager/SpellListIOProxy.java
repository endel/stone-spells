package com.stonespells.models.filemanager;

import java.util.Random;

import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

import com.stonespells.controllers.spells.eddition1.Blue1Spell;
import com.stonespells.controllers.spells.eddition1.Green1Spell;
import com.stonespells.controllers.spells.eddition1.Green2Spell;
import com.stonespells.controllers.spells.eddition1.Red1Spell;
import com.stonespells.controllers.spells.eddition1.Red2Spell;
import com.stonespells.controllers.spells.eddition1.Red3Spell;
import com.stonespells.controllers.spells.eddition1.White1Spell;
import com.stonespells.controllers.spells.eddition1.White2Spell;
import com.stonespells.controllers.spells.eddition1.Yellow1Spell;
import com.stonespells.controllers.spells.eddition1.Yellow4Spell;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;

public class SpellListIOProxy extends Proxy implements IProxy {
	
	public static final String NAME = "SpellListFileProxy";
	public static final String PLAYER_HAND = "hand";
	public static final String ENEMY_HAND = "enemyHand";
	
	SpellListProxy spellList;
	
	public SpellListIOProxy() {
		super(NAME, new SpellListIOVO());
		this.spellList = (SpellListProxy) facade.retrieveProxy(SpellListProxy.NAME);
	}
	
	public void dummyCreate() throws Exception {
		this.write(PLAYER_HAND, this.spellList.toByteArray());
	}
	
	public void write(String recordStoreName, byte data[]) throws Exception {
		RecordStore rs = RecordStore.openRecordStore(recordStoreName, true);
		this.clearRecordStore(rs);
		
		rs.addRecord(data, 0, data.length);
	}
	
	private void clearRecordStore(RecordStore rs) throws InvalidRecordIDException, RecordStoreException {
		// clear all old records
		RecordEnumeration re = rs.enumerateRecords(null, null, false);
		while (re.hasNextElement()) {
			rs.deleteRecord(re.nextRecordId());
		}
	}
	
	public SpellListProxy read() {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		spellList.create();
		
		Random random = new Random();
		random.setSeed( System.currentTimeMillis() );
		
		/*for (int i=0;i<9;i++) {
			spell.create( new TemplateSpellCommand() );
			spell.setPosition(i);
			spellList.addSpellAt(spell, i);
		}*/
		
		int i=0;
		spell.create( new Red1Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Green1Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Blue1Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Red2Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new White1Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Red3Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new White2Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Yellow1Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		// spell.create( new Green2Spell() );
		spell.create( new Yellow4Spell() );
		spell.setPosition(i);
		spellList.addSpellAt(spell, i);
		i++;
		
		
		return spellList;
	}
	
	public SpellListProxy getSpellList(String recordStoreName) {
		byte[] byteArray = null;
		try {
			RecordStore rs = RecordStore.openRecordStore(recordStoreName, false);
			byteArray = rs.getRecord( rs.getNextRecordID() );
		} catch (Exception e) {
			System.out.println("Erro ao ler RecordStore: " + recordStoreName);
			e.printStackTrace();
		}
		
		SpellListProxy spellList = (SpellListProxy) facade.retrieveProxy(SpellListProxy.NAME);
		spellList.fromByteArray(byteArray);
		return spellList;
	}
	
	public SpellListProxy getList() {
		return spellList;
	}
	
}
