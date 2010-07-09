package com.stonespells.models.connection;

import java.util.Vector;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

import org.puremvc.java.interfaces.IProxy;

import com.stonespells.views.preconnection.PreConnectionMediator;

/**
 *	Classe que trata os dados e efetua a conexão bluetooth do cliente.
 */
public class ClientProxy extends ConnectionProxy implements IProxy, DiscoveryListener {
	
	public static String NAME = "ClientProxy";
	
	// Notifications
	// public static String SERVERS_FETCHED = "ClientServersFetched"; 
	
	private Vector vector;
	private ServiceRecord service;
	
	/**
	 * Construtor que instancia o conjunto de dados do cliente.
	 */
	public ClientProxy() {
		super(NAME, new ClientVO());
	}
	
	/**
	 * Método que busca um agente para buscar um dispositivo em que o
	 * cliente possa conectar-se.
	 */
	public void connect() throws Exception {
		localDevice = LocalDevice.getLocalDevice();
		
		vector = new Vector();
		localDevice.setDiscoverable(DiscoveryAgent.GIAC);
		discoveryAgent = localDevice.getDiscoveryAgent();
		discoveryAgent.startInquiry(DiscoveryAgent.GIAC, this);
	}
	
	/**
	 * Método que adiciona o elemento encontrado para conexão em um Vector.
	 */
	public void deviceDiscovered(RemoteDevice remoteDevice, DeviceClass dc) {
		vector.addElement( remoteDevice );
	}

	/**
	 * Método que faz a busca no Vector de elementos encontrados para conexão.
	 */
	public void inquiryCompleted(int arg0) {
		UUID ids[] = { ServerProxy.SERVICE_UUID };

		System.out.println("Encontrei " + vector.size() + " clientes.");
		for (int i = 0; i < vector.size(); i++) {
			RemoteDevice rd = (RemoteDevice) vector.elementAt(i);
			try {
				discoveryAgent.searchServices(null, ids, rd, this);		
			} catch (BluetoothStateException e) {
				e.printStackTrace();
			}
		}		
	}

	 /**
	  * Método que efetua a conexão do cliente no servidor encontrado.
	  * Se nenhum servidor houver sido encontrado, o método retorna.
	  */
	public void serviceSearchCompleted(int arg0, int arg1) {
		// TODO: 	Deixar que o cliente selecione o servidor 
		// 			que deseja conectar ao invés de conectar 
		//			automaticamente com o primeiro encontrado
		// sendNotification(PreConnectionMediator.VIEW_CONNECTIONS_LIST, this.getServiceList(), type)
		
		if(service == null){
			System.out.println("Nenhum serviço encontrado.");
			return;
		}
		
		String url = service.getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
		
		try {
			conn = (StreamConnection) Connector.open(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sendNotification(PreConnectionMediator.CONNECTION_ACCEPTED, null, null);
	}

	/**
	 * Método que trata o servidor descoberto, adicionando ele a um alista de servidores.
	 */
	public void servicesDiscovered(int arg0, ServiceRecord[] serviceList) {
		System.out.println("servicesDiscovered => " + arg0 + "   " + serviceList.length);
		this.service = serviceList[0];
		//this.services = serviceList;
	}
	
	/*public Hashtable getServiceList() {
		Hashtable serviceList = new Hashtable(this.services.length);
		for (int i=0;i<this.services.length;i++) {
			serviceList.put(services[i].getHostDevice(), services[i]);
		}
		return serviceList;
	}*/
	
	
	
}
