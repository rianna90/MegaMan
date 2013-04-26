package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets{
	
	public static Texture splash;
	public static Texture bg;
	public static Texture playBtn;
	public static Texture pauseBtn;
	public static Texture resumeBtn;
	public static Texture mainBtn;	
	public static Texture background;
	public static Texture megaman;	
	public static Texture megamanJump;
	public static Texture platformBase;
	public static Texture platformMiddle;	
	public static Texture btn;
	public static Texture menubg;
	public static Texture homebg;
	public static Texture charfullbody;
	public static BitmapFont font;
	public static Texture coin;
	
	public static Texture loadTexture (String file){
		return new Texture(Gdx.files.internal(file));
	}
		
	public static void load(){
		// Splashscreen
		splash = loadTexture("splashScreen.jpg");
		// Menu's
		bg = loadTexture("bg.jpg");	
		
		playBtn = loadTexture("playButton.jpg");
		pauseBtn = loadTexture("pauseButton.jpg");
		resumeBtn = loadTexture("resumeButton.jpg");
		mainBtn = loadTexture("mainButton.jpg");	
		menubg = loadTexture("menubg.jpg");
		homebg = loadTexture("homebg.jpg");
		charfullbody = loadTexture("charfullbody.jpg");
		// Megaman 
		megaman = loadTexture("megaman.jpg");	
		megamanJump = loadTexture("manjump.jpg");
		// Level
		btn = loadTexture("btn.jpg");
		platformBase = loadTexture("bottomGround.jpg");
		platformMiddle = loadTexture("floatGroundMiddle.jpg");		
		coin = loadTexture("coin.jpg");
		// Fonts
		font = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.jpg"), false);			
	}
}




