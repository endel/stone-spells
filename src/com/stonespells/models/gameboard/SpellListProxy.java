package com.stonespells.models.gameboard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

import com.stonespells.core.Serializable;

/**
 * Proxy para manipulação das listas de feitiços.
 */
public class SpellListProxy extends Proxy implements IProxy, Serializable {

	public static final String NAME = "SpellListProxy";

	public SpellListProxy() {
		super(NAME, null);
	}

	/**
	 * Cria um novo objeto {@link SpellListVO} à ser manipulado.
	 */
	public void create() {
		SpellListVO spellList = new SpellListVO();
		spellList.spells = new SpellVO[9];
		this.setData(spellList);
	}
	
	/**
	 * Cria um novo objeto {@link SpellListVO} à ser manipulado com um total de qty spells.
	 */
	public void create(int qty) {
		SpellListVO spellList = new SpellListVO();
		spellList.spells = new SpellVO[qty];
		this.setData(spellList);
	}

	/**
	 * Adiciona uma spell em determinada posição da lista.
	 * 
	 * @param spell
	 * @param i
	 */
	public void addSpellAt(SpellProxy spell, int i) {
		((SpellListVO) this.data).spells[i] = (SpellVO) spell.getData();
	}

	/**
	 * Obtém uma spell em determinada posição da lista
	 * 
	 * @param i
	 * @return SpellProxy
	 * @see SpellProxy
	 */
	public SpellProxy getSpellAt(int i) {
		SpellProxy spell = (SpellProxy) facade.retrieveProxy(SpellProxy.NAME);
		SpellVO spellData = ((SpellListVO) this.data).spells[i];
		if (spellData == null)
			spellData = new SpellVO();
		spell.setData( spellData );
		return spell;
	}

	/**
	 * Verifica se existe alguma spell selecionada para cast neste turno.
	 * 
	 * @return boolean
	 */
	public boolean hasSpellSelected() {
		for (int i = 0; i < 9; i++) {
			if (((SpellListVO) this.data).spells[i].selected) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Verifica se existe alguma spell selecionada para cast neste turno.
	 * 
	 * @return boolean
	 */
	public boolean hasCastSpell() {
		for (int i = 0; i < 9; i++) {
			if (((SpellListVO) this.data).spells[i].casting) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtém o numero de spells que contém esta lista.
	 * 
	 * @return int
	 */
	public int getQty() {
		return ((SpellListVO) this.data).spells.length;
	}

	/**
	 * Dispara o onCast de todas as spells previamente selecionadas.
	 */
	public void castAllSelected() {
		for (int i = 0; i < this.getQty(); i++) {
			SpellProxy spell = this.getSpellAt(i);

			if (spell.isSelected()) {
				spell.cast();
			}
		}
	}

	/**
	 * Dispara um evento em todas as spells da lista. Utilize as constantes
	 * SpellProxy.ON_*
	 * 
	 * @see SpellProxy
	 * @param eventType
	 */
	public void dispatchAllEvents(String eventType) {
		for (int i = 0; i < this.getQty(); i++) {
			SpellProxy spell = this.getSpellAt(i);
			spell.dispatchEvent(eventType);
		}
	}

	/**
	 * Transforma esta lista de spells à partir de bytes
	 * 
	 * @param bytes
	 */
	public void fromByteArray(byte[] bytes) {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(bais);
		try {
			this.readFromStream(dis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Transforma esta lista de spells à partir de um DataInputStream
	 * 
	 */
	public void readFromStream(DataInputStream dis) throws Exception {
		int length = dis.readInt();
		
		for (int i = 0; i < length; i++) {
			SpellProxy spell = this.getSpellAt(i);
			spell.readFromStream(dis);
			this.addSpellAt(spell, i);
		}
	}

	/**
	 * Converte esta lista de spells para array
	 * 
	 */
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

	/**
	 * Escreve esta lista de spells em um DataOutputStream
	 */
	public void writeToStream(DataOutputStream dos) throws Exception {
		int length = this.getQty();

		dos.writeInt(length);
		for (int i = 0; i < length; i++) {
			this.getSpellAt(i).writeToStream(dos);
		}
	}

}
