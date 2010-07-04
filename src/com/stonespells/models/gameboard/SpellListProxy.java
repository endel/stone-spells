package com.stonespells.models.gameboard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

import com.stonespells.core.Serializable;

public class SpellListProxy extends Proxy implements IProxy, Serializable {
	
	public static final String NAME = "SpellListProxy";
	
	public SpellListProxy() {
		super(NAME, null);
	}
	
	public void create() {
		SpellListVO spellList = new SpellListVO();
		spellList.spells = new SpellVO[ 9 ];
		this.setData(spellList);
	}
	
	public void addSpellAt(SpellProxy spell, int i) {
		spell.setPosition(i);
		((SpellListVO) this.data).spells[i] = (SpellVO) spell.getData();
	}
	
	
	public SpellProxy getSpellAt(int i) {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		spell.setData(((SpellListVO) this.data).spells[i]);
		return spell;
	}
	
	public boolean hasSpellSelected() {
		boolean hasSelected = false;
		for (int i=0;i<9;i++) {
			if (((SpellListVO) this.data).spells[i].selected) {
				hasSelected = true;
				break;
			}
		}
		return hasSelected;
	}
	
	public int getQty() {
		return ((SpellListVO) this.data).spells.length;
	}
	
	public void castAllSelected() {
		for (int i=0;i<this.getQty();i++) {
			SpellProxy spell = this.getSpellAt(i);
			
			if (spell.isSelected()) {
				spell.cast();
			}
		}
	}
	
	public void dispatchAllEvents(String eventType) {
		for (int i=0;i<this.getQty();i++) {
			SpellProxy spell = this.getSpellAt(i);
			spell.dispatchEvent(eventType);
		}
	}

	public void fromByteArray(byte[] bytes) {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(bais);
		try {
			this.readFromStream(dis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readFromStream(DataInputStream dis) throws Exception {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		int length = dis.readInt();
		
		for (int i=0;i<length;i++) {
			spell.readFromStream( dis );
			this.addSpellAt( spell, spell.getPosition() );
		}
	}

	public byte[] toByteArray() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		try {
			this.writeToStream(dos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os.toByteArray();
	}

	public void writeToStream(DataOutputStream dos) throws Exception {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		int length = ((SpellListVO) this.data).spells.length;
		
		dos.writeInt(length);
		for (int i=0;i<length;i++) {
			spell.writeToStream(dos);
		}
	}
	
}
