package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	
	public static Texture background;
<<<<<<< HEAD
=======
	public static Texture megaman;
	public static Animation megamanWalk;
	
>>>>>>> Megaman animatie (nog niet werkend)
	public static Texture loadTexture (String file){
		return new Texture(Gdx.files.internal(file));
	}
		
	public static void load(){
		megaman = loadTexture("megaman.png");		
		background = loadTexture("background.jpg");
		
		megamanWalk = new Animation(0.2f, new TextureRegion(megaman, 0, 0, 36, 33), new TextureRegion(megaman, 33, 0, 36, 33));		
	}

}




