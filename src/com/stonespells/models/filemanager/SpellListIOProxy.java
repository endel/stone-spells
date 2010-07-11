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
import com.stonespells.controllers.spells.eddition1.Red1Spell;
import com.stonespells.controllers.spells.eddition1.Red2Spell;
import com.stonespells.controllers.spells.eddition1.Red3Spell;
import com.stonespells.controllers.spells.eddition1.White1Spell;
import com.stonespells.controllers.spells.eddition1.White2Spell;
import com.stonespells.controllers.spells.eddition1.Yellow1Spell;
import com.stonespells.controllers.spells.eddition1.Yellow4Spell;
import com.stonespells.core.Logger;
import com.stonespells.models.gameboard.SpellListProxy;
import com.stonespells.models.gameboard.SpellProxy;

/**
 * Classe que trata os dados que formam a lista de feitiços
 * do jogador. 
 */
public class SpellListIOProxy extends Proxy implements IProxy {
	
	public static final String NAME = "SpellListFileProxy";
	public static final String PLAYER_HAND = "hand";
	public static final String ENEMY_HAND = "enemyHand";
	
	SpellListProxy spellList;
	
	/**
	 * Método que instancia a classe e aloca a lista de feitiços a ser tratada.
	 */
	public SpellListIOProxy() {
		super(NAME, new SpellListIOVO());
		this.spellList = (SpellListProxy) facade.retrieveProxy(SpellListProxy.NAME);
	}
	
	/**
	 * Método que converte a lista de feitiços do jogador para um array de bytes.
	 */
	public void dummyCreate() throws Exception {
		this.write(PLAYER_HAND, this.spellList.toByteArray());
	}
	
	/**
	 * Método que faz a escrita dos dados da lista de feitiços do jogador em uma
	 * record store.
	 * @param recordStoreName O nome da record store a ser utilizada.
	 * @param data Os dados a serem escritos na record store.
	 * @throws Exception
	 */
	public void write(String recordStoreName, byte data[]) throws Exception {
		RecordStore rs = RecordStore.openRecordStore(recordStoreName, true);
		this.clearRecordStore(rs);
		
		rs.addRecord(data, 0, data.length);
	}
	
	/**
	 * Método que limpa os registros antigos da record store.
	 * @param rs A record store a ser tratada.
	 */
	private void clearRecordStore(RecordStore rs) throws InvalidRecordIDException, RecordStoreException {
		// clear all old records
		RecordEnumeration re = rs.enumerateRecords(null, null, false);
		while (re.hasNextElement()) {
			rs.deleteRecord(re.nextRecordId());
		}
	}
	
	/**
	 * Método que obtém uma lista de feitiços e faz a alocação de feitiços dentro
	 * desta lista.
	 * @return A lista de feitiços onde os feitiços foram salvos.
	 */
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
	
	/**
	 * Método que obtém uma lista de feitiços, lendo um array de bytes de uma
	 * record store.
	 * @param recordStoreName A record store onde está o array de bytes a ser lido.
	 * @return A lista de feitiços onde fois alvo o array de bytes.
	 */
	public SpellListProxy getSpellList(String recordStoreName) {
		byte[] byteArray = null;
		try {
			RecordStore rs = RecordStore.openRecordStore(recordStoreName, false);
			byteArray = rs.getRecord( rs.getNextRecordID() );
		} catch (Exception e) {
			Logger.instance.println("Erro ao ler RecordStore: " + recordStoreName);
			e.printStackTrace();
		}
		
		SpellListProxy spellList = (SpellListProxy) facade.retrieveProxy(SpellListProxy.NAME);
		spellList.fromByteArray(byteArray);
		return spellList;
	}
	
	/**
	 * Retorna uma lista de feitiços.
	 */
	public SpellListProxy getList() {
		return spellList;
	}
	
}
