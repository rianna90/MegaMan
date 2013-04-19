package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
	public static Texture background;
	public static Texture megaman;	

	public static Texture loadTexture (String file){
		return new Texture(Gdx.files.internal(file));
	}
		
	public static void load(){
		megaman = loadTexture("megaman.png");		
		background = loadTexture("background.jpg");	
	}

}




