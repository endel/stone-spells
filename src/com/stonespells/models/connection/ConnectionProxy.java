package com.stonespells.models.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

/**
 * Classe que trata a troca de dados entre cliente e servidor.
 */
public abstract class ConnectionProxy extends Proxy implements IProxy {
	
	public static String PROXY_NAME = "";
	
	// Communication protocol
	public static final int GAME_BOARD_CONFIG = 50;
	public static final int END_GAME = 51;
	
	protected DiscoveryAgent discoveryAgent;
	protected LocalDevice localDevice;
	protected StreamConnectionNotifier connectionNotifier;
	protected StreamConnection conn;
	
	protected DataOutputStream dos = null;
	protected DataInputStream dis = null;
	
	/**
	 * Construtor que aloca um nome para a parte corrente da conexão.
	 * @param proxyName O nome passado para a aprte corrente da conexão.
	 * @param data Objeto com conjunto de dados a ser tratado pelo proxy.
	 */
	public ConnectionProxy(String proxyName, Object data) {
		super(proxyName, data);
		PROXY_NAME = proxyName;
	}
	
	/**
	 * Método que obtém a conexão que possui fluxo de entrada e saída
	 * de dados.
	 * @return Conexão que faz a comunicação entre os jogadores.
	 */
	public StreamConnection getStreamConnection() {
		return conn;
	}
	
	/**
	 * Método que obtém um fluxo de entrada de dados para uma das partees da conexão.
	 * @return Fluxo de entrada de dados.
	 */
	public DataInputStream getDataInputStream() {
		if (dis == null) {
			try {
				dis = conn.openDataInputStream();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dis;
	}
	
	/** Método que obtém um fluxo de entrada de dados para uma das partees da conexão.
	 * @return Fluxo de saída de dados.
	 */
	public DataOutputStream getDataOutputStream() {
		if (dos == null) {
			try {
				dos = conn.openDataOutputStream();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dos;
	}

}