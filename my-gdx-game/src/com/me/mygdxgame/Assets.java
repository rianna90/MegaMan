package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
	public static Texture splash;
	public static Texture bg;
	public static Texture playBtn;
	public static Texture background;
	public static Texture megaman;	
	public static Animation megamanWalk;
	public static Texture platformBase;
	public static Texture platformMiddle;
	public static Texture btn;
	
	public static Texture loadTexture (String file){
		return new Texture(Gdx.files.internal(file));
	}
		
	public static void load(){
		
		splash = loadTexture("libgdx.png");
			
		bg = loadTexture("bg.jpg");	
		playBtn = loadTexture("playButton.png");
		
		megaman = loadTexture("megaman.png");	
		background = loadTexture("background.jpg");	
		background = loadTexture("background.jpg");
		platformBase = loadTexture("bottomGround.png");
		platformMiddle = loadTexture("floatGroundMiddle.png");
		
		btn = loadTexture("btn.png");	
		megamanWalk = new Animation(0.2f, new TextureRegion(megaman, 0, 0, 36, 33), new TextureRegion(megaman, 33, 0, 36, 33));		

	}

}




