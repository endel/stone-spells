package com.stonespells.models.gameboard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.microedition.lcdui.Image;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.observer.Notification;
import org.puremvc.java.patterns.proxy.Proxy;

import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.core.ImageLibrary;
import com.stonespells.core.Serializable;

/**
 * Proxy para manipulação dos dados e eventos das spells.
 * 
 * @author Endel
 * 
 */
public class SpellProxy extends Proxy implements IProxy, ISpell, Serializable {

	public static final String NAME = "SpellProxy";

	// Spell events
	/**
	 * O evento de ON_CREATE é disparado em todas as spells ao início de cada
	 * partida.
	 */
	public static final String ON_CREATE = "create";

	/**
	 * O evento de ON_TURN_BEGIN é disparado ao início do turno de cada jogador.
	 * Somente nas spells daquele jogador.
	 */
	public static final String ON_TURN_BEGIN = "turnBegin";

	/**
	 * O evento de ON_TURN_BEGIN é disparado ao final do turno de cada jogador.
	 * Somente nas spells daquele jogador.
	 */
	public static final String ON_TURN_END = "turnEnd";

	/**
	 * O evento de ON_ENERGIZE é disparado na spell que está sendo energizada.
	 */
	public static final String ON_ENERGIZE = "energize";

	/**
	 * O evento de ON_SWAP_POSITION é disparado em cada pedra que tiver sua
	 * posição alterada durante o jogo.
	 */
	public static final String ON_SWAP_POSITION = "swap";

	/**
	 * O evento de ON_CAST é disparado quando o jogador energizou uma spell
	 * suficientemente para selecioná-la para cast.
	 */
	public static final String ON_CAST = "cast";

	// Spell colors
	public static final int COLOR_RED = 0;
	public static final int COLOR_BLUE = 1;
	public static final int COLOR_WHITE = 2;
	public static final int COLOR_GOLD = 3;
	public static final int COLOR_GREEN = 4;

	public SpellProxy() {
		super(NAME, null);
	}

	/**
	 * Cria um novo objeto {@link SpellVO} à ser manipulado.
	 * 
	 * @deprecated Todas as spells devem ter um commandListener que possui o
	 *             tratamentos de eventos.
	 */
	public void create() {
		this.setData(new SpellVO());
	}

	/**
	 * Cria um novo objeto {@link SpellVO} à ser manipulado.
	 * 
	 * @param commandListener
	 */
	public void create(ICommand commandListener) {
		this.setData(new SpellVO());
		((SpellVO) this.data).commandListener = commandListener;
		dispatchEvent(ON_CREATE);
	}

	public int getId() {
		return ((SpellVO) this.data).id;
	}

	public String getName() {
		return ((SpellVO) this.data).name;
	}

	public String getDescription() {
		return ((SpellVO) this.data).description;
	}

	public int getPosition() {
		return ((SpellVO) this.data).position;
	}

	public int getCost() {
		return ((SpellVO) this.data).cost;
	}

	public int getColor() {
		return ((SpellVO) this.data).color;
	}

	public Image getImage() {
		return ((SpellVO) this.data).image;
	}

	public int getConcentration() {
		return ((SpellVO) this.data).concentration;
	}

	public boolean canCast() {
		return this.getConcentration() >= this.getCost();
	}

	public boolean isLocked() {
		return ((SpellVO) this.data).locked;
	}

	public boolean isSelected() {
		return ((SpellVO) this.data).selected;
	}

	public ICommand getCommandListener() {
		return ((SpellVO) this.data).commandListener;
	}

	public void setId(int id) {
		((SpellVO) this.data).id = id;
	}

	public void setName(String name) {
		((SpellVO) this.data).name = name;
	}

	public void setDescription(String description) {
		((SpellVO) this.data).description = description;
	}

	public void setPosition(int pos) {
		((SpellVO) this.data).position = pos;
	}

	public void setCost(int cost) {
		((SpellVO) this.data).cost = cost;
	}

	public void setColor(int color) {
		((SpellVO) this.data).color = color;
	}

	public void setImage(String path) {
		try {
			((SpellVO) this.data).image = Image.createImage(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setImage(Image image) {
		((SpellVO) this.data).image = image;
	}

	public void setLocked(boolean locked) {
		((SpellVO) this.data).locked = locked;
	}

	public void setConcentration(int c) {
		((SpellVO) this.data).concentration = c;
	}

	public void addConcentration(int i) {
		int value = this.getConcentration() + i;
		this.setConcentration((value < 0) ? 0 : value);
		dispatchEvent(ON_ENERGIZE);
	}

	public void setSelected(boolean bool) {
		((SpellVO) this.data).selected = bool;
	}

	public void setCasting(boolean bool) {
		((SpellVO) this.data).casting = bool;
	}

	public boolean isCasting() {
		return ((SpellVO) this.data).casting;
	}

	public void swapSelected() {
		((SpellVO) this.data).selected = !this.isSelected();
	}

	public void swapPosition(int pos) {
		SpellVO self = (SpellVO) this.data;

		SpellListProxy spellList = (SpellListProxy) facade
				.retrieveProxy(SpellListProxy.NAME);
		SpellVO other = (SpellVO) spellList.getSpellAt(pos).getData();

		int selfPosition = self.position;
		self.position = other.position;
		other.position = selfPosition;

		this.setData(self);
		dispatchEvent(ON_SWAP_POSITION);
	}

	public void dispatchEvent(String eventType) {
		ICommand listener = this.getCommandListener();
		listener.execute(new Notification(eventType, this.getData(), null));
	}

	public void cast() {
		this.setSelected(false);
		this.setCasting(true);
		dispatchEvent(ON_CAST);
		this.addConcentration(-this.getCost());
	}

	public void fromByteArray(byte[] bytes) {
		ByteArrayInputStream is = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(is);
		try {
			this.readFromStream(dis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readFromStream(DataInputStream dis) throws Exception {
		this.setId(dis.readInt());
		this.setName(dis.readUTF());
		this.setDescription(dis.readUTF());
		this.setColor(dis.readInt());
		this.setImage(ImageLibrary.fromStream(dis));
		this.setPosition(dis.readInt());
		this.setCost(dis.readInt());
		this.setConcentration(dis.readInt());
		this.setLocked(dis.readBoolean());
		this.setSelected(dis.readBoolean());
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
		dos.writeInt(this.getId());
		dos.writeUTF(this.getName());
		dos.writeUTF(this.getDescription());
		dos.writeInt(this.getColor());
		dos.write(ImageLibrary.toByteArray(this.getImage()));
		dos.writeInt(this.getPosition());
		dos.writeInt(this.getCost());
		dos.writeInt(this.getConcentration());
		dos.writeBoolean(this.isLocked());
		dos.writeBoolean(this.isSelected());
	}
}
