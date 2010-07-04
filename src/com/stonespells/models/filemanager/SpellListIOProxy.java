package com.stonespells.models.filemanager;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

import com.stonespells.controllers.spells.TemplateSpellCommand;
import com.stonespells.controllers.spells.eddition1.*;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellListVO;
import com.stonespells.models.gameboard.SpellProxy;
import com.stonespells.models.gameboard.SpellVO;

import java.util.Random;

import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

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
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Green1Spell() );
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Blue1Spell() );
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Red2Spell() );
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new White1Spell() );
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Red3Spell() );
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new White2Spell() );
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Yellow1Spell() );
		spellList.addSpellAt(spell, i);
		i++;
		
		spell.create( new Green2Spell() );
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
