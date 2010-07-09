package com.stonespells.models.connection;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnectionNotifier;

import org.puremvc.java.interfaces.IProxy;

import com.stonespells.views.preconnection.PreConnectionMediator;

/**
 * Classe que trata da parte do servidor bluetooth para a conexão de um 
 * cliente.
 */
public class ServerProxy extends ConnectionProxy implements IProxy, Runnable {
	
	public static final String NAME = "ServerProxy";
	
	private static final String serviceName = "StoneSpells";
	private static final String serviceUUID = "25eab5c4b05c2b9fe404bba6662d8c87";
	public static UUID SERVICE_UUID = new UUID(serviceUUID, false);
	private String connURL;
	
	public static int MSG_LIST_USERS = 100;
	public static int MSG_INIT = 101;
	
	/**
	 * Construtor que atribui um nome ao servidor.
	 */
	public ServerProxy() {
		super(NAME, new ServerVO());
		this.connURL = "btspp://localhost:" + SERVICE_UUID.toString() + ";name=" + serviceName+";authenticate=false;encrypt=false";
	}
	
	/**
	 * Método que possibilita a descoberta do servidor para o cliente a conectar-se.
	 * @throws Exception
	 */
	public void create() throws Exception {
		localDevice = null;
		localDevice = LocalDevice.getLocalDevice();
		localDevice.setDiscoverable( DiscoveryAgent.GIAC );
		
		Thread thread = new Thread(this);
		thread.start();
	}

	/**
	 * Método que abre o objeto para a conexão e automaticamente aceita
	 * o cliente que requisita a conexão, notificando o cliente de que a conexão
	 * foi efetuada.
	 */
	public void run() {
		try {
			connectionNotifier = (StreamConnectionNotifier) Connector.open( this.connURL );
			conn = connectionNotifier.acceptAndOpen();
			
			sendNotification(PreConnectionMediator.CONNECTION_ACCEPTED, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
