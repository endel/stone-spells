package com.stonespells.core;

import javax.microedition.lcdui.Graphics;

public interface IGameView extends IRenderable {
	
	void initializeView() throws Exception;
	void destroy();
	Graphics getGraphics();
	
}
