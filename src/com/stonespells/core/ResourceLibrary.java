package com.stonespells.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;


/**
 * Classe que trata do carregamente de imagens e do parseamento de bytes/dados.
 */
public class ResourceLibrary {
	public static Image STONE_TITLE;
	public static Image ENERGY_ICON;
	public static Image ENERGIZE_TITLE;
	
	public static Image SPELL_LOCKED_ICON;
	public static Image SPELL_CAN_CAST_ICON;
	public static Image SPELL_SELECT_ICON;
	
	// Menu options
	public static Image OPTION_VIEW;
	public static Image OPTION_CAST;
	public static Image OPTION_END_TURN;
	public static Image OPTION_BACK;
	public static Image OPTION_CLOSE;
	
	public static Player MUSIC_BACKGROUND;
	public static Player MUSIC_SOLO;
	
	static {
		try {
			STONE_TITLE = Image.createImage("/icons/title-stone.png");
			ENERGY_ICON = Image.createImage("/icons/energy-large.png");
			ENERGIZE_TITLE = Image.createImage("/menu-options/energize.png");
			
			SPELL_LOCKED_ICON = Image.createImage("/icons/cant-cast.png");
			SPELL_CAN_CAST_ICON = Image.createImage("/icons/can-cast.png");
			SPELL_SELECT_ICON = Image.createImage("/icons/select-stone.png");
			
			// Menu options
			OPTION_VIEW = Image.createImage("/menu-options/view.png");
			OPTION_CAST = Image.createImage("/menu-options/cast.png");
			OPTION_END_TURN = Image.createImage("/menu-options/end-my-turn.png");
			OPTION_BACK = Image.createImage("/menu-options/back.png");
			OPTION_CLOSE = Image.createImage("/menu-options/close.png");

			// MUSIC_BACKGROUND = Manager.createPlayer(((GameFacade)GameFacade.getInstance()).getApp().getClass().getResourceAsStream("/sound/mystic-base.mid"), "audio/midi");
			// MUSIC_SOLO = Manager.createPlayer(((GameFacade)GameFacade.getInstance()).getApp().getClass().getResourceAsStream("/sound/mystic-solo.mid"), "audio/midi");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Converte propriedades da imagem para um array de bytes.

	 */
	public static byte[] toByteArray(Image img) throws Exception {
		int[] argb = new int[img.getWidth() * img.getHeight()];
		img.getRGB(argb, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());

		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		DataOutputStream dos = new DataOutputStream( baos );
		dos.writeInt( img.getWidth() );
		dos.writeInt( img.getHeight() );
		dos.writeLong( argb.length );
		for( int i = 0; i < argb.length; i++ )	{
			dos.writeInt( argb[i] );
		}
		dos.flush();
		return baos.toByteArray();
	}
	
	/**
	 * Carrega uma imagem a partir de uma stream de dados.
	 * @param dis
	 * @return
	 */
	public static Image fromStream(DataInputStream dis) {
		Image img = null;
		try {
			int width = dis.readInt();
			int height = dis.readInt();
			long length = dis.readLong();
			
			int[] data = new int[width*height];
			for( int i = 0; i < length; i++ ) {
				data[i] = dis.readInt();
			}
			img = Image.createRGBImage(data, width, height, true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
	
	/**
	 * Carrega uma imagem a partir de um array de bytes.
	 * @param bytes
	 * @return
	 */
	public static Image fromByteArray(byte[] bytes) {
		ByteArrayInputStream is = new ByteArrayInputStream(bytes);
		DataInputStream dis = new DataInputStream(is);
		Image img = null;
		try {
			img = fromStream(dis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
}
