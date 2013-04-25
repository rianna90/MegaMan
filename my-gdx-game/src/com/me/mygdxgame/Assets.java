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
		
		splash = loadTexture("libgdx.png");
			
		bg = loadTexture("bg.png");	
		playBtn = loadTexture("playButton.png");
		pauseBtn = loadTexture("pauseButton.png");
		resumeBtn = loadTexture("resumeButton.png");
		mainBtn = loadTexture("mainButton.png");
		
		megaman = loadTexture("megaman.png");	
		megamanJump = loadTexture("manjump.png");
		background = loadTexture("background.png");	
		//background = loadTexture("background.jpg");
		platformBase = loadTexture("bottomGround.png");
		platformMiddle = loadTexture("floatGroundMiddle.png");
		menubg = loadTexture("menubg.png");
		homebg = loadTexture("homebg.png");
		charfullbody = loadTexture("charfullbody.png");
		coin = loadTexture("coin.png");

		font = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
		
		btn = loadTexture("btn.png");	
	}
}




