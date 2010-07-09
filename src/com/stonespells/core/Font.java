package com.stonespells.core;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public class Font {
    // additional space between characters
    public int charS = 0;
    
    // max clipping area
    public int screenW = App.WIDTH;
    public int screenH = App.HEIGHT;
    
    // flag: set to true to use the Graphics.drawString() method
    // this is just used as a fail-safe
    public boolean useDefault = false;
    
    // height of characters
    public static int charH = 14;
    public static int charW = 8;
    
    // the bitmap font image
    private Image bitmapFont;
    
    /** Creates a new instance of Font */
    public Font(String imagePath) {
    	this.load(imagePath);
    }
    
    public boolean load(String imagePath){
        try{
            // load the bitmap font
            if (bitmapFont != null){
                bitmapFont = null;
            }
            bitmapFont = Image.createImage(imagePath);
        } catch (Exception ex){
            // oohh we got an error then use the fail-safe
            useDefault = true;
        }
        return (!useDefault);
    }
    
    public void unload(){
        // make sure the object get's destroyed
        bitmapFont = null;
    }
    
    public void drawChar(Graphics g, int cIndex, int x, int y, int w, int h){
         // non printable characters don't need to be drawn
        if (cIndex < 33){
            return;
        }

        // neither does the delete character 
        if (cIndex > 126){
            return;
        }

        // get the characters position
        int cx = cIndex;

        // reset the clipping rectangle
        g.setClip(0, 0, screenW, screenH);

        // resize and reposition the clipping rectangle
        // to where the character must be drawn
        g.clipRect(x, y, w, h);
        
        // draw the character inside the clipping rectangle
        // g.drawImage(bitmapFont, x - cx, y, Graphics.TOP | Graphics.LEFT);
        g.drawImage(bitmapFont, -((cx * w - x) -2 - (4*w)), y, Graphics.TOP | Graphics.LEFT);
    }
    
    public void drawString(Graphics g, String sTxt, int x, int y){
        // get the strings length
        int len = sTxt.length();

        // set the starting position
        int cx = x;
        
        // if nothing to draw return
        if (len == 0) {
            return;
        }
        
        // our fail-safe
        if (useDefault){
        	Logger.instance.println("font in fail-safe mode");
            g.drawString(sTxt, x, y, Graphics.TOP | Graphics.LEFT);
            return;
        }

        // loop through all the characters in the string      
        for (int i = 0; i < len; i++){

           // get current character 
           char c = sTxt.charAt(i);

           // get ordinal value or ASCII equivalent
           int cIndex = (int)c;

           // lookup the width of the character
           //int w = charW;

           // draw the character
           drawChar(g, cIndex, cx, y, charW, charH);

           // go to the next drawing position
           cx += (charW-2 + charS);
        }
    }
    
}