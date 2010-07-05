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

import com.stonespells.controllers.spells.ISpellCommand;
import com.stonespells.controllers.spells.SpellCommand;
import com.stonespells.core.ResourceLibrary;
import com.stonespells.core.Serializable;

/**
 * Proxy para manipulação dos dados e eventos das spells.
 * 
 * @author Endel
 * 
 */
public class SpellProxy extends Proxy implements IProxy, Serializable {

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

	/**
	 * Obtém o id da spell.
	 * 
	 * @return int
	 */
	public int getId() {
		return ((SpellVO) this.data).id;
	}

	/**
	 * Obtém o nome da spell.
	 * 
	 * @return String
	 */
	public String getName() {
		return ((SpellVO) this.data).name;
	}

	/**
	 * Obtém a descrição da spell.
	 * 
	 * @return String
	 */
	public String getDescription() {
		return ((SpellVO) this.data).description;
	}

	/**
	 * Obtém a posição da spell no tabuleiro. De 0 à 8.
	 * 
	 * @return int
	 */
	public int getPosition() {
		return ((SpellVO) this.data).position;
	}

	/**
	 * Obtém o custo da spell.
	 * 
	 * @return int
	 */
	public int getCost() {
		return ((SpellVO) this.data).cost;
	}

	/**
	 * Obtém a cor da spell. Utilize os atributos estáticos SpellProxy.COLOR_*
	 * para comparação.
	 * 
	 * @return int
	 */
	public int getColor() {
		return ((SpellVO) this.data).color;
	}

	/**
	 * Obtém a imagem da spell.
	 * 
	 * @return Image
	 * @see Image
	 */
	public Image getImage() {
		return ((SpellVO) this.data).image;
	}

	/**
	 * Obtém os pontos de concentração da spell.
	 * 
	 * @return int
	 */
	public int getConcentration() {
		return ((SpellVO) this.data).concentration;
	}

	/**
	 * Verifica se a spell pode ser lançada. Ela só pode ser lançada se não 
	 * estiver trancada e seus pontos de concentração forem maiores ou iguais 
	 * ao custo. 
	 * 
	 * @return boolean
	 */
	public boolean canCast() {
		ISpellCommand listener = (ISpellCommand) this.getCommandListener();
		boolean allowedByParams = (listener != null) ? listener.canCast() : true;
		
		return allowedByParams && !this.isLocked() && (this.getConcentration() >= this.getCost());
	}

	/**
	 * Verifica se a spell tem sua utilização trancada. Spells trancadas não
	 * podem ser energizadas nem utilizadas.
	 * 
	 * @return boolean
	 */
	public boolean isLocked() {
		return ((SpellVO) this.data).locked;
	}

	/**
	 * Verifica se a spell está selecionada para cast.
	 * 
	 * @return boolean
	 */
	public boolean isSelected() {
		return ((SpellVO) this.data).selected;
	}

	/**
	 * Obtém o ICommand que gerencia os eventos da spell.
	 * 
	 * @return ICommand
	 * @see SpellCommand
	 */
	public ICommand getCommandListener() {
		return ((SpellVO) this.data).commandListener;
	}

	/**
	 * Define um identificador único para a spell.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		((SpellVO) this.data).id = id;
	}

	/**
	 * Define um nome para a spell.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		((SpellVO) this.data).name = name;
	}

	/**
	 * Define uma descrição para o efeito da spell.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		((SpellVO) this.data).description = description;
	}

	/**
	 * Define uma posição para a spell. Utilize somente posições de 0 à 8.
	 * 
	 * @param pos
	 */
	public void setPosition(int pos) {
		((SpellVO) this.data).position = pos;
	}

	/**
	 * Define um custo para o cast da spell. Caso tenha custo 0, você deverá
	 * tratar manualmente como será reduzido os pontos de concentração dela no
	 * método onCast
	 * 
	 * @param cost
	 */
	public void setCost(int cost) {
		((SpellVO) this.data).cost = cost;
	}

	/**
	 * Define uma cor para a spell.
	 * 
	 * @param color
	 */
	public void setColor(int color) {
		((SpellVO) this.data).color = color;
	}

	/**
	 * Define uma imagem à partir de uma url para a spell
	 * 
	 * @deprecated Cada spell deve conter um método getImageBytes(), que é
	 *             convertido para um objeto Image internamente através da
	 *             classe {@link SpellCommand}.
	 * @param path
	 */
	public void setImage(String path) {
		try {
			((SpellVO) this.data).image = Image.createImage(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Define uma imagem para a spell. Este método é chamado automaticamente
	 * através da classe {@link SpellCommand} Cada spell deve conter um método
	 * getImageBytes() que retorna os bytes da imagem.
	 * 
	 * @param image
	 */
	public void setImage(Image image) {
		((SpellVO) this.data).image = image;
	}

	/**
	 * Define se a spell pode ser utilizada ou energizada.
	 * 
	 * @param locked
	 */
	public void setLocked(boolean locked) {
		((SpellVO) this.data).locked = locked;
	}

	/**
	 * Define o número de pontos de concentração da spell.
	 * 
	 * @param c
	 */
	public void setConcentration(int c) {
		((SpellVO) this.data).concentration = c;
	}

	/**
	 * Adiciona pontos de concentração na spell e dispara o método onEnergize da
	 * mesma logo em seguida.
	 * 
	 * @param i
	 */
	public void addConcentration(int i) {
		int value = this.getConcentration() + i;
		this.setConcentration((value < 0) ? 0 : value);

		// don't dispatch ON_ENERGIZE if are reducing concentration points
		if (i > 0) {
			dispatchEvent(ON_ENERGIZE);
		}
	}

	/**
	 * Define se a spell foi selecionada para cast.
	 * 
	 * @param bool
	 */
	public void setSelected(boolean bool) {
		((SpellVO) this.data).selected = bool;
	}

	/**
	 * Define se a spell será utilizada neste turno.
	 * 
	 * @param bool
	 */
	public void setCasting(boolean bool) {
		((SpellVO) this.data).casting = bool;
	}

	/**
	 * Verifica se a spell está sendo utilizada neste turno.
	 * 
	 * @return
	 */
	public boolean isCasting() {
		return ((SpellVO) this.data).casting;
	}

	/**
	 * Permuta entre o estado selecionado e deselecionado para cast.
	 */
	public void swapSelected() {
		((SpellVO) this.data).selected = !this.isSelected();
	}
	
	/**
	 * Verifica se esta spell pode ser concentrada.
	 * @return boolean
	 */
	public boolean canEnergize() {
		ISpellCommand listener = (ISpellCommand) this.getCommandListener();
		return (listener != null) ? listener.canEnergize() : true;
	}

	/**
	 * Troca a posição desta spell com a spell de posição "pos" na lista. 
	 * TODO: Não está sendo definido se o swap é na lista do Oponente ou do Jogador.
	 * 
	 * @param pos
	 */
	public void swapPosition(int pos) {
		SpellVO self = (SpellVO) this.data;

		SpellListProxy spellList = (SpellListProxy) facade.retrieveProxy(SpellListProxy.NAME);
		SpellVO other = (SpellVO) spellList.getSpellAt(pos).getData();

		int selfPosition = self.position;
		self.position = other.position;
		other.position = selfPosition;

		this.setData(self);
		dispatchEvent(ON_SWAP_POSITION);
	}

	/**
	 * Dispara um evento desta spell. Os eventos disponíveis são ON_CAST,
	 * ON_SWAP_POSITION, ON_ENERGIZE, ON_TURN_END e ON_TURN_BEGIN
	 * 
	 * @param eventType
	 */
	public void dispatchEvent(String eventType) {
		ICommand listener = this.getCommandListener();
		
		/*
		 * TODO: o listener deve estar presente no startup para poder disparar 
		 * eventos das stones do adversário
		 */
		
		if (listener != null) {
			listener.execute(new Notification(eventType, this.getData(), null));
		}
	}

	/**
	 * Dispara o evento onCast desta spell.
	 */
	public void cast() {
		this.setSelected(false);
		this.setCasting(true);
		dispatchEvent(ON_CAST);
		this.addConcentration(-this.getCost());
	}

	/**
	 * Transforma esta spell à partir de um array de bytes.
	 * 
	 * @param bytes
	 */
	public void fromByteArray(byte[] bytes) {
		ByteArrayInputStream is = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(is);
		try {
			this.readFromStream(dis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Transforma esta spell à partir de de um DataInputStream
	 */
	public void readFromStream(DataInputStream dis) throws Exception {
		this.setId(dis.readInt());
		this.setName(dis.readUTF());
		this.setDescription(dis.readUTF());
		this.setColor(dis.readInt());
		this.setImage(ResourceLibrary.fromStream(dis));
		this.setPosition(dis.readInt());
		this.setCost(dis.readInt());
		this.setConcentration(dis.readInt());
		this.setLocked(dis.readBoolean());
		this.setSelected(dis.readBoolean());
		this.setCasting(dis.readBoolean());
	}

	/**
	 * Obtém a representação desta spell em um array de bytes.
	 * 
	 * @return byte[]
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
	 * Escreve a representação desta spell em um DataOutputStream
	 */
	public void writeToStream(DataOutputStream dos) throws Exception {
		dos.writeInt(this.getId());
		dos.writeUTF(this.getName());
		dos.writeUTF(this.getDescription());
		dos.writeInt(this.getColor());
		dos.write(ResourceLibrary.toByteArray(this.getImage()));
		dos.writeInt(this.getPosition());
		dos.writeInt(this.getCost());
		dos.writeInt(this.getConcentration());
		dos.writeBoolean(this.isLocked());
		dos.writeBoolean(this.isSelected());
		dos.writeBoolean(this.isCasting());
	}
}
