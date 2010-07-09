package com.stonespells.core;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;

public class LogView extends MIDlet implements CommandListener {

	protected void destroyApp(boolean unconditional)
			throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		Form f = new Form("Log View");
		Command cmdExit = new Command("Exit",Command.EXIT,0);
		f.addCommand(cmdExit);
		f.setCommandListener(this);
		
		try {
			System.out.println("sasa");
			RecordStore rs = RecordStore.openRecordStore("log", false);
			
			RecordEnumeration renum = rs.enumerateRecords(null, null, false);
			while(renum.hasNextElement()){
				f.append(new String(renum.nextRecord())+"\n");
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
		Display.getDisplay(this).setCurrent(f);

	}

	public void commandAction(Command c, Displayable d) {
		if(c.getLabel().equals("Exit")){
			notifyDestroyed();
		}
		
	}

}
