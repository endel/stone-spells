package com.stonespells.controllers;

import org.puremvc.java.interfaces.ICommand;
import org.puremvc.java.interfaces.INotification;
import org.puremvc.java.patterns.command.SimpleCommand;

import com.stonespells.facade.GameFacade;

public class ExitCommand extends SimpleCommand implements ICommand {
	
	public void execute(INotification notification) {
		
		((GameFacade) facade).getApp().notifyDestroyed();
		
	}

}
