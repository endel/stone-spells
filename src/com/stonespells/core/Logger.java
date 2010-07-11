package com.stonespells.core;

import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;

public class Logger {

	
	public static Logger instance = new Logger();
	

	private RecordStore store;
	
	
	public Logger(){

		try {
			store = RecordStore.openRecordStore("log", true, RecordStore.AUTHMODE_ANY, false);
			RecordEnumeration re = store.enumerateRecords(null, null, false);
			while (re.hasNextElement()) {
				store.deleteRecord(re.nextRecordId());
			}
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void println(String txt){
		System.out.println(txt);
		/*try {
			store.addRecord(txt.getBytes(), 0, txt.getBytes().length);
			System.out.println(txt);
		} catch (RecordStoreNotOpenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void println(Exception e) {
		this.println(e.getMessage());
	}
	
	public void println(int i) {
		this.println(String.valueOf(i));
	}
}