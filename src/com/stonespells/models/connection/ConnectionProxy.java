package com.stonespells.models.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

import org.puremvc.java.interfaces.IProxy;
import org.puremvc.java.patterns.proxy.Proxy;

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
	
	public ConnectionProxy(String proxyName, Object data) {
		super(proxyName, data);
		PROXY_NAME = proxyName;
	}
	
	public StreamConnection getStreamConnection() {
		return conn;
	}
	
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